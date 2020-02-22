package com.cg.otm.service;

import com.cg.otm.bean.Question;

import com.cg.otm.bean.Test;
import com.cg.otm.exception.TestException;

public interface TestService {

public Question addQuestions(int testId,Question question) throws TestException;
	
	public Question deleteQuestions(int testId,Question question) throws TestException ;
}
