package Plugin;

public class Test {

    public static void main(String[] args) {
        DataWeb d = new DataWeb();
        d.parseSource("https://www.yelp.com/search?find_desc=Restaurants&find_loc=Pittsburgh%2C+PA&ns=1");
    }

}
