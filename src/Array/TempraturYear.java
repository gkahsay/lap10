package Array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class TempraturYear {

    public static int[] numberOfDaysInEachMonth = {31, 28 , 31, 30 , 31, 30 , 31, 31, 30, 31, 30 , 31};

    public static void main(String[] args) {

        //1. generate array first
        double[] temps =  generateTemperature();
        System.out.println(Arrays.toString(temps));

        // Hottest and Coldest Days
        double hottest = hottestDay(temps);
        System.out.println("Max temp of the year =  " + hottest);

        double coldest = coldestDay(temps);
        System.out.println("Min temp  of the year =  " + coldest);

        // average for each months
        double[] results = averageOfEachMonth(temps , numberOfDaysInEachMonth);
        System.out.println(" Average of Each Month " + Arrays.toString(results));



    }

    public static double[] averageOfEachMonth(double[] temps , int[] numberOfDaysInEachMonth){

        double[] results = new double[numberOfDaysInEachMonth.length];

        int start = 0 ;
        int end = numberOfDaysInEachMonth[0];
        int j = 1;

        for(int i = 0 ; i < numberOfDaysInEachMonth.length - 1 ; i++){

            results[i] = averageOfSingleMonth(temps, start, end);
            start = end+1;
            end += numberOfDaysInEachMonth[j++];
        }

        results[results.length-1] = averageOfSingleMonth(temps, start , end);
        System.out.println(end);
        return results;
    }

    public static double averageOfSingleMonth(double [] temps, int startIdx , int endIndex){

        int sum = 0 ;
        int counter = 0;
        for(int i = startIdx ; i < endIndex; i++){
            sum +=temps[i];
            counter++;
        }
        return  (double) sum / counter;
    }

    public static double hottestDay(double [] temps){

        double max = temps[0];
        for(int i = 1 ; i < temps.length; i++){

            if(temps[i] > max) {
                max = temps[i];
            }
        }

        return max;
    }

    public static double coldestDay(double [] temps){

        double min = temps[0];
        for(int i = 1; i < temps.length ; i++){

            if(temps[i] < min){
                min = temps[i];
            }
        }
        return min;
    }

    /**
     *  Data generator for the temperature for the year
     */
    public static double[]  generateTemperature(){

        // MAX - > 112 , MIN -> -27
        int min = - 27;
        int max = 112;

        double[] temps = new double[365];

        Random random = new Random();
        for(int i = 0 ; i < temps.length; i++){
            temps[i] = random.nextInt(max - min ) + min;
        }

        return temps;
    }

}


