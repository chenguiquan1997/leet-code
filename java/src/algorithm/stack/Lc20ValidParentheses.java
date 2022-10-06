package algorithm.stack;

/**
 * @Author Guiquan Chen
 * @Date 2022/10/5 22:48
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc20ValidParentheses {

    public static void main(String[] args) {
        Boolean flag = Lc20ValidParentheses.isValid("}[]{");
        System.out.println(flag);
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> sMap = new HashMap<Character, Character>();
        sMap.put('(', ')');
        sMap.put('[', ']');
        sMap.put('{', '}');
        Stack stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            if (stack.empty()) {
                Character a = sMap.get(s.charAt(i));
                if (sMap.get(s.charAt(i)) == null) {
                    return false;
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                if (sMap.get(stack.peek()) != null && sMap.get(stack.peek()) == s.charAt(i)) {
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.empty()) return true;
        return false;

    }
}
