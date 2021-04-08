import java.util.*;

public class Utility{
    public static <T extends Number> double getMidpoint(T[] arr) {
        int mid = (arr.length - 1) / 2;
        if (arr.length % 2 == 1) {
            return arr[mid].doubleValue();
        }
        return (arr[mid].doubleValue() + arr[mid + 1].doubleValue()) / 2D;
    }

    public static <T> T getMidpoint(T[] arr) {
        return arr[(arr.length / 2)];
    }

    public static <T> T getLast (T[] arr){
        return arr[arr.length-1];
    }

    public static <T> T getFirst (T[] arr){
        return arr[0];
    }

    public static <T extends Number> double getAverage (T[] arr){
        double sum = 0D;
        for (T x : arr) {
            sum += x.doubleValue();
        }
        return sum / arr.length;
    }

    public static <T extends Number> Double getMin (T[] arr){
        T min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(min.doubleValue() > arr[i].doubleValue()){
                min = arr[i];
            }
        }
        return min.doubleValue();
    }

    public static <T extends Number> Double getMax (T[] arr){
        T max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max.doubleValue() < arr[i].doubleValue()){
                max = arr[i];
            }
        }
        return max.doubleValue();
    }

    public static <T extends Number> int getSize (T[] arr){
        return arr.length;
    }
}