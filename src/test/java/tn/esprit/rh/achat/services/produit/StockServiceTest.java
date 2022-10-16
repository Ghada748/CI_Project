package tn.esprit.rh.achat.services.produit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

	 @Mock
	    StockRepository prodrepo;

	    @InjectMocks
	    StockServiceImpl ps;
	    
	    Stock s = new Stock("123kk",25,12);
	    
	    
	      @Test
	    @Order(1)
	    public void testRetrieveAllStock() {
	        List<Stock> listStock = ps.retrieveAllStocks();
	        Assertions.assertEquals(0, listStock.size());
	    }
	    
	    
	    
	    
	    @Test
	    @Order(2)
	    public void testRetrieveStock() {
	        Mockito.when(prodrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
	        Stock ss = ps.retrieveStock(1L);
	        Assertions.assertNotNull(ss);
	    }
	    
	    
	
}
