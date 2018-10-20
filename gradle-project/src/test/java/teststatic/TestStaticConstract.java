package teststatic;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:    静态代码块 构造代码块 构造方法的执行顺序及注意问题
 */
public class TestStaticConstract {
    public static void main(String[] args) {
        Zi zi = new Zi();
    }

}

class Fu{
    static {
        System.out.println("Fu static code");
    }
    {
        System.out.println("Fu code");
    }
    public Fu(){
        System.out.println("Fu GouZao");
    }
}
class Zi extends Fu{
    static {
        System.out.println("Zi static code");
    }
    {
        System.out.println("Zi code");
    }
    public Zi(){
        super();
        System.out.println("Zi GouZao");
    }
}

