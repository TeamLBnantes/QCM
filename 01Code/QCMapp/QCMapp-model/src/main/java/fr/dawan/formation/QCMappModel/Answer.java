package fr.dawan.formation.QCMappModel;

public class Answer {

	private int id;
	private String body;
	private boolean expectedAnswer;
	private String commentPostAnswer;
	private int idQuestion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
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
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", body=" + body + ", expectedAnswer=" + expectedAnswer + ", commentPostAnswer="
				+ commentPostAnswer + ", idQuestion=" + idQuestion + "]";
	}
	public Answer(int id, String body, boolean expectedAnswer, String commentPostAnswer, int idQuestion) {
		super();
		this.id = id;
		this.body = body;
		this.expectedAnswer = expectedAnswer;
		this.commentPostAnswer = commentPostAnswer;
		this.idQuestion = idQuestion;
	}
	public Answer() {
		super();
	}

	
	
}