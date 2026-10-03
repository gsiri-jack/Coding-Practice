package org.PracticeCoding.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysTraversal {


    public static void main(String[] args) {
        //    Array
        int[] arr = {1,2,3,4};
        // forward traversal
        for(int i= arr.length-1; i>0; i--){
            System.out.println(arr[i]);
        }

        // forward traversal
        for(int i : arr){
            System.out.println(i);
        }

        // ArrayList
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(30);
        System.out.println(arr2.contains(1));

        // converting existing array into arrayList
        List<Integer> temp = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        arr2.addAll(temp);


    }



}
