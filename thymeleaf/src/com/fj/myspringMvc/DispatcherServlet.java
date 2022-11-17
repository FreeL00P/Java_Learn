package com.fj.myspringMvc;

import com.fj.fruit.util.StringUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/31 14:28    since 1.0.0
 */
@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {
    private Map<String,Object> beanMap=new HashMap<String,Object>();
    public DispatcherServlet() {

    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            //解析
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/applicationContext.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //创建Document对象
            Document document= documentBuilder.parse(inputStream);
            NodeList beanNodeList = document.getElementsByTagName("bean");
            for (int i = 0; i <beanNodeList.getLength() ; i++) {
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType()==Node.ELEMENT_NODE){
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String className=beanElement.getAttribute("class");
                    Class controllerBeanClass =Class.forName(className);
                    Object beanObj=Class.forName(className).newInstance();
                    beanMap.put(beanId,beanObj);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //url-->http://localhost:8080/thymeleaf_war_exploded/fruit.do
        //则 servletPath-->/fruit.do
        String servletPath = req.getServletPath();
        servletPath=servletPath.substring(1);// /fruit.do -->fruit.do
        int lastIndex=servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0, lastIndex);
        Object controllerObj = beanMap.get(servletPath);
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String operate = req.getParameter("operate");
        if (StringUtil.isEmpty(operate)){
            operate="index";
        }
        try {
            Method[] methods = controllerObj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (operate.equals(method.getName())){
                    //统一获取请求参数
                    Parameter[] parameters = method.getParameters();//通过反射返回参数数组
                    Object[] parameterValues=new Object[parameters.length];//存放参数的值
                    for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter=parameters[i];
                        String  parameterName=parameter.getName();
                        if ("req".equals(parameterName)){
                            parameterValues[i]=req;
                        }else if ("resp".equals(parameterName)){
                            parameterValues[i]=resp;
                        }else if ("session".equals(parameterName)){
                            parameterValues[i]=req.getSession();
                        }else {
                            String parameterValue=req.getParameter(parameterName);//从请求中获取参数值
                            String typeName=parameter.getType().getName();
                            Object parameterObj=parameterValue;
                            if (parameterObj!=null){
                                if("java.lang.Integer".equals(typeName)){
                                    parameterObj=Integer.parseInt(parameterValue);
                                }
                            }
                            parameterValues[i]=parameterObj;
                        }
                    }
                    //controller组件中的方法调用
                    method.setAccessible(true);
                    Object returnObj = method.invoke(controllerObj,parameterValues);
                    //视图处理
                    String methodReturnStr=(String) returnObj;
                    if(methodReturnStr.startsWith("redirect:")){
                        String redirectStr = methodReturnStr.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);//重定向
                    }else {
                        super.processTemplate(methodReturnStr,req,resp);
                    }
                }
            }
        } catch ( IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
