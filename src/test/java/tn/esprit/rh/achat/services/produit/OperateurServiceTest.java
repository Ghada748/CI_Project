package tn.esprit.rh.achat.services.produit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurServiceTest {

    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl os;

    Operateur s = new Operateur(1,"nour","mallek","1234");


    @Test
    @Order(1)
    public void testRetrieveAllOperateurs() {
        List<Operateur> listOperateur = os.retrieveAllOperateurs();
        Assertions.assertEquals(0, listOperateur.size());
    }


    @Test
    @Order(2)
    public void testRetrieveOperateur() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Operateur ss = os.retrieveOperateur(1L);
        Assertions.assertNotNull(ss);
    }
}
