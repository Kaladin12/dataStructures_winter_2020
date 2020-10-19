package a;

public class element<T extends Comparable<T>> {
    T valor;
    public element(T valor){
        this.valor = valor;
    }
    @Override
    public String toString(){
        return this.valor.toString();
    }
}