package com.company;
import java.util.Scanner;
class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    public Employee(String firstName,String lastName,String socialSecurityNumber) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.socialSecurityNumber=socialSecurityNumber;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }
    @Override
    public String toString() {
        return String.format("First_name: "+firstName+"\n"+"Last_name: "+lastName+"\n"+"SocialSecurityNumber: "+socialSecurityNumber);
    }
}
class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;
    private double baseSalary;
    public CommissionEmployee(String firstName, String lastName,
                              String socialSecurityNumber, double grossSales,
                              double commissionRate,double baseSalary) {
        super(firstName, lastName, socialSecurityNumber);
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");
        }
        else {
            this.baseSalary = baseSalary;
        }}
    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");
        this.grossSales = grossSales;
    }
    public double getGrossSales()
    {
        return grossSales;
    }
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");
        this.commissionRate = commissionRate;}
    public double getCommissionRate()
    {
        return commissionRate;
    }
    public double earnings()
    {
        return getCommissionRate() * getGrossSales() ;
    }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");
        this.baseSalary = baseSalary;
    }
    public double getBaseSalary()
    {
        return baseSalary;
    }
    @Override
    public String toString() {
        return String.format(super.toString()+"\n"+
                "Commission Rate: "+getCommissionRate()+"\n"+"GrossSales: "+getGrossSales()+"\n"+"Salary: "+getBaseSalary());
    }
}
public class Main {
    public static void main(String[] args) {
        CommissionEmployee emp=new CommissionEmployee("Bob","Lewis",
                "333-33-33",5000,0.04,300);
        System.out.println(emp.toString());
        emp.setBaseSalary(1000);
        System.out.println("=================================================");
        System.out.println(emp.toString());
    }
}
