package Inheritance;

public class Serf extends Peasant {

    @Override
    protected int taxableIncome() {
        if(this.income > 12){
            return income - 12;
        }
        return 0;
    }
}
