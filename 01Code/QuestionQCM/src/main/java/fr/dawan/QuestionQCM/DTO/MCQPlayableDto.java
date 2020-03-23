package fr.dawan.QuestionQCM.DTO;

import java.time.LocalDateTime;
import java.util.Set;

import fr.dawan.QuestionQCM.Beans.Multimedia;
import fr.dawan.QuestionQCM.Beans.QuestionUsed;

public class MCQPlayableDto {
	private int id;
	private String body;
	private String topic;
	private LocalDateTime createDate;
	private LocalDateTime editDate;
	private String designerPseudo;
	private Multimedia multimedia;
	private Set<Integer> questionsId;
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
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
	public String getDesignerPseudo() {
		return designerPseudo;
	}
	public void setDesignerPseudo(String designerPseudo) {
		this.designerPseudo = designerPseudo;
	}
	public Multimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}
	
	
	
	public Set<Integer> getQuestionsId() {
		return questionsId;
	}
	public void setQuestionsId(Set<Integer> questionsId) {
		this.questionsId = questionsId;
	}
	public MCQPlayableDto() {
		super();
	}
	public MCQPlayableDto(int id, String body, String topic, LocalDateTime createDate, LocalDateTime editDate,
			String designerPseudo, Multimedia multimedia, Set<Integer> questionsId) {
		super();
		this.id = id;
		this.body = body;
		this.topic = topic;
		this.createDate = createDate;
		this.editDate = editDate;
		this.designerPseudo = designerPseudo;
		this.multimedia = multimedia;
		this.questionsId = questionsId;
	}
	
	
	
}
