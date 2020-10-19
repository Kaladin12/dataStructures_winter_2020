package sortedQueue;

public class MainTwo {
    public static void main(String[] args) {
        Queue<String> as = new Queue<String>("Kaladin");
        as.queueInOrder("Dalinar");
        as.queueInOrder("Shallan");
        as.queueInOrder("Sadeas");
        as.queueInOrder("Parshendi");
        as.queueInOrder("Voidbringer");
        as.queueInOrder("Kurald Galain");
        System.out.println(as.size());
        //as.pop();
        //as.pop();
        System.out.println(as.front());
        //as.pop();
        //System.out.println(as.size());
        System.out.println(as.empty());
        as.queueInOrder("Kharbranth");
        for (int i = 0; i < 9; i++) {
            System.out.println(as.Peek(i));
        } 
    }
}
