package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employees> list = new ArrayList<>();
		
		//Get how many employees will be registered

		System.out.print("How many employees will be registered?");
		int n = sc.nextInt();

		//Add new employees
		
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1)+":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while(hasId(list,id)) {
				System.out.print("This Id is already taken.Try again: ");
				id = sc.nextInt();
				System.out.println();
				
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employees(id, name, salary));
			System.out.println();
		}

		//Get what employee will have a salary increase
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employees result = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (result == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double increase = sc.nextDouble();
			result.increaseSalary(increase);
		}

		//print the list of employees salary 
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employees obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

	//Verify if the id already exist
	
	public static boolean hasId(List<Employees> list, int id) {
		Employees emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
