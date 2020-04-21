package fr.dawan.formation.AppQCMMono.Models;

public class MailDTO {

		private boolean mailToAdmin, mailToQuestionDesigner, mailToQCMDesigner, mailToUser;
		private String titre;
		private String body;
		private int mcqId;
		private int questionId;
		private int userId;
		private String cible;
		//cible=question (dans gestion des qcm et question), 
		//      =qcm, 
		//      =questionQcm (question dans un qcm)
		//		=admin   des fois que plus tard nou sayont besoin d'un mail vers les admin non lié à qcm ou question
		private boolean emetteurAnonyme;

		public boolean isMailToAdmin() {
			return mailToAdmin;
		}
		public boolean isEmetteurAnonyme() {
			return emetteurAnonyme;
		}
		public void setEmetteurAnonyme(boolean emetteurAnonyme) {
			this.emetteurAnonyme = emetteurAnonyme;
		}
		public void setMailToAdmin(boolean mailToAdmin) {
			this.mailToAdmin = mailToAdmin;
		}
		public boolean isMailToQuestionDesigner() {
			return mailToQuestionDesigner;
		}
		public void setMailToQuestionDesigner(boolean mailToQuestionDesigner) {
			this.mailToQuestionDesigner = mailToQuestionDesigner;
		}
		public boolean isMailToQCMDesigner() {
			return mailToQCMDesigner;
		}
		public void setMailToQCMDesigner(boolean mailToQCMDesigner) {
			this.mailToQCMDesigner = mailToQCMDesigner;
		}
		public boolean isMailToUser() {
			return mailToUser;
		}
		public void setMailToUser(boolean mailToUser) {
			this.mailToUser = mailToUser;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public int getMcqId() {
			return mcqId;
		}
		public void setMcqId(int mcqId) {
			this.mcqId = mcqId;
		}
		public int getQuestionId() {
			return questionId;
		}
		public void setQuestionId(int questionId) {
			this.questionId = questionId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public String getCible() {
			return cible;
		}
		public void setCible(String cible) {
			this.cible = cible;
		}
		public MailDTO() {
			super();

			// TODO Auto-generated constructor stub
		}
		
		
		
}
