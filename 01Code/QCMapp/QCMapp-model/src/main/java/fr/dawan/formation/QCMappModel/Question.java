package fr.dawan.formation.QCMappModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.dawan.formation.QCMappModelEnum.Status;



@Entity
public class Question extends Entitie{

	private String body;
	private LocalDateTime createDate;
	private LocalDateTime editDate;
	private Status status;
	private String commentPostAnswer;
	private String help;
	/*@ManyToOne
	private Theme theme;
	@OneToOne
	private Multimedia multimedia;
	@OneToOne
	private Forum forum;
	@ManyToOne 
	private Designer designer;
	@OneToMany(mappedBy = "question")
	private Set<Answer> answers;
	*/
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	/*
	 * public Set<Answer> getAnswers() { return answers; } public void
	 * setAnswers(Set<Answer> answers) { this.answers = answers; }
	 */
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
	/*
	 * public Theme getTheme() { return theme; } public void setTheme(Theme theme) {
	 * this.theme = theme; } public Multimedia getMultimedia() { return multimedia;
	 * } public void setMultimedia(Multimedia multimedia) { this.multimedia =
	 * multimedia; } public Forum getForum() { return forum; } public void
	 * setForum(Forum forum) { this.forum = forum; } public Designer getDesigner() {
	 * return designer; } public void setDesigner(Designer designer) { this.designer
	 * = designer; }
	 */
	
	
	
	
	
}
