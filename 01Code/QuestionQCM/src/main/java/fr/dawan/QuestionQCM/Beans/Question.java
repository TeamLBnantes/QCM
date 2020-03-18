package fr.dawan.QuestionQCM.Beans;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.dawan.QuestionQCM.Enum.Status;





@Entity

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Question extends Entitie{

	private String body;
	@Column (name="createdate")
	private LocalDateTime createDate;
	@Column (name="editdate")
	private LocalDateTime editDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column (name="commentpostanswer")
	private String commentPostAnswer;
	private String help;
	
	private String topic;
	private String theme;
	
	@OneToOne (mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL}, fetch = FetchType.EAGER)
	private Multimedia multimedia;
	
	@OneToOne
	private Forum forum;
	



	@ManyToOne  (fetch = FetchType.LAZY)
	private Designer designer;
	
	
	@OneToMany(mappedBy = "question",orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL}, fetch = FetchType.EAGER)  //ajouter un lien de type eager
	private Set<Answer> answers;
	
	@JsonIgnore
	@OneToMany (mappedBy = "question", fetch=FetchType.LAZY)
	private Set<QuestionUsed> questionUseds;
	
	
	
	
	
	public Multimedia getMultimedia() {
		return multimedia;
	}


	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}


	public Forum getForum() {
		return forum;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}


	public Set<QuestionUsed> getQuestionUseds() {
		return questionUseds;
	}


	public void setQuestionUseds(Set<QuestionUsed> questionUseds) {
		this.questionUseds = questionUseds;
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	
	public Set<Answer> getAnswers() {
		return answers;
	}


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


	@Override
	public String toString() {
		return "Question [body=" + body + ", commentPostAnswer=" + commentPostAnswer + ",  getId()=" + getId() +",  nqAnswers=" + answers.size() + "]";
	}


	public Designer getDesigner() {
		return designer;
	}


	public void setDesigner(Designer designer) {
		this.designer = designer;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	
	
	
}
