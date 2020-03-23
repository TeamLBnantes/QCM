package fr.dawan.QuestionQCM.DTO;

public class AnswerCorrectionDto {
	
	private int id;
	private boolean expectedAnswer;
	private String commentPostAnswer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isExpectedAnswer() {
		return expectedAnswer;
	}
	public void setExpectedAnswer(boolean expectedAnswer) {
		this.expectedAnswer = expectedAnswer;
	}
	public String getCommentPostAnswer() {
		return commentPostAnswer;
	}
	public void setCommentPostAnswer(String commentPostAnswer) {
		this.commentPostAnswer = commentPostAnswer;
	}
	public AnswerCorrectionDto(int id, boolean expectedAnswer, String commentPostAnswer) {
		super();
		this.id = id;
		this.expectedAnswer = expectedAnswer;
		this.commentPostAnswer = commentPostAnswer;
	}
	public AnswerCorrectionDto() {
		super();
	}
	
	

}
