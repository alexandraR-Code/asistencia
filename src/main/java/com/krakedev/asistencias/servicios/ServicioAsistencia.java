package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

//Servicio de asistencia: lógica de registrar y consultar asistencias; guarda los registros en memoria
@Service
public class ServicioAsistencia {

	// Atributos

	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();

	private final ServicioEstudiantes servicioEstudiantes;

	// constructor

	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	// Registra la asistencia de hoy (estado P) de un estudiante existente; devuelve
	// el registro o null si el estudiante no existe.
	public RegistroAsistencia registrarAsistencia(String cedula) {
		Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);
		if (estudiante == null) {
			return null;
		}
		Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");
		RegistroAsistencia registro = new RegistroAsistencia(estudiante, asistencia);
		registros.add(registro);
		return registro;

	}

	public ArrayList<Asistencia> consultarAsistencia(String cedula) {
		ArrayList<Asistencia> asistencias = new ArrayList<>();
		for (RegistroAsistencia registro : registros) {
			if (registro.getEstudiante().getCedula().equals(cedula)) {
				asistencias.add(registro.getAsistencia());

			}
		}
		return asistencias;
	}
}
