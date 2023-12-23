package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLvl;

public class Worker {
	private String name;
	private WorkerLvl lvl;
	private double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLvl lvl, double baseSalary, Department department) {
		super();
		this.name = name;
		this.lvl = lvl;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLvl getLvl() {
		return lvl;
	}

	public void setLvl(WorkerLvl lvl) {
		this.lvl = lvl;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department; 
	}

	public void setDep(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// METHODS!!!

	public void addContract(HourContract contracts) {
		this.contracts.add(contracts);
	}

	public void removeContracts(HourContract contracts) {
		this.contracts.remove(contracts);
	}

	public double income(int year, int month) {
		double soma = baseSalary;
		Calendar cal = Calendar.getInstance();

		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				soma += c.totalVaue();
			}
		}

		return soma;
	}

}
