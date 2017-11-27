package org.sid.eboutique.metier;


import java.util.List;

import org.sid.eboutique.entities.*;

public interface InternauteMetier {

	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idC);
	public List<Produit> listProduits();
	public List<Produit> listProduitsParMc(String mc);
	public List<Produit> listProduitsSelectionne();
	public List<Produit> listProduitsParCategorie(Long idCat);
	public Produit getProduit(Long idPro);
	public Commande enrigistrerCommande(Panier p , Client c);

}
