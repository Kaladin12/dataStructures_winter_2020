package doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        Queue<String> newQueue = new Queue<String>("coltaine");
        newQueue.push("bridgeburner");
        newQueue.push("urithiru");
        newQueue.push("ashai");
        newQueue.push("luthadel");
        Node<String> myNode = new Node<String>("k'rul");
        newQueue.push(myNode);
        newQueue.pop();
        //System.out.println(newQueue.front());
        //System.out.println(newQueue.size());
        newQueue.push("genabackis");
        for (int i = 0; i < 10; i++) {
            System.out.println(newQueue.peek(i));
        }
    }
}
