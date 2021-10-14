package Array;

import java.util.Scanner;

public class Avarge {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        System.out.println("Enter number for sizes:");
        int N =input.nextInt();
        int[] array =new int [N];
        int sum=0;
        double average,s,r;
        for(int i=0;i<N;i++){
            array[i]=i;
            sum += array[i];
        }
        average=sum/array.length;//this is mean x
        double sum2=0;
        for(int i=0;i<N;i++){
            sum2 +=(i-average)*(i-average);//is the sum of in said the sqrt
        }
        System.out.println("SUM2="+sum2);
        r =sum2/array.length;
        s=Math.sqrt(r);
        System.out.println("S="+s);

    }
}
