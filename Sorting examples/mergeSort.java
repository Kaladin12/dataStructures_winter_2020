public class mergeSort {
    public static void main(String[] args) {
        int[] arreglo = {9,1,8,2,7,3,6,4,5,0};
        mSort(arreglo,0,arreglo.length-1);
        for (int i : arreglo) {
            System.out.println(i);
        }
    }

    public static void mSort(int[] array,int left,int right){
        if (left<right){
            int mid =(left+right)/2;
            mSort(array, left, mid);
            mSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left,int mid, int right){
        int sizeLeft = mid-left+1;
        int sizeright = right-mid;

        int leftTemp[]  = new int[sizeLeft];
        int rightTemp[]  = new int[sizeright];

        for (int i = 0; i < sizeLeft; i++) {
            leftTemp[i]=array[left+i];
        }
        for (int i = 0; i < sizeright; i++) {
            rightTemp[i]=array[mid+1+i];
        }

        int i=0, j=0, k=left;
        while(i<sizeLeft && j<sizeright){
            if(leftTemp[i]<=rightTemp[j]){
                array[k] = leftTemp[i];
                i++;
            }
            else{
                array[k] = rightTemp[j];
                j++;
            }
            k++;
        }

        while (i<sizeLeft) {
            array[k] = leftTemp[i];
            i++;
            k++;
        }
        while (j<sizeright) {
            array[k] = rightTemp[j];
            j++;
            k++;
        }
    }
}