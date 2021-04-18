package com.interview;

import java.util.Stack;

public class HasStatic{
     public static void main(String[] args) {

     }
    // clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     public static Integer numpyStep(int N) {

         Stack<Integer> stack = new Stack<>();

         int stepTemp = 0;
         int[] opt = new int[]{1,2,3,4};
         int point = 0;

         for (int i = N; i > 0; --i) {

             if (point == 0) {
                 stepTemp = i;
             } else if (point == 1) {
                 stepTemp = stepTemp * i;
             } else if (point == 2) {
                 stepTemp = stepTemp / i;
             } else {
                 stack.push(stepTemp);
                 stepTemp = 0;
             }
            point = (++point) % 3;
         }
        return null;
     }
 }