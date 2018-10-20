/**
 * @author xuzexiang
 * @Date: 2018-10-17 0017
 * @Description:
 */
public class TestByte {
    public static void main(String[] args) {
        String msg = "中";
        System.out.println(msg);
        int len = msg.getBytes().length;//按操作系统默认编码来编码
        System.out.println(len);
        try{
            len = msg.getBytes("GB2312").length;//输出7
            System.out.println("GB2312: "+len);
            len = msg.getBytes("GBK").length;//输出7
            System.out.println("GBK: "+len);
            len = msg.getBytes("GB18030").length;//输出7, 2*2+3,一个汉字占2字节,一个英文字母一个字节
            System.out.println("GB18030: "+len);
            len = msg.getBytes("UTF-8").length;//输出9, 2*3+3=9,一个汉字占3字节,一个英文字母一个字节.
            System.out.println("UTF-8: "+len);
            len = msg.getBytes("UTF-16").length;//输出12
            System.out.println("UTF-16: "+len);
            len = msg.getBytes("UTF-32").length;//输出20
            System.out.println("UTF-32: "+len);
            len = msg.getBytes("Unicode").length;//输出12
            System.out.println("Unicode: "+len);
        } catch ( java.io.UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage().toString());
        }
    }
}
