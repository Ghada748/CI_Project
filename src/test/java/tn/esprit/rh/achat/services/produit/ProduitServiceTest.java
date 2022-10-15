package tn.esprit.rh.achat.services.produit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.IProduitService;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.List;
import java.util.Optional;

@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {

    /*@Autowired
    IProduitService ps;*/

    @Mock
    ProduitRepository prodrepo;

    @InjectMocks
    ProduitServiceImpl ps;

    Produit produit = new Produit(1L,"gh","kj",3);

  /*  @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }*/
@Test
public void testRetrieveUser() {
    Mockito.when(prodrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
    Produit produit1 = ps.retrieveProduit(1L);
    Assertions.assertNotNull(produit1);
}

}
