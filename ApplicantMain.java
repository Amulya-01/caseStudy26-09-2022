package com.gl.caseStudy1;

import java.util.Scanner;

public class ApplicantMain {
	 public static Double totalCalculation (Applicant applicant) {
		 double total=0;
		 total=applicant.getSubject1Mark()+applicant.getSubjec2Mark()+applicant.getSubject3Mark();
		 if ((applicant.getSubject1Mark())< 50)
			 return (double) 0;
		 else if((applicant.getSubjec2Mark())< 50)
			 return (double) 0;
		 else if((applicant.getSubject3Mark())< 50)
			 return (double) 0;
		 else
		 return total;
	 }
	 
	 public static Double percentageCalculation (Double total) {
		 double percentage=(total/300)*100;
		 return percentage;
	 }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
		System.out.println("Enter number of applicants");
		//int num=sc.nextInt();
		int num=Integer.parseInt(sc.nextLine());
		
		if(num<=0) {
			System.out.println("invalid input");
			System.exit(0);
		}

		for(int i=0;i<num;i++) {
			System.out.println("Enter applicants details:");
			String applicant=sc.nextLine();
			String arr[]=applicant.split(",");
			String name=arr[0];
			double marks1=Double.parseDouble(arr[1]);
			double marks2=Double.parseDouble(arr[2]);
			double marks3=Double.parseDouble(arr[3]);
			
	
			if (marks1<0||marks1>100)
				throw new MarksException("invalid marks");
			if (marks2<0||marks2>100)
				throw new MarksException("invalid marks");
			if (marks3<0||marks3>100)
				throw new MarksException("invalid marks");
			
			Applicant applicant1=new Applicant(arr[0],marks1,marks2,marks3,null,null);
			double sum=totalCalculation(applicant1);
			double percent=percentageCalculation(sum);
			Applicant applicant2=new Applicant(arr[0],marks1,marks2,marks3,sum,percent);
			int id=applicant2.getId();
			String output=String.format("%-5s %-10s %-5s %-5s %-5s %-10s %-10s",id, name ,marks1,marks2,marks3,sum,percent);
			System.out.println(output);
			for(String p:arr) {
				System.out.println(p);
				
			}
			
				
				
			
		}
			
		}
		catch(MarksException s) {
	    	System.out.println(s.getMessage());
	    }
		

	}

}
