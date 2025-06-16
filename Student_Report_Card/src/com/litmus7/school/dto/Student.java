package com.litmus7.school.dto;

import java.util.Scanner;

//dto class to store student details
public class Student {
	private String name;
	private int rollNo;
	private double marks[] = new double[5];
	private double total, avg = 0.0;
	private Grade grade;
//enum to store grade of student
	enum Grade{
		A,B,C,D,F;
	}
//to input details of student
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name");
		name = scanner.nextLine();
		System.out.println("Enter the roll number");
	      rollNo = scanner.nextInt();
		System.out.println("Enter the marks of 5 subjects");
		for (int i = 0; i <= 4; i++) {
			System.out.println("Subject " + (i + 1) + ":");
			marks[i] = scanner.nextDouble();
		}
	}
	//to calculate total marks of student
	public void calculateTotal() {
		total = 0;
		for (double i:marks)
			total += i;
	}
//to calculate average marks of student
	public void calculateAverage() {
		avg = total / 5;
	}
//to get grade of student
	public void getGrade() {
		if (avg >= 90)
			grade = Grade.A;
		else if (avg >= 75 && avg < 90)
			grade = Grade.B;
		else if (avg >= 60 && avg < 75)
			grade = Grade.C;
		else if (avg >= 50)
			grade = Grade.D;
		else
			grade = Grade.F;
	}
//to print report card of student
	public void printReportCard() {
		System.out.println("------REPORT CARD-------");
		System.out.println("Name :" + name);
		System.out.println("Roll Number :" + rollNo);
		System.out.println("Total :" + total);
		System.out.println("Average :" + avg);
		System.out.println("Grade :" + grade);

	}
}

