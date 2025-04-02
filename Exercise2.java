/**
 * Exercise 3 (1 checkoff point)
Please read the whole paragraph before starting. 
Implement a static method, removeEvens, to remove all the even values in a stack of 
integers. After the call, all the odd values will still be in the stack in the same 
order as they were when you started. You may only use operations push, pop, peek, 
and empty. You may not use any other kinds of data structures in this 
method (e.g., no arrays, ArrayLists, or LinkedLists), 
but you may use more than one stack.
For the test that we provided in the starter file,

[1, 2, 3, 2, 4, 5] <-- top
the expected output is
[1, 3, 5] <-- top
 */

import java.util.*;

public class Exercise2{
    public static Stack<Integer> removeEvens(Stack<Integer> stack){
        Stack<Integer> placeholder = new Stack<>();
        while(!stack.empty()){
            int peek = stack.peek();
            if (peek % 2 == 0){
                System.out.println(peek + " peek value is even");
                stack.pop();
                System.out.println("current stack is: "+ stack);

            }
            else{
                System.out.println(peek + " peek value is odd");
                int top = stack.pop();
                placeholder.push(top);
                System.out.println("placeholder stack is : "+ placeholder);
            }
        }
        while(!placeholder.empty()){
            stack.push(placeholder.pop());
        }
        return stack;
    }

    public static void main(String[] args){
        Stack<Integer> test1 = new Stack<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(4);
        test1.add(5);
        System.out.println(removeEvens(test1));
    }
}


