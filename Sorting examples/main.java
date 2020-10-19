class binarySearch{
    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(Integer.toString(search(arreglo, 7)));
    }

    public static int search(int[] array, int num){
        int  lower = 0, upper = array.length-1;
        while (lower<=upper) {
            int mid = (lower+ upper)/2;
            if (num < array[mid]){
                upper = mid -1;
            }
            else if (num> array[mid]){
                lower = mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}