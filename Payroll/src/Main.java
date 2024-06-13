import java.util.*;

public class Main {

    private static class PayrollDBImpl implements PayrollDB {
        private List<Employee> db;

        public PayrollDBImpl(List<Employee> employees) {
            db = employees;
        }

        @Override
        public List<Employee> getEmployeeList() {
            return db;
        }
    }

    public static void main(String[] args) {
        new Main().setUp();
    }

    public void setUp() {
        PayrollDispositionImpl disposition = new PayrollDispositionImpl();
        List<Employee> employeeList;
        Map<Employee, Double> payments;

        Employee e1 = new Appointee("a1", 21, 205, 13);
        Employee e2 = new Volunteer("v1");
        Employee e3 = new Appointee("a2", 15, 120, 25);
        Employee e4 = new Appointee("a3", 21, 163, 11);
        Employee e5 = new Volunteer("v2");
        Employee e6 = new Appointee("a4", 18, 200, 10);
        Employee e7 = new Appointee("a5", 21, 200, 10);
        employeeList = Arrays.asList(e1, e2, e3, e4, e5, e6, e7);

        new Payroll(disposition, 21).doPayroll(new PayrollDBImpl(employeeList));
        payments = disposition.getPayments();
        Map<Employee, Double> map = new HashMap<>();
        map = payments;


    }
}
