package pruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml")) //Para que coja mi archivo de configuracion
public class UsuarioDaoImpHibernateTest {

	@Autowired
	UsuarioDao dao;
	
	@Test
	public void testObtenerPorLogin() {
		Usuario user;
		try {
			user=dao.obtenerPorLogin("elver");
			assertTrue(user!=null);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	} 
	
	@Test
	public void testObtener() {
		List<Usuario> usuarios;
		try {
			usuarios=dao.obtener();
			assertTrue(usuarios.size()>0);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

}
