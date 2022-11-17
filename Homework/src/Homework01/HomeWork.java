package Homework01;

import java.util.ArrayList;
@SuppressWarnings({"all"})
public class HomeWork {
    public static void main(String[] args) {


        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("特朗普被狗日了"));
        arrayList.add(new News("蔡徐坤打篮球蔡徐坤打篮球蔡徐坤打篮球蔡徐坤打篮球蔡徐坤打篮球"));
        for (int i = arrayList.size()-1; i >=0; i--) {
            News news = (News) arrayList.get(i);

            System.out.println(processTitle(news.getTitle()));
        }
    }
    public static String processTitle(String title){
        if (title==null){
            return "";
        }
        if (title.length()>15){

            return   title.substring(0,15)+"...";
        }else {
            return title;
        }

    }
}
class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title +
                '}';
    }
}