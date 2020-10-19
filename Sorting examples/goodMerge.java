public class goodMerge {
    
    public static void main(String[] args) {
        int[] arreglo = {9,1,8,2,7,3,6,4,5,02,58,14,1,0,2247, 771,5016,6210,3455, 6752, 6437, 7084, 8990, 384,2724, 5235, 2635, 7995, 4930,
			2764, 8811, 4270, 7372, 7525, 2819, 888, 2537, 9973, 5465, 8590, 9223, 3746, 5394, 340,
			9698, 3986, 5042, 1670, 9449,7430, 9870, 4783, 1461, 1649,8054, 9706, 1178, 251, 9062,
			4074, 3649, 8812, 5035, 9075,2277, 6183, 2338, 3250, 3175,3902, 417, 6371, 8323, 8049,
			6799, 6208, 5629, 6581, 8677,5690, 4005, 3881, 7280, 9105,2629, 533, 7920, 2036, 4466,
			279, 8140, 1725, 4483, 8879,296, 1783, 6293, 8251, 6959,5167, 9868, 1794, 4957, 7243,
			1734, 171, 2355, 2877, 4563,2246, 414, 4842, 7008, 4194};
        mSort(arreglo,0,arreglo.length-1);
        for (int i : arreglo) {
            System.out.println(i);
        }
    }

    public static void mSort(int[] array,int left,int right){
        if (left<right){
            int mid =(right+left)/2;
            mSort(array, left, mid);
            mSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left,int mid, int right){
        int[] help = new int[array.length];
        for (int i = left; i <= right; i++) {
            help[i] = array[i];
        }
        int i = left;
        int j = mid+1;
        int k = left;

        while (i<=mid && j<=right) {
            if(help[i]<=help[j]){
                array[k] = help[i];
                i++;
            }
            else{
                array[k] = help[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            array[k] = help[i];
            k++;
            i++;
        }

        while(j<=mid){
            array[k] = help[j];
            k++;
            j++;
        }

    }
}