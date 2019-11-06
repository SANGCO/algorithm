package com.example.algorithm.basic;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(nums);
        Arrays.stream(res).forEach(System.out::println);
    }

//  pop이 안된 놈들은 자기 차례를 기다리면서 밑에 깔려있다.
//  i번째가 되어서 pop이 되면 i를 pop 되는 놈 index로 빼면 자기보다 큰놈이 나오는데 몇번 걸렸는지 나온다.

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
