package com.Employee;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		
		Employee_Manager.establish_connection();
		int a = 0;
		Scanner s = new Scanner(System.in);
		do {
			menu();
			a = s.nextInt();
			switch(a)
			{
			case 1:
				Employee_Manager.all_details();
				break;
			case 2:
				System.out.println("Give How many Number of Employee Data You want to Enter");
				System.out.print("->>");
				int n = s.nextInt();
				if(n==1)
					Employee_Manager.add_new();
				else
				{
					Employee_Manager.add_many(n);
					System.out.println(n+"Employee Details Saved");
				}
				break;
			case 3:
				System.out.println("Showing Old Details");
				Employee_Manager.all_details();
				Employee_Manager.update();
				System.out.println("Updated Successfully");
				System.out.println("''''''''''''''''''''");
				break;
			case 4:
				Employee_Manager.all_details();
				System.out.print("Whome you want to Delete >");
				Employee_Manager.delete();
				System.out.println("Deleted Successfully");
				System.out.println("''''''''''''''''''''");
				break;
			case 9:exit();break;
			default:
				System.out.println("Enter Vaild Option");break;
			}
		}while(a != 9);

	}
	
	private static void menu()
	{
		System.out.println("MENU");
		System.out.println("1-> For View Employee Details");
		System.out.println("2-> For Add New Employee Details");
		System.out.println("3-> For Update Employee Details");
		System.out.println("4-> For Delete Employee Details");
		System.out.println("9-> For Exiting the Database");
		System.out.print("Enter Here>>>");
	}
	
	private static void exit()
	{
		System.out.println("....................THANK YOU....................");
	}

}
