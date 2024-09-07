package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class TestMiscellaneous {

    /**
     * 对 int[] 数组排序的多种 api
     * 1. Arrays.sort()
     * 2. Arrays.parallelSort()
     *
     */
    @Test
    public void testSort1(){
        int[] nums = {3, 2, 4, 6, 1, 5, 9, 0, 8, 7};
        // Arrays.sort()  默认升序 降序需要自己实现 Comparator 接口
        Arrays.sort(nums);  // 原地排序
        System.out.println(Arrays.toString(nums));

        nums = new int[]{3, 2, 4, 6, 1, 5, 9, 0, 8, 7};
        // Arrays.parallelSort()  默认升序 降序需要自己实现 Comparator 接口
        Arrays.parallelSort(nums);  // 原地排序
        System.out.println(Arrays.toString(nums));


        nums = new int[]{3, 2, 4, 6, 1, 5, 9, 0, 8, 7};
//        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Arrays.sort(integers, Collections.reverseOrder());

        Double[] sortedNums = Arrays.stream(nums)  // 将int数组转换为流
                .boxed()  // 将int转换为Integer
                .sorted(Comparator.reverseOrder())  // 降序排序
//                .mapToLong(Integer::longValue)  // 转换回long类型
//                .mapToInt(Integer::intValue)  // 转换回int类型
                .mapToDouble(Integer::doubleValue)  // 转换回double类型
                .boxed()
                .toArray(Double[]::new);  // 转换为int数组
        System.out.println(Arrays.toString(sortedNums));

        // 将 int[] 转换为 ArrayList<Integer>
        List<Integer> list = Arrays.stream(nums).boxed().toList();
//        ArrayList<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        list.forEach(System.out::print);


    }

    /**
     * 对 ArrayList<Integer> 排序的多种 api
     * 1. Collections.sort()
     * 2. Collections.reverseOrder()
     * 3. ArrayList.sort()
     * 4. ArrayList.parallelSort()
     */
    @Test
    public void testSort2(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 2, 4, 6, 1, 5, 9, 0, 8, 7));
        // Collections.sort() 默认升序 降序需要自己实现 Comparator 接口
//        Collections.sort(list, Collections.reverseOrder());  // 原地排序
        Collections.sort(list, MyUtils::cmp);  // 原地排序
        System.out.println(list);

        list = new ArrayList<>(Arrays.asList(3, 2, 4, 6, 1, 5, 9, 0, 8, 7));
        // ArrayList.sort() 默认升序 降序需要自己实现 Comparator 接口
        list.sort(Comparator.reverseOrder());  // 原地排序
//        list.sort((Integer o1, Integer o2) -> o2 - o1);  // 原地排序
//        list.sort(MyUtils::cmp);  // 原地排序
        System.out.println(list);


        Character[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        ArrayList<Character> charList = new ArrayList<>(Arrays.asList(characters));
        // Collections.sort() 默认升序 降序需要自己实现 Comparator 接口
//        Collections.sort(charList, Collections.reverseOrder());  // 原地排序
        charList.sort(Comparator.reverseOrder());  // 原地排序
        System.out.println(charList);
        
    }

    @Test
    public void test3() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{4, 5, 6});
        list.add(new int[]{7, 8, 9});
        int[][] newNums1 = list.toArray(int[][]::new);
        Integer[][] newNums = list.stream().map(o -> Arrays.stream(o).boxed().toArray(Integer[]::new)).toArray(Integer[][]::new);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        int[] newNums2 = set.stream().mapToInt(Integer::intValue).toArray();
        long[] newNums3 = set.stream().map(Double::valueOf).mapToLong(Double::longValue).toArray();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 8 ,7};
        List<Integer> arr = Arrays.stream(nums).boxed().distinct().filter(n -> n < 10).max((n1, n2) -> n1 - n2).stream().toList();
        System.out.println(arr);

        int[][] newNums4 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        List<int[]> arr2 = Arrays.stream(newNums4).toList();
    }

    @Test
    public void test4() {
        String s = "10011";
        int targetLength = 10;
        String formatted = String.format("%" + targetLength + "s", s).replace(' ', '0');
        System.out.println(formatted);
    }

    @Test
    public void testMerge(){
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }
        for (int j = 0; j < n; j++) {
            list.add(nums2[j]);
        }

        list.sort(Comparator.naturalOrder());

        int[] newNums = list.stream().mapToInt(Integer::intValue).toArray();
        nums1 = newNums;
        System.out.print("[");
        for (int k = 0; k < newNums.length; k++) {
            if (k != newNums.length-1)
                System.out.print(newNums[k] + ",");
            else
                System.out.print(newNums[k]);
        }
        System.out.print("]");
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);

    }

    @Test
    public void testMap(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);

        // 遍历 map 的 key
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        // 遍历 map 的 value
        for (Integer value : map.values()) {
            System.out.println(value);
        }

        // 遍历 map 的 entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }

        // 使用 forEach 遍历 map 的 entry
        map.forEach((key, value) -> System.out.println(key + " " + value));

        // 使用 stream 遍历 map 的 entry
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        // 使用 stream 遍历 map 的 key
        map.keySet().stream().forEach(key -> System.out.println(key));

        // 使用 stream 遍历 map 的 value
        map.values().stream().forEach(value -> System.out.println(value));

    }

    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> queue = new ArrayDeque<>(10);  // 指定容量，不指定默认为16
//        queue.offer(1);
//        queue.offer(2);
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.getLast());
    }


}


class MyUtils{
    public void addOne(Object obj){
        if (obj instanceof Integer){
            Integer i = (Integer) obj;
            System.out.print(i + 1);
        }else if (obj instanceof Double){
            Double d = (Double) obj;
            System.out.print(d + 1);
        }else if (obj instanceof String){
            String s = (String) obj;
            System.out.print(s + 1);
        }
    }

    public static int cmp(Integer i, Integer j){
        return i - j;
    }
}