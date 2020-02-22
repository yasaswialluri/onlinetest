package com.cg.otm.dao;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cg.otm.bean.Question;
import com.cg.otm.bean.Test;
import com.cg.otm.exception.TestException;

public class TestDaoImp implements TestDao {
	private Map<Integer,Test> testMap;

	public TestDaoImp()
	{
		testMap=new HashMap<Integer,Test>();
		Question q1 = new Question(11,"",1,0.0,1,0.0);
		Question q2 = new Question(21,"",1,0.0,1,0.0);
		Set<Question>  set1 = new HashSet<Question>();
		Set<Question>  set2 = new HashSet<Question>();
		set1.add(q1);
		set2.add(q2);

		Test  test1 = new Test(1001,"",LocalTime.now(),set1,100.0,0.0,q1,LocalDateTime.now(),LocalDateTime.now());
		Test  test2 = new Test(1002,"",LocalTime.now(),set2,100.0,0.0,q1,LocalDateTime.now(),LocalDateTime.now());
		testMap.put(1001, test1);
		testMap.put(1002, test2);
	}

			
	// add question		
	public Question addQuestions(int testId, Question question) throws TestException {

boolean flag = testMap.containsKey(testId);
if(flag==true)
{
	Test test = testMap.get(testId);
	Set<Question> set =test.getTestQuestions();
	boolean flag2 = set.stream().anyMatch(p->p.getQuestionId()==question.getQuestionId());
			
	if(!flag2)
	{
		set.add(question);
	}
	else
	{

		throw new TestException(question.getQuestionId()+"alreay exist");
	
	
	}
}
else
{
	throw new TestException(testId+" is not found");
}
				
		
		return question;
	}
// delete question
	public Question deleteQuestions(int testId, Question question) throws TestException {
		Question question1=new Question();  
		boolean flag = testMap.containsKey(testId);
		if(flag)
		{
			Test test = testMap.get(testId);
			Set<Question> set =test.getTestQuestions();
			boolean flag2 = set.stream().anyMatch(p->p.getQuestionId()==question.getQuestionId());
			if(flag2)
			{
				question1=question;
				set.remove(question);
			}
		else
			{
				throw new TestException(question.getQuestionId()+" question does not exist");
			
		}
		
		}
		else 
		{
			throw new TestException(testId+" is not found");
		}

		return question1;
	}
	


	





}
