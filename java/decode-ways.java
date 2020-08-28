/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (24.22%)
 * Likes:    486
 * Dislikes: 0
 * Total Accepted:    63.9K
 * Total Submissions: 262.5K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * DP
     * time -> O(n)
     * space -> O(n)
     * @author caohui
     * @date 2020/08/28
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        // dp[i] -> 以s[i-1]结尾的子串的解码总数
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i-1) != '0') dp[i] += dp[i - 1];
            int decode = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if (decode >= 10 && decode <= 26) dp[i] += dp[i - 2];
        }

        return dp[dp.length - 1];

    }
}
// @lc code=end

