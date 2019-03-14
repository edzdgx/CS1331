import java.time.LocalDate;

public class HourlyEmployee2 extends Employee2 {
    private double hourlyWage;
    private double monthlyHours;

    public HourlyEmployee2(String name, LocalDate hireDate,
                            double wage, double hours) {
        super(name, hireDate);
        hourlyWage = wage;
        monthlyHours = hours;
    }

    public double getHourlyWage() { return hourlyWage;}
    public double getMonthlyHours() { return monthlyHours;}
    public double getMonthlyPay() { return hourlyWage * monthlyHours;}

    // overwriting super's getName()
    @Override // meaning we intend to be overwriting something
    public String getName() {
        return "Hourly: " + super.getName(); // using superclass's getName()
    }
}