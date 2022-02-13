package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
public class B1918 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                      
        char[] infix=br.readLine().toCharArray();
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String operation = "+-/*";
        for(int i=0;i<infix.length;i++) {
        	
            if(infix[i]==')'||infix[i]=='(') {
                if(infix[i]=='(') {
                    stack.push(Character.toString(infix[i]));
                }
                else {
                    while(!stack.peek().equals("(")) {
                        postfix.append(stack.pop());
                    }
                    stack.pop();
                    }
             }
            
             else if(operation.contains(Character.toString(infix[i]))) {
                if(stack.isEmpty()) 
                   stack.push(Character.toString(infix[i]));
                else if(infix[i]=='+'||infix[i]=='-') {
                   while(!stack.isEmpty()) {
                            if(stack.peek().equals("(")) {
                                break;
                            }
                            postfix.append(stack.pop());
                        }
                        stack.push(Character.toString(infix[i]));
                    }
                    
                    else {
                        if(stack.peek().equals("*")||stack.peek().equals("/")) {
                            while(!stack.isEmpty()&&(stack.peek().equals("/")||stack.peek().equals("*"))) {
                                if(stack.peek().equals("(")) {
                                    break;
                                }
                                postfix.append(stack.pop());
                            }
                            stack.push(Character.toString(infix[i]));
                        }
                        
                        else {
                            stack.push(Character.toString(infix[i]));
                        }
                    }
                }
                else {
                    postfix.append(infix[i]);
                }
            }
            while(!stack.isEmpty()) {
                postfix.append(stack.pop());
            }
      
        
        bw.write(postfix.toString());
        bw.flush();
    }
}