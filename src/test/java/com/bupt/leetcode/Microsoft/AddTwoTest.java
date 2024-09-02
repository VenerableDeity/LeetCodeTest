package com.bupt.leetcode.Microsoft;

import org.junit.jupiter.api.Test;

public class AddTwoTest {

    /*
    给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
    如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。

    示例 1：
    输入：num = "1210"
    输出：true
    解释：
    num[0] = '1' 。数字 0 在 num 中出现了一次。
    num[1] = '2' 。数字 1 在 num 中出现了两次。
    num[2] = '1' 。数字 2 在 num 中出现了一次。
    num[3] = '0' 。数字 3 在 num 中出现了零次。
    "1210" 满足题目要求条件，所以返回 true 。

    示例 2：
    输入：num = "030"
    输出：false
    解释：
    num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了两次。
    num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
    num[2] = '0' 。数字 2 在 num 中出现了 0 次。
    下标 0 和 1 都违反了题目要求，所以返回 false 。

    提示：
    n == num.length
    1 <= n <= 10
    num 只包含数字。
     */

    @Test
    public void test(){
        AddTwoTest addTwo = new AddTwoTest();
        System.out.println(addTwo.digitCount("1210"));
//        String str = "1230";
//        Integer i = Integer.parseInt(str);
//        Double d = Double.valueOf(str);
//        String s = String.valueOf(i);
//        System.out.println(i);
//        System.out.println(s);
//        System.out.println(d);
//        System.out.println(str.charAt(0) - '0');
//        System.out.println(str.length());
//        int[] res = new int[str.length()];
//        System.out.println(res.length);
    }


    public boolean digitCount(String num) {
        int n = num.length();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = num.charAt(i) - '0';//遍历字符串，得到每一位的数字的值，用res数组进行记录
        }
        for(int i = 0; i < n; i++){//i循环的是数组下标的值
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(res[j] == i) cnt++;//若所在位数上的值等于数组的下标值，则计数++;
            }
            if(cnt != res[i]) return false;//下标值累计出现的个数 不等于 当前位数上的值，返回错误
        }
        return true;
    }


    /*
    char 转 String：
    可以通过将一个单个的 char 转换为一个包含该字符的字符串。这可以通过使用 Character.toString(char) 或者直接将 char 与空字符串 "" 连接来完成，例如：String str = Character.toString('a'); 或 String str = 'a' + "";。

    String 转 char：
    如果需要将字符串中的某个字符提取出来，可以使用 charAt() 方法来获取指定位置的字符。例如：char c = str.charAt(0); 这将获取字符串 str 的第一个字符并将其存储在字符变量 c 中。

    String 转 char 数组：
    可以使用 toCharArray() 方法将字符串转换为字符数组。例如：char[] charArray = str.toCharArray(); 这将字符串 str 中的每个字符存储在字符数组 charArray 中。

    char 数组转 String：
    可以使用 String 的构造函数或者 String.valueOf(char[]) 方法将字符数组转换为字符串。例如：String str = new String(charArray); 或者 String str = String.valueOf(charArray);。
    */

}
