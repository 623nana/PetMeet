package com.example.jpetstore.controller;

public class SurveyResult {

	private String username;
	private String surveyResult;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setSurveyResult(String surveyResult) {
		this.surveyResult = surveyResult;
	}
	
	public String getSurveyResult() {
		return surveyResult;
	}

	public SurveyResult(String username, String surveyResult) {
		this.username = username;
		this.surveyResult = surveyResult;
	}
	
	public SurveyResult() {
	}
	
}
