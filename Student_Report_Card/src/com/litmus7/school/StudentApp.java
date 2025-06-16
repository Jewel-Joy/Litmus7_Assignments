package com.litmus7.school;

import java.util.Scanner;

import com.litmus7.school.dto.Student;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of students");
		int n = scanner.nextInt();
		Student students[] = new Student[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the details of student" + (i + 1));
			students[i] = new Student();
			students[i].inputDetails();
			students[i].calculateTotal();
			students[i].calculateAverage();
			students[i].getGrade();
		}
		for (int i = 0; i < n; i++) {
			System.out.println("The Report Card of student" + (i + 1));
			students[i].printReportCard();
		}

	}

}
