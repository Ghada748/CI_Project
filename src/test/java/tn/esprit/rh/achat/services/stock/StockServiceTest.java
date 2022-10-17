package tn.esprit.rh.achat.services.stock;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockServiceTest {

	@MockBean
	private StockRepository sr;

	private Stock stock1 = new Stock(1L,"stockProduit2", 200, 7,null);
	private Stock stock2 = new Stock(2L,"stockProduit2", 300, 9,null);

	 
	@Autowired
	 IStockService is;


	@Test
	public void addStockTest() {
		when(sr.save(stock1)).thenReturn(stock1);
		assertNotNull(stock1);
		assertEquals(stock1, is.addStock(stock1)); 
		System.out.println("ajout avec succées");
	}


	@Test 
	public void retrieveAllStocksTest() {
		when(sr.findAll()).thenReturn(Stream
				.of(stock1,stock2)
				.collect(Collectors.toList()));
		assertEquals(2,is.retrieveAllStocks().size());
		System.out.println("liste des stocks affiché");
	}



	@Test
	public void DeleteStockTest() {
		sr.save(stock1);
		is.deleteStock(stock1.getIdStock());
		verify(sr, times(1)).deleteById(stock1.getIdStock());
		System.out.println("succées de suppression");
		
	}


	@Test 
	public void UpdateStockTest() {
		when(sr.save(stock1)).thenReturn(stock1);
		assertNotNull(stock1);
		assertEquals(stock1, is.updateStock(stock1));
		System.out.println("succées de mise à jour");
	}

	@Test
	public void retrieveStockTest() {
		when(sr.findById(stock1.getIdStock())).thenReturn(Optional.of(stock1));
		assertEquals(stock1, is.retrieveStock(stock1.getIdStock()));
		System.out.println("succées d affichage");
	}
	    
	    
	
}
