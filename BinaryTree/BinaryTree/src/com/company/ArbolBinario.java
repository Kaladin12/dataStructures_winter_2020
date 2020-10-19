package com.company;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario(){};
    public ArbolBinario(int raiz)
    {
        Nodo nuevo = new Nodo(raiz);
        this.raiz = nuevo;
    }
    public void agregarValor(Nodo nuevo)
    {
        if(this.raiz == null)
        {
            this.raiz = nuevo;
        }
        else{
            this.raiz.agregarHijo(nuevo);
        }
    }
    public void agregarValor(int valor)
    {
        Nodo nuevo = new Nodo(valor);
        agregarValor(nuevo);
    }
}
