public class quicksort {
    public static void main(String[] args) {
        int[] arreglo = {5,65,342,58,14,1,0,2247, 771,5016,6210,3455, 6752, 6437, 7084, 8990, 384,2724, 5235, 2635, 7995, 4930,
        2764, 8811, 4270, 7372, 7525, 2819, 888, 2537, 9973, 5465, 8590, 9223, 3746, 5394, 340,
        9698, 3986, 5042, 1670, 9449,7430, 9870, 4783, 1461, 1649,8054, 9706, 1178, 251, 9062,
        4074, 3649, 8812, 5035, 9075,2277, 6183, 2338, 3250, 3175,3902, 417, 6371, 8323, 8049,
        6799, 6208, 5629, 6581, 8677,5690, 4005, 3881, 7280, 9105,2629, 533, 7920, 2036, 4466,
        279, 8140, 1725, 4483, 8879,296, 1783, 6293, 8251, 6959,5167, 9868, 1794, 4957, 7243,
        1734, 171, 2355, 2877, 4563,2246, 414, 4842, 7008, 4194};
        
        sort(arreglo, 0, arreglo.length-1);
        for (int i : arreglo) {
            System.out.print(Integer.toString(i)+" ");
        }
    }   
    public static void sort(int[] array, int low, int high) {
        if (low<high){
            int partIndex = partition(array, low, high);
            sort(array, low, partIndex-1);
            sort(array, partIndex+1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int index = low;
        for (int j = low; j < high; j++) {
            if (array[j]<pivot){
                int tmp = array[index];
                array[index] = array[j];
                array[j] = tmp;
                index++;
            }
        }
        int tmp = array[index];
        array[index] = array[high];
        array[high] = tmp;
        return index;
    }
}