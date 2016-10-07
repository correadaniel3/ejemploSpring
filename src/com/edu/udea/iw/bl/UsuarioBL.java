package com.edu.udea.iw.bl;

import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Logica del negocio para el usuario
 * @author Daniel Correa Arango
 *
 */
public interface UsuarioBL {
	
	/**
	 * Se valida que la información del usuario ingresada sea la correcta
	 * @param nombreUsuario
	 * @param contrasena
	 * @return Boolean
	 */
	public Boolean validate(String nombreUsuario, String contrasena) throws MyDaoExeption;

}
