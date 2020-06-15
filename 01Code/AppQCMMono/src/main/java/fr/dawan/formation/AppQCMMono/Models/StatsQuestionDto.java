package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;
import java.util.List;
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

import fr.dawan.formation.AppQCMMono.Enum.Status;





public class StatsQuestionDto extends Entitie{

	private int id;
	private String body;
	private String topic;
	private Designer designer;
	private int nbUsedByQcms;
	private int nbAnswered;
	private int nbCorrect;
	
	private List<StatsQuestionUsedDto> questionUsedDtos;

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

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}

	public int getNbUsedByQcms() {
		return nbUsedByQcms;
	}

	public void setNbUsedByQcms(int nbUsedByQcms) {
		this.nbUsedByQcms = nbUsedByQcms;
	}

	public int getNbAnswered() {
		return nbAnswered;
	}

	public void setNbAnswered(int nbAnswered) {
		this.nbAnswered = nbAnswered;
	}

	public int getNbCorrect() {
		return nbCorrect;
	}

	public void setNbCorrect(int nbCorrect) {
		this.nbCorrect = nbCorrect;
	}

	public List<StatsQuestionUsedDto> getQuestionUsedDtos() {
		return questionUsedDtos;
	}

	public void setQuestionUsedDtos(List<StatsQuestionUsedDto> questionUsedDtos) {
		this.questionUsedDtos = questionUsedDtos;
	}

	public StatsQuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StatsQuestionDto [id=" + id + ", body=" + body + ", topic=" + topic + ", designer=" + designer
				+ ", nbUsedByQcms=" + nbUsedByQcms + ", nbAnswered=" + nbAnswered + ", nbCorrect=" + nbCorrect
				+ ", questionUsedDtos=" + questionUsedDtos + "]";
	}
	
	
	
	
	
	
	
	
}
