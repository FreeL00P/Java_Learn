import java.util.Arrays;
import java.util.Comparator;

public class TestArray {
    public static void main(String[] args) {
        Book[] books=new Book[4];
        books[0]=new Book("1红楼梦",6);
        books[1]=new Book("333红楼梦",60);
        books[2]=new Book("22红楼梦",45);
        books[3]=new Book("3333333红楼梦",54);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double c=o1.getPrice()-o2.getPrice();
                if (c>0){
                    return 1;
                }else if(c<0){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double c=o1.getName().length()-o2.getName().length();
                if (c>0){
                    return 1;
                }else if(c<0){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
class Book{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
