package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import fr.dawan.formation.AppQCMMono.Enum.Status;

@Entity
public class MCQ extends Entitie {

	private String body;
	private String theme;
	@Enumerated(EnumType.STRING)
	private Status status;
	private LocalDateTime createDate;
	private LocalDateTime editDate;
	@ManyToOne
	private Designer designer;

	@OneToOne
	private Forum forum;

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

	@Override
	public String toString() {
		return "MCQ [body=" + body + ", theme=" + theme + ", status=" + status + ", createDate=" + createDate
				+ ", editDate=" + editDate + ", designer=" + designer + "]";
	}

	public MCQ(String body, String theme, Status status, LocalDateTime createDate, LocalDateTime editDate,
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
