package LeetCode.Hot100.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 21:42 2025/4/10
 */
public class ValidParentheses {

    public static boolean ValidParentheses(String s){
        if(s.length()%2==1){
            return false;
        }
        Deque<Character> st = new ArrayDeque<>();
        //push是压入栈顶
        //offer是元素插入队列的末尾
        //是两种不同的数据类型的输入方式
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(')');
            }else if(c=='['){
                st.push(']');
            }else if(c=='{'){
                st.push('}');
            }else if(st.isEmpty() || st.pop()!=c){
                return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(ValidParentheses(s));
    }
}
