public class selectionSort {
    public static void main(String[] args) {
        int[] arreglo = {4,3,0,-1,12,45,102,3,56,845,5,1,23,32,99,2,101};
        sort(arreglo);
    }


    public static void sort(int[] array){
        //int c = 0;
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                //c++;
                if (array[j]<array[min]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i]=temp;
        }
        for (int i : array) {
            System.out.println(i);
        }
        //System.out.println(c);
    }
}