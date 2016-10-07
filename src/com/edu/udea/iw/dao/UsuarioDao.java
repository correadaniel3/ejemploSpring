package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;


/**
 * Define los metodos para acceder a los usuarios
 * @author Daniel Correa Arango
 *
 */
public interface UsuarioDao {

	/** Obtiene todos los usuarios de la base de datos
	 * 
	 * @return Lista de usuarios
	 * @throws MyDaoExeption
	 */
	public List<Usuario> obtener() throws MyDaoExeption;
	
	
	/**
	 * Metodo para obtener un Usuario dado
	 * su nombre de usuario o Login
	 * @param log
	 * @return Usuario por su login (nombre de usuario)
	 * @throws MyDaoExeption
	 */
	public Usuario obtenerPorLogin(String log) throws MyDaoExeption;
}
