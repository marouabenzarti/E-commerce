package org.sid.eboutique.dao;



import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.eboutique.entities.Categorie;
import org.sid.eboutique.entities.Client;
import org.sid.eboutique.entities.Commande;
import org.sid.eboutique.entities.LigneCommande;
import org.sid.eboutique.entities.Panier;
import org.sid.eboutique.entities.Produit;
import org.sid.eboutique.entities.Role;
import org.sid.eboutique.entities.User;



public class BoutiqueDaoImpl implements IBoutiqueDAO {

	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Categorie c").getResultList();
	}



	@Override
	public void supprimerCategorie(Long idCat) {
		// TODO Auto-generated method stub
		Categorie c = getCategorie(idCat);
		em.remove(c);
		
	}

	

	

	@Override
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		return em.createQuery("from Produit").getResultList();
	}

	@Override
	public List<Produit> listProduitsParMc(String mc) {
		// TODO Auto-generated method stub
		Query query =  em.createQuery("select p from Produit p where p.designation like :x or description like :x");
		query.setParameter("x","%"+ mc + "%");
		return query.getResultList();
	}
	
	@Override
	public List<Produit> listProduitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
	  Query q = em.createQuery("select p from Produit p where  p.idCategorie = :x");
	  q.setParameter("x", idCat);
	  return q.getResultList();
	}

	@Override
	public List<Produit> listProduitsSelectionne() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Produit p where  p.selectionne = true").getResultList();
	}

	

	@Override
	public void supprimerProduit(Long idPro) {
		 em.remove(getProduit(idPro));
		
	}

	

	
	
	
	
	
	
	
	
	
	
	

	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public Categorie getCategorie(Long idC) {
		return em.find(Categorie.class, idC);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long ajouterProduit(Produit p, Long IdCat) {
		p.setCategorie(getCategorie(IdCat));
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public Produit getProduit(Long idPro) {
		return em.find(Produit.class, idPro);
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
		
	}

	@Override
	public void attribueRole(User u, Role e) {
		em.persist(e);
		u.getRoles().add(e) ;
		em.persist(u);
	}

	@Override
	public Commande enrigistrerCommande(Panier p, Client c) {
		em.persist(c);
		Commande cat = new Commande();
		cat.setClient(c);
		cat.setLignes(p.getCommandes());
		cat.setDateCommande(new Date());
		for(LigneCommande lc : p.getCommandes())
			em.persist(lc);
		em.persist(cat);
		return cat;
	}

	

	

	

}

