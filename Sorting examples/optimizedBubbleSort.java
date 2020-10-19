public class optimizedBubbleSort {
    public static void main(String[] args) {
        int[] arreglo = {4,0,-1,12,45,102,3,56,845,5,1,23,32,99,2,101};
        sort(arreglo);
    }

    public static void sort(int[] array){
        int temp = 0;//,c=0;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            flag = false;
            for (int j = 0; j < array.length-i-1; j++) {
                //c++;
                if (array[j]>array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag = true;
                }
            }
            
            if (flag==false)
                break;
        }
        for (int i : array) {
            System.out.println(i);
        }
    
        //System.out.println(c);
    }
}