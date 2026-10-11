package com.krakedev.asistencias.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.servicios.ServicioEstudiantes;

//Inyección de dependencias por constructor: Spring entrega el servicio ya creado (no se usa new
@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiantes {

	private final ServicioEstudiantes servicioEstudiantes; // protege

	public ControladorEstudiantes(ServicioEstudiantes servicioEstudiantes) { // Conecta
		this.servicioEstudiantes = servicioEstudiantes;
	}

	// @PostMapping: atiende POST /estudiantes (crear). @RequestBody convierte el
	// JSON en un objeto Estudiante
	@PostMapping
	public Estudiante agregar(@RequestBody Estudiante estudiante) {
		return servicioEstudiantes.agregar(estudiante);
	}

	@GetMapping("/{cedula}")
	public Estudiante buscar(@PathVariable String cedula) {
		return servicioEstudiantes.buscarPorCedula(cedula);
	}

	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return servicioEstudiantes.eliminar(cedula);
	}

	@PutMapping("/{cedula}")
	public Estudiante actualizar(@PathVariable String cedula, @RequestBody Estudiante estudianteActualizado) {
		return servicioEstudiantes.actualizar(cedula, estudianteActualizado);

	}

	@GetMapping
	public List<Estudiante> listar() {
		return servicioEstudiantes.listar();
	}

}
