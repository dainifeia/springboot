import java.util.Objects;
import java.util.Optional;

/**
 * @author xuzexiang
 * @Date: 2018-10-15 0015
 * @Description:    Optional类用来解决空指针异常
 */
public class TestOptional {
    public static void main(String[] args) {
        User u = null;
        Optional<User> op1 = Optional.of(u);

        User u2  = Objects.requireNonNull(u);
        System.out.println(u2);

    }
}
