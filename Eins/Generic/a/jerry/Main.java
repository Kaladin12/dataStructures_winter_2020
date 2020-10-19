package a;

import java.time.Instant;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        element<String> e = new element<String>("valor");
        element<Integer> e2 = new element<Integer>(777);
        element<Alumno> e3 = new element<Alumno>(new Alumno(32218,"Elian", "Cruz", "ICC", Date.from(Instant.now())));
        element<Alumno> e4 = new element<Alumno>(new Alumno(32218,"Elian", "Cruz", "ICC", Date.from(Instant.now())));
        Alumno uno = new Alumno(32218,"Elian", "Cruz", "ICC", Date.from(Instant.now()));    
        Alumno dos = new Alumno(32258,"Elian", "Cruz", "ICC", Date.from(Instant.now()));
        System.out.println(uno.lstName.compareTo(dos.lstName));
    }

    public static <T extends Comparable<T>> void BubbleSort(T[] array){
        
    }

        }   