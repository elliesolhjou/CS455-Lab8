/**
 * Exercise 1 (1 checkoff point)
Write a static method isSorted that returns true if its LinkedList argument has elements
in non-decreasing order, and false otherwise. To get credit for this exercise, 
you must use an iterator in your implementation. (Not an enhanced for loop.)
Here are some examples:

list               isSorted(list)
(2 4 7)              true
(7 4 4 2)            false
(2 4)                true
(2)                  true
()                   true
(2 5 5 5 8)          true
(2 5 4 7 9 5)        false
We have provided a test driver for your method that tests it on several hard-coded cases, and compares the actual results with the expected results. The test driver source file, IsSortedTester.java, contains the stub for the isSorted method. For check-off show your TA your code and a run of the code with the provided test program.


 */
import java.lang.Math;
import java.util.*;

public class Exercise1{
    public static boolean isSorted(LinkedList<Integer> linkedL){

    ListIterator<Integer> iter = linkedL.listIterator();
    int max=Integer.MIN_VALUE;

    while(iter.hasNext()){
        int current = iter.next();
        if (current >= max){
            max = current;
        }
        else {
            return false;
        }
    }
    return true;

    }

    public static void main(String[] args){
        System.out.println(isSorted(new LinkedList<>(List.of(2, 4, 7))));
        System.out.println(isSorted(new LinkedList<>(List.of(7, 4, 4, 2))));
        System.out.println(isSorted(new LinkedList<>(List.of(2, 4))));
        System.out.println(isSorted(new LinkedList<>(List.of(2))));
        System.out.println(isSorted(new LinkedList<>(List.of())));
        System.out.println(isSorted(new LinkedList<>(List.of(2, 5, 5, 5, 8))));
        System.out.println(isSorted(new LinkedList<>(List.of(2, 5, 4, 7, 9, 5))));
    }
}