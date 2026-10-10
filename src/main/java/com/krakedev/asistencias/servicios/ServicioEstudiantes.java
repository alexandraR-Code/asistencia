package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	public Estudiante agregar(Estudiante estudiante) {
		Estudiante existente = buscarPorCedula(estudiante.getCedula());
		if (existente != null) {
			return null;
		} else {
			estudiantes.add(estudiante); // add: agrega el estudiante solo si no existía otro con esa cédula
			return estudiante;
		}
	}

	// Búsqueda lineal: recorre la lista uno por uno; devuelve el estudiante con esa
	// cédula o null si no existe
	public Estudiante buscarPorCedula(String cedula) {
		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getCedula().equals(cedula)) {
				return estudiante;
			}
		}
		return null; // null: señal de "no encontrado" (va FUERA del for, para recorrer todos antes
						// de rendirse)
	}

	// remove: saca el estudiante de la lista; devuelve true si existía y false si
	// no
	public boolean eliminar(String cedula) {
		Estudiante existente = buscarPorCedula(cedula);
		if (existente != null) {
			estudiantes.remove(existente);
			return true;
		} else {
			return false;
		}

	}

	// Actualiza nombre y apellido; la cédula es la clave y no cambia. Devuelve el
	// estudiante o null si no existe
	public Estudiante actualizar(String cedula, Estudiante nuevoEstudiante) {
		Estudiante existente = buscarPorCedula(cedula);
		if (existente != null) {
			existente.setNombre(nuevoEstudiante.getNombre());
			existente.setApellido(nuevoEstudiante.getApellido());

		}
		return existente;
	}

	// Getter de la lista: devuelve todos los estudiantes registrados
	public ArrayList<Estudiante> listar() {
		return estudiantes;
	}

}
