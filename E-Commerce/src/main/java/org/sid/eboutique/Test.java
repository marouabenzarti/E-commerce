package org.sid.eboutique;

import static org.junit.Assert.assertTrue;

import java.util.List;

		
		
		import org.springframework.context.ApplicationContext;
		import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sid.eboutique.entities.*;
import org.sid.eboutique.metier.BoutiqueMetierImpl;
import org.sid.eboutique.metier.IAdminCategoriesMetier;


@Controller

public class Test {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext( new String [] {"applicationContext.xml"}); 
		ClassPathXmlApplicationContext context2= new ClassPathXmlApplicationContext( new String [] {"applicationContext.xml"}); 
		
				try{
				IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
				List<Categorie> lisCat1 = metier.listCategories();
				metier.ajouterCategorie(new Categorie("Pc Portable", "Pc New", null, "image.jpg"));
				metier.ajouterCategorie(new Categorie("Pc Poste", "Pc Old", null, "image.jpg"));
				List<Categorie> lisCat2 = metier.listCategories();
				assert(lisCat1.size() + 2 == lisCat2.size());
				
				
				}catch(Exception e)
				{
					assertTrue(e.getMessage() , false);
				}
				
			
				try{
					IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context2.getBean("metier");
					List<Produit> prods1 = metier.listProduits();
					metier.ajouterProduit(new Produit("HP Compat","decription",15d,15,true,null),1L);
					metier.ajouterProduit(new Produit("AZERTY","decription",15d,15,true,null),1L);
					List<Produit> prods2 = metier.listProduits();
					assert(prods1.size() + 2 == prods2.size());
					
					}catch(Exception e)
					{
						assertTrue(e.getMessage() , false);
				
					
					
					}
			}
	
	
	

		}

				
				
			
			

		


	


