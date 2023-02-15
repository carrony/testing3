package funciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilidadesTest {

	private static Utilidades utils;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Inicializacion primera");
		utils =new Utilidades();
	}
	
	@BeforeEach
	public void iniciliza() {
		System.out.println("Inicializando...");
	}

	@Test
	void testDevuelveNota() {
		assertThrows(ArithmeticException.class,
				()->utils.devuelveNota(-2));
		assertThrows(ArithmeticException.class,
				()->utils.devuelveNota(12));
		//límite
		assertEquals("Suspenso",
				utils.devuelveNota(0));
		assertEquals("Suspenso",
				utils.devuelveNota(4));
		//límite
		assertEquals("Bien",
				utils.devuelveNota(5));
		assertEquals("Bien",
				utils.devuelveNota(6));
		// límite
		assertEquals("Notable",
				utils.devuelveNota(6.5));
		assertEquals("Notable",
				utils.devuelveNota(8.4));
		//límite
		assertEquals("Sobresaliente",
				utils.devuelveNota(8.5));
		assertEquals("Sobresaliente",
				utils.devuelveNota(9.9));
		assertEquals("Matrícula",
				utils.devuelveNota(10));
	}

	@Test
	void testCalculaSalario() {
		assertEquals(200,
			utils.calculaSalario(20, 10, 20));
		assertEquals(420,
			utils.calculaSalario(40, 10, 20));
		assertEquals(Utilidades.HORASJORNADA*10,
			utils.calculaSalario(Utilidades.HORASJORNADA, 10, 20));
		assertThrows(ArithmeticException.class,
				()->utils.calculaSalario(-5, 2, 5));
		assertThrows(ArithmeticException.class,
				()->utils.calculaSalario(5, -2, 5));
		assertThrows(ArithmeticException.class,
				()->utils.calculaSalario(5, 2, -5));
		assertThrows(ArithmeticException.class,
				()->utils.calculaSalario(0, 2, 5));
		assertThrows(ArithmeticException.class,
				()->utils.calculaSalario(5, 0, 5));
		assertThrows(ArithmeticException.class,
				()->utils.calculaSalario(5, 2, 0));
	}

	@Test
	void testCuentaDivisores() {
		assertEquals(4, utils.cuentaDivisores(8));
		assertEquals(1, utils.cuentaDivisores(1));
		assertEquals(2, utils.cuentaDivisores(37));

	}

	@Test
	void testDevuelveMenor() {
		int v[] = { 2,3,8,1,7 };
		assertEquals(1, utils.devuelveMenor(v));
		
		int v2[] = { 2,3,-8,1,7 };
		assertEquals(-8, utils.devuelveMenor(v2));
	}

	@Test
	void testBurbuja() {
		int v[] = {2, 3,1,5,4};
		int v2 [] = {-3,5,2,1,2};
		int v3 [] = {1,2,3,4,5};
		int ordenado1 [] = {1,2,3,4,5};
		int ordenado2 [] = {-3,1,2,2,5};
		
		assertArrayEquals(utils.burbuja(v), ordenado1);
		assertArrayEquals(utils.burbuja(v2), ordenado2);
		assertArrayEquals(utils.burbuja(v3), ordenado1);
	}

}
