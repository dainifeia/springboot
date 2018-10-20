import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author xuzexiang
 * @Date: 2018-10-16 0016
 * @Description:    测试java8 的 时间日期api   （本地化日期时间api）
 */
public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间:"+localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("localdate:"+localDate);

        int year = localDateTime.getYear();
        int month =  localDateTime.getMonthValue();
        int month2 = localDateTime.getDayOfMonth();
        int dayNum = localDateTime.getDayOfYear();
        System.out.println("当前年:"+year+",当前月份："+month+",日："+month2+",第"+dayNum+"天");

        //日期转字符串
        String time = localDateTime.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("格式化当前时间为指定形式："+time);

        //字符串转日期 注意2个参数的字符串格式要相同
        LocalDateTime time1 = LocalDateTime.parse("2018-03-02 23:22:59",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("将指定格式的字符串转为日期"+time1);

        String str1="2018-07-05 12:24:12";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(str1, dtf);
        System.out.println(parse);

        //LocalDate用来获取日期中的年月日
        LocalDate localDate1 =  LocalDate.of(2014,02,21);
        System.out.println("localdate:"+localDate1);

        //LocalTime用来获取日期中的时分秒
        LocalTime date4 = LocalTime.of(22, 15,59);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}
