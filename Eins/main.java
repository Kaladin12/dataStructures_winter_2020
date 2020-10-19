class buscar_y_moda{
    public static void main(String[] args) {
        int[] arreglo = {2,34,56,90,253,763,763,763,91001, 91002,91002,91002,262772};
        buscar(arreglo, 91001);
        moda(arreglo);
    }

    public static void buscar(int[] array, int numero){
        int i = 0;
        while (i<array.length && numero!=array[i]){ 
            i++;
        }
        if (i<array.length){ //si no está, i será igual a la longitud del array
            System.out.println(i);
        }
        else{
            System.out.println('1');
        }
    }

    public static void moda(int[] array){
        int nModa=0, cuentaModa=0;
        for (int a=0;a<array.length; a++) { 
            int cuenta = 0;
            for (int b=1; b<array.length;b++){
                if (array[b] == array[a]){
                    cuenta++; 
                }
            }
            if (cuenta > cuentaModa){ //si hay dos con la misma cantidad de apariciones, le mostrará el primero
                cuentaModa = cuenta;
                nModa = array[a];
            }
            //System.out.println(c);
        }
        System.out.println("la moda es: "+Integer.toString(nModa));
    }
}