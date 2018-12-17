package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excepciones.DAOExcepcion;
import persistencia.CategoriaDAOImp;
import persistencia.dto.CategoriaDTO;

public class UnitCategoria {
	CategoriaDAOImp edao;
	@Before
	public void setUp() {
	    try {
	    	edao = new CategoriaDAOImp();
	    	edao.crearCategoria(new CategoriaDTO("Patata", 10, 5, 1, 100, 50, null));

	    } catch (DAOExcepcion e) {
	      e.printStackTrace();
	    }
	}

	@Test
	public void testGetPrecioModIlimitada() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrecioModIlimitada() {
		try{
			CategoriaDTO cat = edao.buscarCategoria("Patata");
			cat.setPrecioModIlimitada(20);
			assertEquals(20, cat.getPrecioModIlimitada(), 0.01);
		}
		catch (DAOExcepcion e){
			fail("Error de la BD");
		}
	}

	@Test
	public void testGetPrecioModKms() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrecioModKms() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrecioKmModKms() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrecioKmModKms() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrecioSeguroTRiesgo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrecioSeguroTRiesgo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrecioSeguroTerceros() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrecioSeguroTerceros() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSuperior() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSuperior() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListaCoches() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetListaCoches() {
		fail("Not yet implemented");
	}

	@Test
	public void testCategoria() {
		fail("Not yet implemented");
	}

}
