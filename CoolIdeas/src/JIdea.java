import java.util.LinkedList;
import java.util.List;

public class JIdea extends JContent {
    private List<JAttachment> attachments = new LinkedList<>();
    private JState state = new Draft();

    public JIdea(String title, String description) {
        super(title, description);
    }

    public void discuss(String text){
        if(text == null) throw new NullPointerException();
        if(text.isEmpty())throw new IllegalArgumentException();
        state.discuss(text);
    }

    public void evaluate(JValuation valuation){
        if(valuation == null) throw new NullPointerException();
        state.evaluate(valuation);
    }

    public void hold(){
        state.hold();
    }

    public void release(){
        state.release();
    }

    public void decline(){
        state.decline();
    }

    public boolean isDeclined(){
        return state instanceof DeclinedIdea;
    }

    public boolean isReleased(){
        return state instanceof ReleasedIdea;
    }

    public String getCurrentDiscussion(){
        return state.getCurrentDiscussion();
    }

    public JValuation getValuation(){
        return state.getValuation();
    }

    public void addAttachment(JAttachment attachment){
        if(attachment == null) throw new NullPointerException();
        attachments.add(attachment);
    }

    public List<JAttachment> getAttachments(){
        return attachments;
    }

    public boolean removeAttachment(JAttachment attachment){
        if(attachment == null) throw new NullPointerException();
        if(attachments.contains(attachment)) {
            attachments.remove(attachment);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Idea: " + getTitle() + "\n" + getDescription();
    }


    private abstract class JState {
        private String currentDiscussion;
        private JValuation valuation;

        public String getCurrentDiscussion() {
            return currentDiscussion;
        }

        public void setCurrentDiscussion(String currentDiscussion) {
            if(currentDiscussion == null) throw new NullPointerException();
            if(currentDiscussion.isEmpty()) throw new IllegalStateException("currentDisscussion can not be empty!");
            this.currentDiscussion = currentDiscussion;
        }

        public JValuation getValuation() {
            return valuation;
        }

        public void setValuation(JValuation valuation) {
            if(valuation == null) throw new NullPointerException();
            this.valuation = valuation;
        }

        public void discuss(String text){
//            currentDiscussion = text;
            throw new IllegalStateException();
        }

        public void evaluate(JValuation valuation){
//            this.valuation = valuation;
            throw new IllegalStateException();
        }

        public void hold(){
            throw new IllegalStateException();
        }

        public void release(){
            throw new IllegalStateException();
        }

        public void decline(){
            throw new IllegalStateException();
        }

    }

    private class Draft extends JState {
        @Override
        public void hold() {
            state = new OpenDraft();
        }

        @Override
        public void decline() {
            state = new DeclinedIdea();
        }
    }

    private class OpenDraft extends JState {
        @Override
        public void discuss(String text) {
            if(text == null) throw new NullPointerException();
            if(getCurrentDiscussion() != null) {
                setCurrentDiscussion(getCurrentDiscussion()  + text + "\n");
            }
            else{
                setCurrentDiscussion(text + "\n");
            }
        }

        @Override
        public void evaluate(JValuation valuation) {
            setValuation(valuation);
        }

        @Override
        public void hold() {
            state = new ApprovedIdea();
        }

        @Override
        public void decline() {
            state = new DeclinedIdea();
        }
    }

    private class ReleasedIdea extends JState {
    }

    private class DeclinedIdea extends JState {
    }

    private class ApprovedIdea extends JState {
        @Override
        public void release() {
            state = new ReleasedIdea();
        }
    }
}
