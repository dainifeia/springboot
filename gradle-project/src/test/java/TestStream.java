import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author xuzexiang
 * @Date: 2018-10-15 0015
 * @Description:
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(toList());
        System.out.println(filtered);

        /**
         * 最常用的为使用静态方法创建
         */
        IntStream.of(new int[] {1, 2, 3}).forEach(System.out::println);
        IntStream.range(0, 3).forEach(System.out::println);
        IntStream.rangeClosed(2, 3).forEach(System.out::println);

        /**
         * 统计集合中字符串长度小于5的数量
         * filter操作。即使原stream中满足条件的元素构成新的stream
         */
        List<String> list = Arrays.asList("java", "scala", "python", "shell", "ruby");
        long num = list.parallelStream().filter(x -> x.length() < 5).count();
        System.out.println("数量："+num);

        /**
         * .map操作。map算是最常用的一种操作了，遍历原stream中的元素，转换后构成新的stream：
         */
        List<String> list2 = Arrays.asList(new String[] {"a", "b", "c"});
        List<String> result = list2.stream().map(String::toUpperCase).collect(toList());
        result.forEach(x -> System.out.println(x + " "));

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(toList());
        squaresList.forEach(x-> System.out.println("map平方数"+x+" "));
        /**
         *distinct操作。distinct也是常用的操作之一。
         * distinct去除集合中重复的元素
         */
        Stream<String> distinctStream = Stream.of("bj","shanghai","tianjin","bj","shanghai").distinct();
        Stream<String> sortedStream = distinctStream.sorted(Comparator.comparing(String::length));
        sortedStream.forEach(x -> System.out.print(x + " "));

        System.out.println();


        /**
         *  排序操作
         */
        Stream<Integer> sortedStream2 = Stream.of(1,3,7,4,5,8,6,2).sorted();
        sortedStream2.collect(toList()).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Stream<Integer> sortedReverseStream = Stream.of(1,3,7,4,5,8,6,2).sorted(Comparator.comparingInt(o -> o));
        Stream<Integer> sortedReverseStreamV2 = Stream.of(1,3,7,4,5,8,6,2).sorted((Integer o1, Integer o2) -> o2 - o1);
        sortedReverseStreamV2.collect(toList()).forEach(x -> System.out.print(x + " "));

        /**
         * filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
         */
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        Long count = strings2.stream().filter(string ->string.isEmpty()).count();
        System.out.println(count);
        /**
         * limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
         */
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        /**
         *sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序
         */
        System.out.println("随机数");
        Random randoms = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println("----");

        /**
         * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
         */
        List<String> strings22 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered2 = strings22.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered2);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        /**
         * 统计
         另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
         */
        List<Integer> numberlist = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numberlist.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


    }
}
