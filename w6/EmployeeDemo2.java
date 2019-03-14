import java.time.LocalDate;

public class EmployeeDemo2 {

    public static void main(String[] args) {
        // Employee2 is the static type of emp
        // HourlyEmployee2 is the dynamic type of emp
        // compiler only uses static type
        // thus cannot call HourlyEmployee2 methods on emp
        Employee2 emp = new HourlyEmployee2("Robert Paulson",
                                            LocalDate.of(2018, 9, 24),
                                            100, 168);
        System.out.println(emp.getName());
        // we overwrote getName(), it calls HourlyEmployee2's getName()
        System.out.println(emp.getHireDate());
        //System.out.println(emp.getHourlyWage());
    }

}