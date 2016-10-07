package pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.ClienteDao;
import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exeption.MyDaoExeption;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml")) //Para que coja mi archivo de configuracion
public class ClienteDaoImpHibernateTest {
	
	@Autowired  
	ClienteDao dao;

	@Test
	public void testObtener() {
		List<Cliente> clientes;
		try{
			clientes = dao.obtener();
			assertTrue(clientes.size()> 0);
			
		}catch (MyDaoExeption e) {
			
			fail(e.getMessage());
			
		}
	}

}
