package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.bl.UsuarioBL;
import com.edu.udea.iw.bl.imp.UsuarioBLImpl;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.exeption.MyDaoExeption;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml")) //Para que coja mi archivo de configuracion
public class UsuarioBLImplTest {

	@Autowired
	UsuarioBL dao;
	
	@Test
	public void testValidate() throws MyDaoExeption {
		try{
			assertTrue(dao.validate("elver", "elver"));
		}catch(MyDaoExeption e){
			fail(e.getMessage());
		}
	}

}
