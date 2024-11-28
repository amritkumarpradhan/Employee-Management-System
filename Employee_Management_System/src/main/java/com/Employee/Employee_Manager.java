package com.Employee;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee_Manager {
	static Connection conn;
	public static void establish_connection()
	{
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("...");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Employee_Management?user=postgres&password=123");
			System.out.println("Connected to Employee Database");
			System.out.println("------------------------------");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void all_details()
	{
		try {
			Statement st = conn.createStatement();
			String sql = "Select * from employee";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.print("[ID ="+rs.getInt(1)+",");
				System.out.print("Name ="+rs.getString(2)+",");
				System.out.print("Age ="+rs.getInt(3)+",");
				System.out.print("Job Role ="+rs.getString(4)+",");
				System.out.print("Email ="+rs.getString(5)+",");
				System.out.println("Location ="+rs.getString(6)+",]");
			}
			System.out.println("................................................................");
			System.out.println("................................................................");
		}catch (Exception e)
		{
			System.out.println("e");
		}
		
	}
	
	public static void add_new()
	{
		try {
			String sql = "Insert into employee values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			Scanner s = new Scanner(System.in);
			System.out.print("Enter New Employee Id :");
			int id = s.nextInt();
			System.out.print("Enter Name :");
			String name = s.next();
			System.out.print("Enter age :");
			int age = s.nextInt();
			System.out.print("Enter Role :");
			String role = s.next();
			System.out.print("Enter Email :");
			String email = s.next();
			System.out.print("Enter Location :");
			String loc = s.next();
			
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setString(4, role);
			pst.setString(5, email);
			pst.setString(6, loc);
			
			pst.execute();
			
		}catch (Exception e)
		{
			System.out.println("e");
		}
		
	}
	
	public static void add_many(int n)
	{
		try {
			String sql = "Insert into employee values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			Scanner s = new Scanner(System.in);
			System.out.println("----");
			while(n>0)
			{
				System.out.print("Enter New Employee Id :");
				int id = s.nextInt();
				System.out.print("Enter Name :");
				String name = s.next();
				System.out.print("Enter age :");
				int age = s.nextInt();
				System.out.print("Enter Role :");
				String role = s.next();
				System.out.print("Enter Email :");
				String email = s.next();
				System.out.print("Enter Location :");
				String loc = s.next();
				
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setInt(3, age);
				pst.setString(4, role);
				pst.setString(5, email);
				pst.setString(6, loc);
				
				pst.addBatch();
				n--;
			}
			pst.executeBatch();
			
		}catch (Exception e)
		{
			System.out.println("e");
		}
		
	}
	
	public static void update()
	{
		try {
			String sql = "Update employee set role=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			Scanner s = new Scanner(System.in);
			System.out.print("Enter Id :");
			int id = s.nextInt();
			System.out.print("Enter Promoted Role :");
			String role = s.next();

			pst.setString(1, role);
			pst.setInt(2, id);
		
			pst.execute();
			
		}catch (Exception e)
		{
			System.out.println("e");
		}
		
	}
	
	public static void delete()
	{
		try {
			String sql = "Delete from employee where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			Scanner s = new Scanner(System.in);
			System.out.print("Enter Id :");
			int id = s.nextInt();
			
			pst.setInt(1, id);
		
			pst.execute();
			
		}catch (Exception e)
		{
			System.out.println("e");
		}
		
	}
	
	
	//public static void main(String[] args)
//	{
//		establish_connection();
//		add_new();
//		all_details();
//	}

}

