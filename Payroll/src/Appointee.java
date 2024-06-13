public class Appointee extends Employee {
    private int dayOfMonth;
    private int hoursPerMonth;
    private double payPerHour;

    public Appointee(String id, int dayOfMonth, int hoursPerMonth, double payPerHour) {
        super(id);
        if(dayOfMonth < 1 || dayOfMonth > 31) throw new IllegalArgumentException();
        if(hoursPerMonth <= 0) throw new IllegalArgumentException();
        if(payPerHour <= 0) throw new IllegalArgumentException();
        this.dayOfMonth = dayOfMonth;
        this.hoursPerMonth = hoursPerMonth;
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if(dayOfMonth == this.dayOfMonth) return true;
        else return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException{
        return payPerHour * hoursPerMonth;
    }

    @Override
    public double calculateDeductions() {
        return payPerHour * hoursPerMonth * 0.4;
    }
}
