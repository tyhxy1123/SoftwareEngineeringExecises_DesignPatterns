import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Set;

public class JMember implements java.util.Observer {
    private Set<JTopic> topics = new HashSet<>();

    public Set<JTopic> getSubscribedTopics() {
        return topics;
    }

    public void subscribe(JTopic topic){
        if(topic == null) throw new NullPointerException();
        topics.add(topic);
        topic.addObserver(this);

    }

    public void unsubscribe(JTopic topic){
        if(topic == null) throw new NullPointerException();
        else {
            topics.remove(topic);
            topic.deleteObserver(this);
        }
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        if(arg0 instanceof JTopic){
            System.out.println("The topic " + ((JTopic)arg0).getId() + " has been updated!");
        }
    }
}
