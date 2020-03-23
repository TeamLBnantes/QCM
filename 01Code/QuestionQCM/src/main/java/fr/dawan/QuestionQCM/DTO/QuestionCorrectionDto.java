package fr.dawan.QuestionQCM.DTO;

import java.util.Set;

public class QuestionCorrectionDto {
	private int id;
	private String commentPostAnswer;
	private Set<AnswerCorrectionDto> answersCorrectionDto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommentPostAnswer() {
		return commentPostAnswer;
	}
	public void setCommentPostAnswer(String commentPostAnswer) {
		this.commentPostAnswer = commentPostAnswer;
	}
	public Set<AnswerCorrectionDto> getAnswersCorrectionDto() {
		return answersCorrectionDto;
	}
	public void setAnswersCorrectionDto(Set<AnswerCorrectionDto> answersCorrectionDto) {
		this.answersCorrectionDto = answersCorrectionDto;
	}
	public QuestionCorrectionDto(int id, String commentPostAnswer, Set<AnswerCorrectionDto> answersCorrectionDto) {
		super();
		this.id = id;
		this.commentPostAnswer = commentPostAnswer;
		this.answersCorrectionDto = answersCorrectionDto;
	}
	public QuestionCorrectionDto() {
		super();
	}

	
	
}
