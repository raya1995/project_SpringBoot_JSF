package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Reclamation;


public interface ReclamationService {


	public void addReclamation(Reclamation r);

	public List<Reclamation> retrieveAllReclamations();	
	void deleteReclamation(Long id);
	

	public void ajouterReclamation(Reclamation reclamation);
	public void deleteReclamation(long id);
	Reclamation findReclamation(String id);
	List<Reclamation> afficherReclamation();
	public void affecterreclamationUser(String idReclamation,String IdUser);
	public void ajouterReclamationuser(Reclamation reclamation,String IdUser);
	
	
	

}
