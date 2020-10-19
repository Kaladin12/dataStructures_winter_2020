package a;

import java.util.Date;

public class Alumno implements Comparable<Alumno> {
    int matricula;
    String name, lstName, major;
    Date birthDate;

    public Alumno(int matricula, String nombre, String apellido, String carrera , Date fecha){
        this.matricula = matricula;
        this.name = nombre;
        this.lstName = apellido;
        this.major = carrera;
        this.birthDate = fecha;
    }
    @Override
    public int compareTo(Alumno otro){
        return this.matricula-otro.matricula;
    }
}