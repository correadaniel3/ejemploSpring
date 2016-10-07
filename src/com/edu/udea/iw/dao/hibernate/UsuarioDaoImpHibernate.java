package com.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Implementacion de los metodos para acceder a los usuarios 
 * en la base de datos
 * @author Daniel Correa Arango
 *
 */
public class UsuarioDaoImpHibernate implements UsuarioDao {

	
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*
	 * Implementacion del metodo para obtener todos
	 * los usuarios de la base de datos
	 * @see com.edu.udea.iw.dao.UsuarioDao#obtener()
	 */
	@Override
	public List<Usuario> obtener() throws MyDaoExeption {
		Session session = null;
		List<Usuario> usuarios = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return usuarios;
	}
	
	/*
	 * Implementacion del metodo para obtener un 
	 * usuario dado su nombre de usuario o Login
	 * @see com.edu.udea.iw.dao.UsuarioDao#obtenerPorLogin(java.lang.String)
	 */
	@Override
	public Usuario obtenerPorLogin(String log) throws MyDaoExeption{
		Session session = null;
		Usuario usuario = null;
		
		try {
			session = sessionFactory.openSession();
			usuario = (Usuario) session.get(Usuario.class, log); 
			//Traer un solo registro de la bd dada su clave primaria
			//usuario = (Usuario) session.load(Usuario.class, log);  
			// Con el load el objeto tiene que existir si no retorna una exception
																     	
			// con el get si no existe retorna null
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return usuario;
	}

}
