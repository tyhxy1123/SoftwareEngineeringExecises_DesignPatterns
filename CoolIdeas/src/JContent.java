public abstract class JContent extends java.util.Observable {
    private String title;
    private String description;

    public JContent(String title, String description) {
        if(title == null || description == null) throw new NullPointerException();
        if(title.isEmpty() || description.isEmpty()) throw new IllegalArgumentException("title can not be empty!");
        this.title = title;
        this.description = description;
    }

    @Override
    public synchronized int countObservers() {
        return super.countObservers();
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        if(description == null)throw new NullPointerException();
        if(description.isEmpty()) throw new IllegalArgumentException();
        this.description = description;
        setChanged();
        notifyObservers();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null) throw new NullPointerException();
        if(title.isEmpty()) throw new IllegalArgumentException();
        this.title = title;
        setChanged();
        notifyObservers();
    }

    @Override
    public abstract String toString();
}
