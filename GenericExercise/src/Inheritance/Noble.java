package Inheritance;

public class Noble extends Inhabitant{

    @Override
    protected int tax() {
        if(super.tax() < 20){
            return 20;
        }
        return super.tax();
    }
}
