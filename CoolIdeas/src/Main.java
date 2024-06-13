public class Main {
    public static void main(String[] args) {
        JIdea i = new JIdea("title", "description");
        i.hold();
        i.discuss("test");
        i.discuss("test1");
        System.out.println(i.getCurrentDiscussion());
    }
}
