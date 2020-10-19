public class Trial{
    public static void main(String[] args) {
        linkedList<Integer> a = new linkedList<Integer>(5);
        a.pushFront(10);
        a.pushBack(45);//19,10,58,5,45
        //System.out.println(a.find(20));
        //a.erase();
        a.addBefore(0, 19);
        a.addBefore(2, 58);
        //System.out.println(a.keyTop());
        System.out.println(a.popFront());
        System.out.println(a.popFront());
        System.out.println(a.popFront());
        //System.out.println(a.keyTop());
        //a.print();
        
        //System.out.println(a.keyTop());

    }
}