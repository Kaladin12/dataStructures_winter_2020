package sortingGenerics;

   
public class generic<T extends Comparable<T>> {
    T valor;
    public generic(T valor){
        this.valor = valor;
    }
    @Override
    public String toString(){
        return this.valor.toString();
    }
    

}

