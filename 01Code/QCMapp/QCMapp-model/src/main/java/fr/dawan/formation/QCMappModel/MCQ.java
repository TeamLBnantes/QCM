package fr.dawan.formation.QCMappModel;

import java.time.LocalDateTime;

import fr.dawan.formation.QCMappModelEnum.Status;



public class MCQ extends Entity {

	private String body;
	private Theme theme;
	private Status status;
	private LocalDateTime createDate;
	private LocalDateTime editDate;
	private Designer designer;
	private Forum forum;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getEditDate() {
		return editDate;
	}
	public void setEditDate(LocalDateTime editDate) {
		this.editDate = editDate;
	}
	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	@Override
	public String toString() {
		return "MCQ [body=" + body + ", theme=" + theme + ", status=" + status + ", createDate=" + createDate
				+ ", editDate=" + editDate + ", designer=" + designer + "]";
	}
	
	public MCQ(String body, Theme theme, Status status, LocalDateTime createDate, LocalDateTime editDate,
			Designer designer, Forum forum) {
		super();
		this.body = body;
		this.theme = theme;
		this.status = status;
		this.createDate = createDate;
		this.editDate = editDate;
		this.designer = designer;
		this.forum = forum;
	}
	
	public MCQ() {
		super();
	}
	
	
	
	
	
	
	
	}
