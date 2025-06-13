package com.litmus7.school.dto;

import java.util.*;
public class Student {
	private String name;
	private int roll_no;
	private double mark[]=new double[5];
	private double total,avg=0.0;
	private char grade=' ';
	public void inputDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the name");
		name=scanner.nextLine();
		System.out.println("Enter the roll number");
		roll_no=scanner.nextInt();
		System.out.println("Enter the marks of 5 subjects");
		for(int i=0;i<=4;i++) {
			System.out.println("Subject "+(i+1)+":");
			mark[i]=scanner.nextDouble();
		}
		}
	public void calculateTotal() {
		total=0;
		for(int i=0;i<=4;i++)
			total+=mark[i];
		
	}
	public void calculateAverage() {
		avg=total/5;
		
	}
	public void getGrade() {
		if(avg>=90)
			grade='A';
		else if(avg>=75&&avg<90)
			grade='B';
		else if(avg>=60&&avg<75)
			grade='C';
		else if(avg>=50)
			grade='D';
		else
			grade='F';
		}
	
	public void printReportCard() {
		System.out.println("------REPORT CARD-------");
		System.out.println("Name :"+name);
		System.out.println("Roll Number :"+roll_no);
		System.out.println("Total :"+total);
		System.out.println("Average :"+avg);
		System.out.println("Grade :"+grade);
		
	}
}
