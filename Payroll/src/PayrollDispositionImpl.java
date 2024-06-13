import java.util.HashMap;
import java.util.Map;

public class PayrollDispositionImpl implements PayrollDisposition {
    private Map<Employee, Double> payments = new HashMap<>();

    public PayrollDispositionImpl() {
    }

    public double getTotal(){
        double sum = 0;
        for(Map.Entry<Employee, Double> entry : payments.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }

    public double getAverage(){
        if(payments.isEmpty()) return 0;
        else return getTotal()/payments.size();
    }

    public Map<Employee, Double> getPayments(){
        return payments;
    }

    @Override
    public void sendPayment(Employee empl, double payment) {
        System.out.println("Employee: " + empl.toString());
        System.out.println("payment: " + payment);
        if(empl == null) throw new NullPointerException();
        if(payment <= 0) throw new IllegalArgumentException();
        payments.put(empl, payment);
    }
}
