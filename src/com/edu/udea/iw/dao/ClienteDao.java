package com.edu.udea.iw.dao;

import java.util.List;



import com.edu.udea.iw.dto.Cliente;
import com.edu.udea.iw.exeption.MyDaoExeption;


/**
 * Define los metodos para acceder a los clientes
 * @author Daniel Correa Arango
 *
 */
public interface ClienteDao {

	/**
	 * Permite crear un cliente nuevo en la base de datos
	 * @param cliente
	 * @throws MyDaoExeption
	 */
	public void crear(Cliente cliente) throws MyDaoExeption;
	
	/**
	 * Obtiene todos los clientes de la base de datos
	 * @throws MyDaoExeption
	 * @return Lista de clientes
	 */
	public List<Cliente> obtener() throws MyDaoExeption;
	
	/**
	 * Elimina un cliente de la base de datos
	 * @throws MyDaoExeption
	 */
	public void eliminar(String cedula) throws MyDaoExeption;
	
	/**
	 * Se obtiene un cliente dada su cedula
	 * @param cedula
	 * @throws MyDaoExeption
	 * @return Cliente por su cedula
	 */
	public Cliente obtenerPorCedula(String cedula) throws MyDaoExeption;
}
