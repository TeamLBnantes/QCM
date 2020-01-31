package fr.dawan.formation.QCMappModel;

import java.util.Date;

import fr.dawan.formation.QCMappModelEnum.Status;
import fr.dawan.formation.QCMappModelEnum.Theme;




public class Question {

	private int id;
	private String body;
	private Date createDate;
	private Date editDate;
	private String theme;
	private Status status;
	private String commentPostAnswer;
	private String help;
	private int idMultimedia;
	private int idForum;
	private int idDesigner;
	
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getCommentPostAnswer() {
		return commentPostAnswer;
	}
	public void setCommentPostAnswer(String commentPostAnswer) {
		this.commentPostAnswer = commentPostAnswer;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public int getIdMultimedia() {
		return idMultimedia;
	}
	public void setIdMultimedia(int idMultimedia) {
		this.idMultimedia = idMultimedia;
	}
	public int getIdForum() {
		return idForum;
	}
	public void setIdForum(int idForum) {
		this.idForum = idForum;
	}
	public int getIdDesigner() {
		return idDesigner;
	}
	public void setIdDesigner(int idDesigner) {
		this.idDesigner = idDesigner;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", body=" + body + ", createDate=" + createDate + ", editDate=" + editDate
				+ ", theme=" + theme + ", status=" + status + ", commentPostAnswer=" + commentPostAnswer + ", help="
				+ help + ", idMultimedia=" + idMultimedia + ", idForum=" + idForum + ", idDesigner=" + idDesigner + "]";
	}
	public Question(int id, String body, Date createDate, Date editDate, String theme, Status status,
			String commentPostAnswer, String help, int idMultimedia, int idForum, int idDesigner) {
		super();
		this.id = id;
		this.body = body;
		this.createDate = createDate;
		this.editDate = editDate;
		this.theme = theme;
		this.status = status;
		this.commentPostAnswer = commentPostAnswer;
		this.help = help;
		this.idMultimedia = idMultimedia;
		this.idForum = idForum;
		this.idDesigner = idDesigner;
	}
	public Question() {
		super();
	}

	
	
	
	
}
