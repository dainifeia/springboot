import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author xuzexiang
 * @Date: 2018-10-16 0016
 * @Description:    测试java8 的 时间日期api   （使用时区的日期时间api）
 */
public class TestZonedDateTime {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("时区转时间"+zonedDateTime);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

}
