import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Box<T> {
    private T value;
    private String label;

    public Box(String label) {
        this.label = label;
    }

    public void set(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void display() {
        System.out.println(label + " contains " + value);
    }

}

public class Main {
    public static void main (String[] args) {
        Box<Integer> numberBox = new Box<>("Number Box");
        numberBox.set(42);
        numberBox.display();

        Box<String> messageBox = new Box<>("Message Box");
        messageBox.set("Hello Generics");
        messageBox.display();

        ArrayList<Box<Integer>> boxList = new ArrayList<>();

        Box<Integer> box1 = new Box<>("Box 3");
        Box<Integer> box2 = new Box<>("Box 2");
        Box<Integer> box3 = new Box<>("Box 1");

        box1.set(10);
        box2.set(20);
        box3.set(30);

        boxList.add(box1);
        boxList.add(box2);
        boxList.add(box3);


        System.out.println("What's in the box?");
        for (Box<Integer> box: boxList) {
            box.display();

        }

        Queue<Box<String>> messageQueue = new LinkedList<>();
        Box<String> queueBox1 = new Box<>("Queue Box 1");
        Box<String> queueBox2 = new Box<>("Queue Box 2");
        Box<String> queueBox3 = new Box<>("Queue Box 3");

        queueBox1.set("First in Line");
        queueBox2.set("Second in Line");
        queueBox3.set("Third in Line");

        messageQueue.add(queueBox1);
        messageQueue.add(queueBox2);
        messageQueue.add(queueBox3);

        System.out.println("Processing Queue");
        while (!messageQueue.isEmpty()) {
            Box<String> box = messageQueue.poll();
            box.display();
        }

    }
}
