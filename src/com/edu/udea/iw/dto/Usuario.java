package com.edu.udea.iw.dto;

/**
 * Dto para la tablar Usuario
 * @author Daniel Correa Arango
 *
 */
public class Usuario {

	
	private String login;
	private String nombres;
	private String apellidos;
	private String contrasena;
	private Rol rol;
	
	/*
	 * Getters And Setters de los atributos
	 */
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
