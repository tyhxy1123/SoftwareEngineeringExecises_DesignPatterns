package Inheritance;

public class Inhabitant {

    protected int income;

    protected int taxableIncome(){

        return income;
    }

    protected int tax(){
        int tax = taxableIncome() / 10;
        if(tax < 1){
            tax = 1;
        }
        return tax;
    }

    protected void setIncome(int income){
        this.income = income;
    }
}
