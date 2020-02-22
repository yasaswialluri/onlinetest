package com.cg.otm.pl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.cg.otm.bean.Question;
import com.cg.otm.bean.Test;
import com.cg.otm.exception.TestException;
import com.cg.otm.service.TestService;
import com.cg.otm.service.TestServiceImpl;

public class Check {
	public static void main(String[] args) {
		TestService testService = new TestServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		int choice=0;
		Question question = new Question();
		while(choice!=3)
		{
			System.out.println("1.Add Question");
			System.out.println("2. Delete Question");

			System.out.println("3.exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1: 
				System.out.println("Enter the test Id");
				int testId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the question id");
				int questionId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Questin title");
				String name =sc.nextLine();
				System.out.println("enter the question options");
				String a[] = new String[4];
				for(int i=0;i<4;i++)
				{
					a[i]=sc.nextLine();
				}
				System.out.println("Enter the question answer");
				int ans=sc.nextInt();
				System.out.println("Enter the Question marks");
				double mark=sc.nextDouble();
			
				int Id = question.setQuestionId(questionId);
				String title = question.setQuestionTitle(name);
				String []options = (String[]) question.setQuestionOptions(a);
				int answer = question.setQuestionAnswer(ans);
				double marks = question.setQuestionMarks(mark);
				
				try
				{
				 testService.addQuestions(testId,question);
				 System.out.println("Question added");
				 System.out.println(question.getQuestionId()+" "+question.getQuestionTitle()+" "+question.getQuestionAnswer()+" "+question.getQuestionMarks());
					//System.out.println("Test Id = "+id);
				}
				catch(TestException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 2:System.out.println("Enter the testId Id");
			int id=sc.nextInt();
			System.out.println("Enter the question id");
			int questionid = sc.nextInt();
			int Id1 = question.setQuestionId(questionid);
			try {
				testService.deleteQuestions(id, question);
				System.out.println(question.getQuestionId()+" is deleted");
			} catch (TestException e) {
				System.err.println(e.getMessage());
			}
			break;
			case 3: System.out.println("Thank you");
			return;  	
			}
		}
	}
}
