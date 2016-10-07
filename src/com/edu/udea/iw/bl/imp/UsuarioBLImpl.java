/**
 * 
 */
package com.edu.udea.iw.bl.imp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.apache.commons.codec.binary.Hex;
import org.hibernate.HibernateException;

import com.edu.udea.iw.bl.UsuarioBL;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.util.encode.Cifrar;

import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Implementacion de la logica del negocio para un usuario
 * Se implementa el metodo para validar la informacion de un usuario
 * @author Daniel Correa Arango
 *
 */
public class UsuarioBLImpl implements UsuarioBL {
	
	
	MessageDigest md = null;
	UsuarioDao dao;
	
	/**
	 * @return the dao
	 */
	public UsuarioDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	/** 
	 * Se valida la informacion de un usuario dado el login
	 * La contraseña en la base de datos se encuentra encriptada en base 64
	 * @see com.edu.udea.iw.bl.UsuarioBL#validate(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean validate(String login, String pass) throws MyDaoExeption {
		Usuario usr = dao.obtenerPorLogin(login);
		try{
			if(usr!=null && !Validaciones.isTextoVacio(pass)){
				Cifrar cifrado=new Cifrar();
				String passCifrada=cifrado.encrypt(pass);
				if(usr.getContrasena().equals(passCifrada)){
					return true;
				}
			}
		}catch(HibernateException e){
			throw new MyDaoExeption(e);
		}
		return false;
	}

}
