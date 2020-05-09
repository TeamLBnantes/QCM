package fr.dawan.formation.AppQCMMono.Models;

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
import javax.persistence.Transient;

import fr.dawan.formation.AppQCMMono.Enum.Status;

@Entity
public class MCQ extends Entitie {

	@Column(columnDefinition="text", length=2000)
	private String body;
	private String topic;
	private String theme;
	@Enumerated(EnumType.STRING)
	private Status status;
	private LocalDateTime createDate;
	private LocalDateTime editDate;
	@ManyToOne
	private Designer designer;

	@OneToOne
	private Forum forum;
	
	@OneToOne (mappedBy = "mcq", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL}, fetch = FetchType.EAGER)
	private Multimedia multimedia;

	@OneToMany(mappedBy = "mcq")
	private Set<QuestionUsed> questionUseds;

	@OneToMany(mappedBy = "mcq")
	private Set<MCQpassed> mcQpasseds;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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



	public Multimedia getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	public Set<QuestionUsed> getQuestionUseds() {
		return questionUseds;
	}

	public void setQuestionUseds(Set<QuestionUsed> questionUseds) {
		this.questionUseds = questionUseds;
	}

	public Set<MCQpassed> getMcQpasseds() {
		return mcQpasseds;
	}

	public void setMcQpasseds(Set<MCQpassed> mcQpasseds) {
		this.mcQpasseds = mcQpasseds;
	}

	@Override
	public String toString() {
		return "MCQ [body=" + body + ", topic=" + topic + ", theme=" + theme + ", status=" + status + ", createDate="
				+ createDate + ", editDate=" + editDate + ", designer=" + designer + ", forum=" + forum
				 + "]";
	}

	public MCQ(String body, String theme, Status status, LocalDateTime createDate, LocalDateTime editDate,
			Designer designer, Forum forum, String topic) {
		super();
		this.body = body;
		this.theme = theme;
		this.status = status;
		this.createDate = createDate;
		this.editDate = editDate;
		this.designer = designer;
		this.forum = forum;
		this.topic=topic;
	}

	public MCQ() {
		super();
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
