package com.krakedev.asistencias.entidades;

//Entidad (modelo): clase que solo guarda los datos de un estudiante. La usan los servicios y los controladores
public class Estudiante {

	// Atributos privados: encapsulamiento; solo se leen o cambian con getters y
	// setters
	private String cedula;
	private String nombre;
	private String apellido;

	// Constructor vacío: Spring lo usa para crear el objeto desde el JSON y luego
	// lo llena con los setters
	public Estudiante() {

	}

	// Constructor sobrecargado (con parámetros): crea el estudiante ya con sus
	// datos
	public Estudiante(String cedula, String nombre, String apellido) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	// Getter: devuelve el valor de un atributo. Setter: asigna o cambia el valor
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// Sobreescribir toString
	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
