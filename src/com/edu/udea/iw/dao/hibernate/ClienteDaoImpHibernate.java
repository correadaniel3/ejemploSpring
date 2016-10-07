/**
 * 
 */
package com.edu.udea.iw.dao.hibernate;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.edu.udea.iw.dao.ClienteDao;
import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Implementacion de los metodos para acceder a los clientes 
 * en la base de datos
 * @author Daniel Correa Arango
 *
 */
public class ClienteDaoImpHibernate implements ClienteDao {
	
private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/* Implementacion del metodo para insertar
	 * un cliente en la base de datos
	 * @see com.edu.udea.iw.dao.ClienteDao#crear(com.edu.udea.iw.dto.Cliente)
	 */
	@Override
	public void crear(Cliente cliente) throws MyDaoExeption {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(cliente); 
			transaction.commit();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}

	}

	/*
	 * Implementacion del metodo para obtener todos los
	 * clientes de la base de datos
	 * @see com.edu.udea.iw.dao.ClienteDao#obtener()
	 */
	@Override
	public List<Cliente> obtener() throws MyDaoExeption {
		// TODO Auto-generated method stub
		
		Session session = null;
		List<Cliente> clientes = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Cliente.class);
			clientes = criteria.list();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return clientes;
		
	}

	/*
	 * Implementacion del metodo para borrar un cliente
	 * de la base de datos dada su cedula
	 * @see com.edu.udea.iw.dao.ClienteDao#eliminar(java.lang.String)
	 */
	@Override
	public void eliminar(String cedula) throws MyDaoExeption {
		Session session = null;
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		
		try {
			
			session = sessionFactory.openSession();
			session.delete(cliente); 
			
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
	}

	/*
	 * Implementacion del metodo para obtener un
	 * cliente de la base de datos dada su cedula
	 * @see com.edu.udea.iw.dao.ClienteDao#obtenerPorCedula(java.lang.String)
	 */
	@Override
	public Cliente obtenerPorCedula(String cedula) throws MyDaoExeption {
		// TODO Auto-generated method stub
		
		
		Session session = null;
		Cliente cliente = null;
		
		try {
			session = sessionFactory.openSession();
			cliente = (Cliente) session.get(Cliente.class, cedula); 
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return cliente;
		
	}

}
