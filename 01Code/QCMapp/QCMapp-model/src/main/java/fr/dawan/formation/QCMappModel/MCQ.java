package fr.dawan.formation.QCMappModel;

import java.util.Date;

import fr.dawan.formation.QCMappModelEnum.Status;
import fr.dawan.formation.QCMappModelEnum.Theme;



public class MCQ {

	private int id;
	private String summary;
	private Theme theme;
	private Status status;
	private Date createDate;
	private Date editDate;
	private int idDesigner;
	private int idForum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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
	public int getIdDesigner() {
		return idDesigner;
	}
	public void setIdDesigner(int idDesigner) {
		this.idDesigner = idDesigner;
	}
	public int getIdForum() {
		return idForum;
	}
	public void setIdForum(int idForum) {
		this.idForum = idForum;
	}
	@Override
	public String toString() {
		return "MCQ [id=" + id + ", summary=" + summary + ", theme=" + theme + ", status=" + status + ", createDate="
				+ createDate + ", editDate=" + editDate + ", idDesigner=" + idDesigner + ", idForum=" + idForum + "]";
	}
	public MCQ(int id, String summary, Theme theme, Status status, Date createDate, Date editDate, int idDesigner,
			int idForum) {
		super();
		this.id = id;
		this.summary = summary;
		this.theme = theme;
		this.status = status;
		this.createDate = createDate;
		this.editDate = editDate;
		this.idDesigner = idDesigner;
		this.idForum = idForum;
	}
	public MCQ() {
		super();
	}
	
	
	
	}
