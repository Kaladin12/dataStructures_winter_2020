package sortingGenerics;
import java.util.ArrayList;

public class sort {
    public static void main(String[] args) {
        //Bubble, select, insert, merge, quicksort
        String[] aString = {"Kaladin","Dalinar","Voidbringer", "Alethkar"};
        Integer[] aInt = {4,0,-1,12,45,102,3,56,845,5,1,23,32,99,2,101};
        Double[] aDouble = {4.09,.0992,93.20, 14.0,3.20,137.90};
        //bubbleSort(arreglo);
        //selectionSort(arreglo);
        //insertionSort(arreglo);
        //quickSort(arreglo, 0, arreglo.length-1);
        mergeSort(aInt,0,aInt.length-1);
        for (Integer i : aInt) {
            System.out.println(i);
        }
        System.out.println('\n');
        mergeSort(aDouble,0,aDouble.length-1);
        for (Double i : aDouble) {
            System.out.println(i);
        }
        System.out.println('\n');
        mergeSort(aString,0,aString.length-1);
        for (String i : aString) {
            System.out.println(i);
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array){
        T temp;//,c=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j].compareTo(array[j+1])>0){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    public static<T extends Comparable<T>> void selectionSort(T[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j].compareTo(array[min])<0){
                    min = j;
                }
            }
            T temp = array[min];
            array[min] = array[i];
            array[i]=temp;
        }
    }

    public static<T extends Comparable<T>> void insertionSort(T[] array){
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i-1;
            while (j>=0 && array[j].compareTo(key)>0){
                array[j+1] = array[j];
                j--;
            }
            array[j+1]=key;
        }
    }

    public static<T extends Comparable<T>> void quickSort(T[] array, int low, int high){
        if (low<high){
            int partIndex = partition(array, low, high);
            quickSort(array, low, partIndex-1);
            quickSort(array, partIndex+1, high);
        }
    }

    public static<T extends Comparable<T>> int partition(T[] array, int low, int high){
        T pivot = array[high];
        int index = low;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot)<0){
                T tmp = array[index];
                array[index] = array[j];
                array[j] = tmp;
                index++;
            }
        }
        T tmp = array[index];
        array[index] = array[high];
        array[high] = tmp;
        return index;
    }
    
    public static<T extends Comparable<T>> void mergeSort(T[] array, int left,int right){
        if (left<right){
            int mid =(right+left)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public static<T extends Comparable<T>> void merge(T[] array, int left,int mid, int right){
        int length = array.length;
        ArrayList<T> help = new ArrayList<T>(length);
        for (int i = 0; i< length; i++){
            T value = array[i];
            help.add(value);
        }
        for (int i = left; i <= right; i++) {
            help.set(i, array[i]);
        }
        int i = left;
        int j = mid+1;
        int k = left;

        while (i<=mid && j<=right) {
            if(help.get(i).compareTo(help.get(j))<=0){
                array[k] = help.get(i);
                i++;
            }
            else{
                array[k] = help.get(j);
                j++;
            }
            k++;
        }
        while(i<=mid){
            array[k] = help.get(i);
            k++;
            i++;
        }
        while(j<=mid){
            array[k] = help.get(j);
            k++;
            j++;
        }
    }
}   