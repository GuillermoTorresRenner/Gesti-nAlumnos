import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicios.PromedioServicioImp;


class CalcularPromedioTest {

	

	@Test
	@DisplayName("Test Averge method")
	void testAdd() {
        List<Double> lista = Arrays.asList(10.0,10.0,1.0);
        PromedioServicioImp promedioServicioImp = new PromedioServicioImp();
        double result = promedioServicioImp.calcularPromedio(lista);
		assertEquals(7, result);
	}

	

}
