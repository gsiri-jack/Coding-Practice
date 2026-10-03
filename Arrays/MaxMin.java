package org.PracticeCoding.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxMin {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int temp;
        for(int i=0; i<5;i++){
            temp= sc.nextInt();
            arr.add(temp);
        }
        MaxMin obj = new MaxMin();
        obj.secondMinMax(arr);
    }

    //first Min and Max
    public void MinMax(List<Integer> arr){

        if (arr.isEmpty()) {
            System.out.println("List is empty! Cannot find Min/Max.");
            return;
        }
        int max= arr.getFirst();
        int min=arr.getFirst();
        for(int i : arr){
            if(i> max){
                max=i;
            }
            if(i<min){
               min=i;
            }
        }
        System.out.println("MIN: "+min+" MAX: "+max);

    }

    public void secondMinMax(List<Integer> arr){
        if(arr.isEmpty()){
            return;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int secondMax=max;
        int secondMin=min;

        for(int i: arr){
            if(i>max){
               secondMax=max;
               max=i;
            }else if(i>secondMax && i!=max){
                secondMax=i;
            }
            if(i<min){
                secondMin=min;
                min=i;
            } else if (i<secondMin  && i!=min) {
                secondMin=i;

            }

        }
        System.out.println("second min "+secondMin+" second max: "+secondMax);
    }


}
