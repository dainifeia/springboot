import java.text.Collator;
import java.util.*;

/**
 * @author xuzexiang
 * @Date: 2018-10-15 0015
 * @Description:
 */
public class TestLambda extends  Thread{
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C");
        Collections.sort(list, (o1, o2) -> Collator.getInstance().compare(o1,o2));
        //TestFunction t = a -> Integer.parseInt(a);//lambda
        TestFunction t =  Integer::parseInt;//使用::传递  静态方法的引用
        Integer tt = t.test1("aaa");
       // System.out.println(tt);


        List names = new ArrayList();
        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println); //使用::传递  静态方法的引用
    }
}
