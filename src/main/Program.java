package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLvl;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Entre com o nome do Departamento: ");
		String departmentName = sc.nextLine();
		System.out.println();
		System.out.println("----------Worker data--------- ");
		System.out.print("Worker name: ");
		String workerName = sc.nextLine(); 
		System.out.print("Worker level: ");
		String workerLvl = sc.nextLine();
		System.out.print("Worker base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLvl.valueOf(workerLvl), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker?");
		int n = sc.nextInt();
		
		for(int i=1; i<n; i++) {
			System.out.println("Enter contract #" + i + " data");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours)");
			int hours = sc.nextInt(); 
			HourContract contract = new HourContract(contractDate, valuePerHour, hours ); 
			worker.addContract(contract); 
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY: ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3)); 
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName()); 
		System.out.println("Income for: " + monthAndYear + ": " + worker.income(month, year)); 
		
		sc.close();

	}		
	
}
