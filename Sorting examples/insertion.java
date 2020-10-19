public class insertion {
    public static void main(String[] args) {
        int[] arreglo = {4,0,-1,12,45,102,3,56,845,5,1,23,32,99,2,101};
        sort(arreglo);
    }

    public static void sort(int[] array) {
        //int c=0;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i-1;
            while (j>=0 && array[j]>key){ 
                //c++;
                array[j+1] = array[j];
                j--;
            }
            array[j+1]=key;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //System.out.println(c);
    }
}