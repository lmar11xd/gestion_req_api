package com.lmar.gestion_req_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmar.gestion_req_api.model.Requerimiento;
import com.lmar.gestion_req_api.service.FileStorageService;
import com.lmar.gestion_req_api.service.RequerimientoService;
import com.lmar.gestion_req_api.util.Response;

@RestController
@RequestMapping("/api/v1")
public class RequerimientoController {

	@Autowired
	public RequerimientoService reqService;
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@GetMapping("/requerimiento")
	public Response getAll(){
		return reqService.getAll();
	}
		
	@GetMapping("/requerimiento/{id}")
	public Response getById(@PathVariable int id){
		return reqService.getById(id);
	}
	
	@PostMapping("/requerimiento")
	public Response add(
			@RequestParam("file") MultipartFile file, 
			@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("estado") String estado){
		
		String rutaArchivo = fileStorageService.storeFile(file);
		
		Requerimiento entity = new Requerimiento();
		entity.setId(0);
		entity.setNombre(nombre);
		entity.setDescripcion(descripcion);
		entity.setEstado(estado);
		entity.setRutaAnexo(rutaArchivo);
		
		return reqService.add(entity);
	}
	
	@PostMapping("/requerimiento2")
	public Response add2(
			@RequestParam("file") MultipartFile file, 
			@RequestParam("req") String data){
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String rutaArchivo = fileStorageService.storeFile(file);
			
			Requerimiento entity = mapper.readValue(data, Requerimiento.class);
			entity.setRutaAnexo(rutaArchivo);
			return reqService.add(entity);
		} catch (JsonProcessingException e) {
			return new Response(300, e.getMessage(), null);
		}
	}
	
	@PutMapping("/requerimiento/{id}")
	public Response update(@PathVariable int id, @RequestBody Requerimiento model){
		return reqService.update(id, model);
	}
	
	@DeleteMapping("/requerimiento/{id}")
	public Response delete(@PathVariable int id){
		return reqService.delete(id);
	}
}
