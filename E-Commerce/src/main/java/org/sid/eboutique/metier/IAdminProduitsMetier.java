package org.sid.eboutique.metier;



import java.util.List;

import org.sid.eboutique.entities.Produit;

public interface IAdminProduitsMetier extends InternauteMetier {

	public Long ajouterProduit(Produit p, Long  IdCat);
	public void supprimerProduit(Long idPro);
	public void modifierProduit(Produit p);
	
}
