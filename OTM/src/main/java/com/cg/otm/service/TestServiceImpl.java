package com.cg.otm.service;

import java.util.Random;

import com.cg.otm.bean.Question;
import com.cg.otm.bean.Test;
import com.cg.otm.dao.TestDao;
import com.cg.otm.dao.TestDaoImp;
import com.cg.otm.exception.TestException;

public class TestServiceImpl implements TestService {
private TestDao testDao;

	public TestServiceImpl() {
	
		testDao = new TestDaoImp();
}
	public boolean validateName(String questionTitle) {
		boolean flag =false;
		flag=questionTitle.matches("[\n|\t]+");
		
		return flag;
	}
	public boolean validateTestId(int questionId)
	{
String quesId  = String.valueOf(questionId);
		
		boolean flag = quesId.matches("[0-9]{2}");
		return flag;
	}
	public boolean validateQuestionAnswer(int questionAnswer)
	{
String quesId  = String.valueOf(questionAnswer);
		
		boolean flag = quesId.matches("[1-4]");
		return flag;
	}
	
	// add question
	@Override
	public Question addQuestions(int testId, Question question) throws TestException {
		boolean flag2=validateName(question.getQuestionTitle());
		if(flag2)
		{
			throw new TestException("provide the title");
		}
	
		boolean flag = validateTestId(question.getQuestionId());
		if(!flag)
		{
			throw new TestException("Id should be 2 digit");
		}
		boolean flag1 = validateQuestionAnswer(question.getQuestionAnswer());
		
		if(!flag1) 
		{
			throw new TestException("Answer should be among 1 2 3 4 options");
		}
		return testDao.addQuestions(testId, question);
	
	}
//delete question
	@Override
	public Question deleteQuestions(int testId, Question question) throws TestException {
		boolean flag = validateTestId(question.getQuestionId());
		if(!flag)
		{
			throw new TestException("Id should be 2 digit");
		}
		return testDao.deleteQuestions(testId, question);
	}

	




	
}
