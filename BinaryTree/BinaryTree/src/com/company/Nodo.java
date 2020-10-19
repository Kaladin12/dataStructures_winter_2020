package com.company;

public class Nodo {
    int valor;
    Nodo hijoIzq;
    Nodo hijoDer;

    public Nodo(int valor){
        this.valor = valor;
    }
    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
    public void setHijoIzq(Nodo hijoIzq)
    {
        this.hijoIzq = hijoIzq;
    }
    public Nodo getHijoIzq()
    {
        return  this.hijoIzq;
    }
    public  Nodo getHijoDer()
    {
        return this.hijoDer;
    }
    public void agregarHijo(Nodo nuevo)
    {
        if(nuevo.getValor() > this.valor)
        {
            if(this.hijoDer == null){
                this.hijoDer = nuevo;
            }
            else {
                this.hijoDer.agregarHijo(nuevo);
            }
        }
        else
        {
            if(this.hijoIzq == null){
                this.hijoIzq = nuevo;
            }
            else{
                this.hijoIzq.agregarHijo(nuevo);
            }

        }
    }
    public void agregarHijo(int valor){
        Nodo nuevo = new Nodo(valor);
        agregarHijo(nuevo);
    }
    public int getValor(){
        return this.valor;
    }
}
