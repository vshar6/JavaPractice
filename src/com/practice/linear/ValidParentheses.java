package linear;

import java.util.Stack;

public class ValidParentheses {



    public static boolean isValidString(String s) {

        Stack<Character> stack = new Stack<>();
        char [] parentheses = s.toCharArray();

        for(Character parenthese: parentheses) {
            System.out.println("parenthese:"+parenthese);
            if(parenthese.equals('[') || parenthese.equals('{') || parenthese.equals('(')) {
                stack.push(parenthese);
            } else {
                    if(parenthese.equals(']') || parenthese.equals(')') ||  parenthese.equals('}')) {
                        if(stack.isEmpty()) {
                            return false;
                        } else {
                            if(parenthese.equals(')') && stack.peek().equals('(')) {
                                stack.pop();
                            }
                            else if(parenthese.equals('}') && stack.peek().equals('{')) {
                                stack.pop();
                            } else if(parenthese.equals(']') && stack.peek().equals('[')) {
                                stack.pop();
                            } else {
                                return false;
                            }
                        }

                    }
                }
        }

        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        isValidString(s,0,stack);

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void isValidString(String input,  int counter, Stack<Character> stack) {

        if(counter < input.length()) {
            Character parenthese = input.charAt(counter);
            if(parenthese.equals('[') || parenthese.equals('{') || parenthese.equals('(')) {
                stack.push(parenthese);
            } else {
                if(stack.isEmpty()) {
                    stack.push(parenthese);
                    counter = input.length();
                    return;
                }
                if(parenthese.equals(']') || parenthese.equals(')') ||  parenthese.equals('}')) {
                    if(parenthese.equals(')') && stack.peek().equals('(')) {
                        stack.pop();
                    }
                    else if(parenthese.equals('}') && stack.peek().equals('{')) {
                        stack.pop();
                    } else if(parenthese.equals(']') && stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        return;
                    }
                }
            }
            isValidString(input,counter+1,stack);
        }
    }


    public static void main(String [] args) {
        System.out.println("answer:"+isValid("]"));
    }
}
