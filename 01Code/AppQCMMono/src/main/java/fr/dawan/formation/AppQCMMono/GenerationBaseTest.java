package fr.dawan.formation.AppQCMMono;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.Theme;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.DesignerDAO;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;
import fr.dawan.formation.AppQCMMono.Persistence.ThemeDAO;

public class GenerationBaseTest {

private static final String FOLDER = "C:\\generateurBaseQcm\\";
	
	//private static Map<String, Formation> formations = new HashMap<>();
	//private static Map<String, Formateur> formateurs = new HashMap<>();
	private static List<Question> questions = new ArrayList<>();
	
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) throws IOException {
		
		generateQuestions();
		//generateFormateurs();
		//generateSessions();
		//generateStagiaires();
		
		save();
	}
	
	private static void generateQuestions()
			throws FileNotFoundException, IOException {
		
		FileReader fileFormationsReader = new FileReader(FOLDER + "question_base_test.csv");
		BufferedReader bufferFormationsReader = new BufferedReader(fileFormationsReader);
		
		String line = bufferFormationsReader.readLine();
		
		while ((line = bufferFormationsReader.readLine()) != null) {
			String[] data = line.split(";");
			
			Question question = new Question();
			question.setBody(data[0]);
			question.setCommentPostAnswer(data[1]);
			
			int themeId = Integer.parseInt(data[9]);
			int designerId = Integer.parseInt(data[6]);

			ThemeDAO daoTheme = new  ThemeDAO(Constantes.PERSISTENCE_UNIT_NAME);	
			Theme theme =daoTheme.findById(Theme.class, themeId);
			daoTheme.close();
			
			DesignerDAO daoDesigner = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME);
			Designer designer=daoDesigner.findById(Designer.class, designerId);
			daoDesigner.close();
			
			question.setTheme("uml");
			question.setDesigner(designer);

			questions.add( question);
		
			//System.out.println(formation);
		} 
		
		bufferFormationsReader.close();
	}

	/*
	 * private static void generateSessions() throws IOException { FileReader
	 * fileSessionsReader = new FileReader(FOLDER + "Sessions.csv"); BufferedReader
	 * bufferSessionsReader = new BufferedReader(fileSessionsReader);
	 * 
	 * String lineSession = bufferSessionsReader.readLine();
	 * 
	 * while ((lineSession = bufferSessionsReader.readLine()) != null) { String[]
	 * data = lineSession.split(";");
	 * 
	 * Formateur formateur = formateurs.get(data[1]); Formation formation =
	 * formations.get(data[2]);
	 * 
	 * if (formateur != null && formation != null) { LocalDate date =
	 * LocalDate.parse(data[0], dateTimeFormatter);
	 * 
	 * SessionFormation session = new SessionFormation();
	 * session.setDateDebut(date); session.setFormateur(formateur);
	 * 
	 * // Pour générer la clé étrangère session.setFormation(formation);
	 * 
	 * // Pour déclencher le cascade-persist formation.getSessions().add(session);
	 * 
	 * sessions.add(session); } }
	 * 
	 * bufferSessionsReader.close(); }
	 * 
	 * private static void generateFormateurs() throws FileNotFoundException,
	 * IOException {
	 * 
	 * FileReader fileFormateursReader = new FileReader(FOLDER + "Formateurs.csv");
	 * BufferedReader bufferFormateursReader = new
	 * BufferedReader(fileFormateursReader);
	 * 
	 * String lineFormateur = bufferFormateursReader.readLine();
	 * 
	 * while ((lineFormateur = bufferFormateursReader.readLine()) != null) {
	 * String[] data = lineFormateur.split(";");
	 * 
	 * Formateur formateur = formateurs.get(data[0]); if (formateur == null) {
	 * 
	 * formateur = new Formateur();
	 * 
	 * formateur.setMatricule(data[0]); formateur.setNom(data[1]);
	 * formateur.setPrenom(data[2]); formateur.setTitre(getTitre(data[4]));
	 * 
	 * formateurs.put(data[0], formateur); }
	 * 
	 * Formation formation = formations.get(data[3]); if (formation != null) {
	 * formation.getFormateursCompetents().add(formateur); }
	 * 
	 * //System.out.println(formation); }
	 * 
	 * bufferFormateursReader.close(); }
	 * 
	 * private static void generateStagiaires() throws IOException { FileReader
	 * fileStagiaireReader = new FileReader(FOLDER + "Stagiaires.csv");
	 * BufferedReader bufferStagiairesReader = new
	 * BufferedReader(fileStagiaireReader);
	 * 
	 * String lineStagiaire = bufferStagiairesReader.readLine();
	 * 
	 * while ((lineStagiaire = bufferStagiairesReader.readLine()) != null) {
	 * String[] data = lineStagiaire.split(";");
	 * 
	 * LocalDate date = LocalDate.parse(data[3], dateTimeFormatter); LocalDate
	 * dateSession = LocalDate.parse(data[5], dateTimeFormatter);
	 * 
	 * Stagiaire stagiaire = new Stagiaire();
	 * 
	 * stagiaire.setCodeStagiaire(UUID.randomUUID().toString());
	 * stagiaire.setNom(data[0]); stagiaire.setPrenom(data[1]);
	 * stagiaire.setTitre(getTitre(data[2])); stagiaire.setDateInscription(date);
	 * 
	 * sessions.forEach(s -> getSession(s, stagiaire, data[4], dateSession)); }
	 * 
	 * bufferStagiairesReader.close(); }
	 */

	private static void save() {
		GenericDAO<Question> dao = new  GenericDAO<>(Constantes.PERSISTENCE_UNIT_NAME);
			
		for (Question question : questions) {
			dao.saveOrUpdate(question);	
		}
		dao.close();
	}
	
	/*
	 * private static void getSession(SessionFormation session, Stagiaire stagiaire,
	 * String codeFormation, LocalDate dateSession) { if
	 * (session.getDateDebut().isEqual(dateSession) &&
	 * codeFormation.equals(session.getFormation().getCode())) {
	 * session.getStagiaires().add(stagiaire); } }
	 * 
	 * private static Titre getTitre(String data) { Titre titre = Titre.INCONNU; try
	 * { titre = Titre.valueOf(data); } catch (Exception ex) {
	 * System.out.println("Titre " + data + " inconnu"); } return titre; }
	 */
	
}
