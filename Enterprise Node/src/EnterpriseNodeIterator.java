public interface EnterpriseNodeIterator<T extends EnterpriseNode> extends java.util.Iterator<T> {
    /*
    To iterate over the whole enterprise structure,
    we define an interface EnterpriseNodeIterator which extends the interface
    java.util.Iterator<T> by restricting the possible values of the type parameter T
    to implementations of EnterpriseNode. Apart from that,
    an EnterpriseNodeIterator‘s methods hasNext() and next() behave as defined by Iterator<T>
     */

}
