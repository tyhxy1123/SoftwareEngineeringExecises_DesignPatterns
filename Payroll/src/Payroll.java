import java.util.*;

public class Payroll{
    private PayrollDisposition disposition;
    private int payday;

    public Payroll(PayrollDisposition disposition, int payday) {
        System.out.println("Payroll initializing...");
        if(disposition == null) throw new NullPointerException();
        if(payday < 1 || payday > 31) throw new IllegalArgumentException();
        this.disposition = disposition;
        this.payday = payday;
    }

    public void doPayroll(PayrollDB db) {
        System.out.println("doPayroll initializing...");
        if(db == null)throw new NullPointerException();

        List<Employee> list = db.getEmployeeList();

        for(Employee empl : list){
            try {
                double payment = empl.calculatePay();
                if(empl.isPayday(payday)) {
                    disposition.sendPayment(empl, payment - empl.calculateDeductions());
                    System.out.println("Payment sent to: " + empl.getId());
                }
            } catch (UnpayableEmployeeException e) {
                e.printStackTrace();
                System.out.println("Volunteer is not payed");
            }
        }
    }
}
