package org.sid.eboutique.metier;

import java.util.List;

import org.sid.eboutique.dao.IBoutiqueDAO;
import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Client;
import org.sid.eboutique.entities.Commande;
import org.sid.eboutique.entities.Panier;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.entities.Role;
import org.sid.eboutique.entities.User;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class BoutiqueMetierImpl  implements IAdminCategoriesMetier{
	private IBoutiqueDAO dao; 

	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}

	public Long ajouterProduit(Produit p, Long IdCat) {
		
		return dao.ajouterProduit(p, IdCat); 
	}

	public void supprimerProduit(Long idPro) {
		dao.supprimerProduit(idPro);
		
	}

	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
		
	}

	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	public Categorie getCategorie(Long idC) {
		
		return dao.getCategorie(idC); 
	}

	public List<Produit> listProduits() {
		
		return dao.listProduits(); 
	}

	public List<Produit> listProduitsParMc(String mc) {
	
		return dao.listProduitsParMc(mc); 
	}

	public List<Produit> listProduitsSelectionne() {
		
		return dao.listProduitsSelectionne(); 
	}

	public List<Produit> listProduitsParCategorie(Long idCat) {
		
		return listProduitsParCategorie(idCat); 
	}

	public Produit getProduit(Long idPro) {
		// TODO Auto-generated method stub
		return getProduit(idPro); 
	}

	public Commande enrigistrerCommande(Panier p, Client c) {
		
		return dao.enrigistrerCommande(p, c); 
	}

	public Long ajouterCategorie(Categorie c) {
		
		return dao.ajouterCategorie(c); 
	}

	public void supprimerCategorie(Long idCat) {
		dao.supprimerCategorie(idCat);
		
	}

	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
		
	}

	public void ajouterUser(User u) {
	dao.ajouterUser(u);
		
	}

	public void attribueRole(User u, Role e) {
		dao.attribueRole(u, e);
		
	}
	

}
