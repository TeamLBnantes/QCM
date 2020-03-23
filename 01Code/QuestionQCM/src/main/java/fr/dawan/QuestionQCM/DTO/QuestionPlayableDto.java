package fr.dawan.QuestionQCM.DTO;

import java.time.LocalDateTime;
import java.util.Set;

import fr.dawan.QuestionQCM.Beans.Answer;
import fr.dawan.QuestionQCM.Beans.Designer;
import fr.dawan.QuestionQCM.Beans.Multimedia;

public class QuestionPlayableDto {
	
	private int id;
	private String body;
	private LocalDateTime createDate;
	private LocalDateTime editDate;
	private String help;
	private String topic;
	private Multimedia multimedia;
	private String designerPseudo;
	private Set<AnswerPlayableDto> answersPlayableDto;
	
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
	
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Multimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}
	
	public String getDesignerPseudo() {
		return designerPseudo;
	}
	public void setDesignerPseudo(String designerPseudo) {
		this.designerPseudo = designerPseudo;
	}

	
	public Set<AnswerPlayableDto> getAnswersPlayableDto() {
		return answersPlayableDto;
	}
	public void setAnswersPlayableDto(Set<AnswerPlayableDto> answersPlayableDto) {
		this.answersPlayableDto = answersPlayableDto;
	}
	public QuestionPlayableDto() {
		// TODO Auto-generated constructor stub
	}
	public QuestionPlayableDto(int id, String body, LocalDateTime createDate, LocalDateTime editDate, String help,
			String topic, Multimedia multimedia, String designerPseudo, Set<AnswerPlayableDto> answersPlayableDto) {
		super();
		this.id = id;
		this.body = body;
		this.createDate = createDate;
		this.editDate = editDate;
		this.help = help;
		this.topic = topic;
		this.multimedia = multimedia;
		this.designerPseudo = designerPseudo;
		this.answersPlayableDto = answersPlayableDto;
	}
	
	
	
}


