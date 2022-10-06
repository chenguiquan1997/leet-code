"""
给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。

示例 1：

输入：s = "()"
输出：true

输入：s = "()[]{}"
输出：true


输入：s = "(]"
输出：false

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


def valid_parentheses(s):
    # 一共就三种括号类型，所以可以把它们存在一个字典里面
    dict_s = {"(": ")", "{": "}", "[": "]"}
    arr = []
    for s_item in s: # 遍历当前字符串
        if len(arr) == 0: # 判断当前数组中，是否为空
            if s_item in dict_s: # 如果没有元素，并且还是以左括号开始的，那么需要保存在数组里
                arr.append(s_item)
            else: # 如果数组为空，并且还是以右括号，或其他在字典里面找不到的字符开始的，那么它就不是一个有效的括号字符串
                return False
        else:
            # 如果数组的最后的元素在字典里，并且等于当前的元素，那么证明它们是匹配的括号
            if arr[-1] in dict_s and dict_s[arr[-1]] == s_item:
                arr.pop() # 需要将数组的最后一位弹出
            else:
                arr.append(s_item) # 否则证明它们不匹配，继续添加到数组的最后一位
    if len(arr) > 0: # 如果数组不为空，那么证明括号不能完全匹配
        return False
    return True


if __name__ == '__main__':
    s = "([)]"
    flag = valid_parentheses(s)
    print(flag)
