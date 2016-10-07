package com.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.edu.udea.iw.dao.CiudadDao;
import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exeption.MyDaoExeption;


/**
 * Implementacion de los metodos para acceder a las ciudades 
 * en la base de datos
 * @author Daniel Correa Arango
 *
 */
public class CiudadDadoImpHibernate implements CiudadDao {

	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Implementacion del metodo para obtener
	 * todas las ciudades 
	 */
	@Override
	public List<Ciudad> obtener() throws MyDaoExeption {
		
		Session session = null;
		List<Ciudad> resultado = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Ciudad.class);
			resultado = criteria.list();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return resultado;
		
	}
	
	/*
	 * Implementacion del metodo para
	 * obtener una ciudad por su codigo
	 * @see com.edu.udea.iw.dao.CiudadDao#obtener(long)
	 */
	@Override
	public Ciudad obtener(long codigo) throws MyDaoExeption {
		Session session = null;
		Ciudad ciudad = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Ciudad.class).add(Restrictions.eq("Codigo", codigo));
			ciudad = (Ciudad)criteria.uniqueResult();
			// Hay otras dos formas de hacerla Consultarlo!
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return ciudad;
	}

	/*
	 * Implementacion del metodo para guardar
	 * una ciudad en la base de datos
	 * @see com.edu.udea.iw.dao.CiudadDao#guardar(com.edu.udea.iw.dto.Ciudad)
	 */
	@Override
	public void guardar(Ciudad ciudad) throws MyDaoExeption {
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(ciudad); 
			transaction.commit();
			
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
	
	}

	/*
	 * Implementacion del metodo para editar una 
	 * ciudad en la base de datos
	 * @see com.edu.udea.iw.dao.CiudadDao#modificar(com.edu.udea.iw.dto.Ciudad)
	 */
	@Override
	public void modificar(Ciudad ciudad) throws MyDaoExeption {
		Session session = null;
		
		
		try {
			
			session = sessionFactory.openSession();
			session.update(ciudad); 
			
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
	
	}

	/*
	 * Implementacion del metodo para borrar
	 * una ciudad de la base de datos
	 * @see com.edu.udea.iw.dao.CiudadDao#eliminar(long)
	 */
	@Override
	public void eliminar(long codigo) throws MyDaoExeption {
		Session session = null;
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(codigo);
		
		try {
			
			session = sessionFactory.openSession();
			session.delete(ciudad); 
			
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
	}

}
