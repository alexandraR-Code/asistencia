package com.krakedev.asistencias.entidades;

public class RegistroAsistencia {
	// atributos
	private Estudiante estudiante;
	private Asistencia asistencia;

	// Constructores
	public RegistroAsistencia() {

	}

	public RegistroAsistencia(Estudiante estudiante, Asistencia asistencia) {
		super();
		this.estudiante = estudiante;
		this.asistencia = asistencia;
	}

	// getter y setters

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Asistencia getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}

	// toString
	@Override
	public String toString() {
		return "RegistroAsistencia [estudiante=" + estudiante + ", asistencia=" + asistencia + "]";
	}

}
