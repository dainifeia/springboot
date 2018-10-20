import java.util.function.Function;

/**
 * @author xuzexiang
 * @Date: 2018-10-15 0015
 * @Description:    测试java8的function接口
 *
 */
public class TestFunctions {
    public static void main(String[] args) {
        Function<String,Boolean> f1 = s1 -> s1 !=null;
        Function<Boolean,Integer> f2 = b -> b ? 1 : 0;
        //Function的andThen方法：将f1的返回结果做为f2的输入，最后返回f2的结果,
        // 注意Function<String,Integer>，左边相当于f1的返回结果，右边是f2的返回结果
        Function<String,Integer> ss =  f1.andThen(f2);
        Integer apply =  ss.apply("aa");
        System.out.println(apply);
        /**
         *  Function的compose方法：将f1的返回结果做为f2的输入，最后返回f2的结果,
         *  注意Function<String,Integer>，左边相当于f1的返回结果，右边是f2的返回结果
         */
        Function<String,Integer> ss2 =  f2.compose(f1);
        Integer apply2 = ss2.apply("ssa");
        System.out.println(apply2);
    }
}
