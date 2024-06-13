package LinkedList;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){
        List list = new List();
        list.append("gogogo");
        list.append("gogobar");
        list.append("fighting");
        String removed = list.remove("gogobar");
        System.out.println(removed + " is removed.");
    }
}
