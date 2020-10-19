public class Main {
    public static void main(String[] args) {
        /*Videojuego j = new Videojuego("Dis my name");
        j.setReleaseDate(2020, 06, 07);
        j.addSystem("MacBook");
        j.addSystem("MacBook");
        PlayStationGame psg = new PlayStationGame("PS5","Action" , "Last of Us","Naughty Dog");
        psg.setReleaseDate(2008,06,20);
        System.out.println(psg);*/
        //Stack<Integer> newStack = new Stack<Integer>(5);
        Queue<Integer> newQueue = new Queue<Integer>(5);
        //newStack.push(75);
        Node<Integer> myNode = new Node<Integer>(6);
        /*newStack.push(myNode);
        //newStack.push(37);
        //ewStack.push(42);*/
        newQueue.push(myNode);
        newQueue.pop();
        newQueue.push(10);
        newQueue.pop();
        newQueue.pop();
        newQueue.push(558);
        newQueue.push(45);
        for (int i = 0; i < 5; i++) {
            System.out.println(newQueue.Peek(i));
        } 
        //newQueue.push(25);
        //System.out.println("Front: "+newQueue.front().toString());
        //System.out.println("Size: "+newQueue.size());
        
        //System.out.println("Size: "+newQueue.size());
        //System.out.println("Empty: "+newQueue.empty());
        //System.out.println("Empty: "+newQueue.empty());
        //System.out.println("Front: "+newQueue.front().toString());
    }
}
