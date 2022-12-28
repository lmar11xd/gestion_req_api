package com.lmar.gestion_req_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmar.gestion_req_api.model.Requerimiento;
import com.lmar.gestion_req_api.repository.RequerimientoMapper;
import com.lmar.gestion_req_api.util.Response;

@Service
public class RequerimientoService {
	
	private Response response;
	@Autowired
	private RequerimientoMapper reqMapper;
	
	public RequerimientoService() {
		response = new Response();
	}
	
	public Response getAll() {
		response.setStatus(200);
		response.setMessage("OK");
		response.setData(reqMapper.getAll());
		return response;
	}

	public Response getById(int id) {
		response.setStatus(200);
		response.setMessage("OK");
		response.setData(reqMapper.getById(id));
		return response;
	}
	
	public Response add(Requerimiento model) {
		response = new Response();
		response.setStatus(200);
		reqMapper.add(model);
		Requerimiento newReq = reqMapper.getById(model.getId());
		if(newReq == null) {
			response.setStatus(404);
			response.setMessage("Requerimiento no registrado");
		} else {
			response.setMessage("Requerimiento registrado");
			response.setData(newReq);
		}
		return response;
	}
	
	public Response update(int id, Requerimiento model) {
		response = new Response();
		response.setStatus(200);
		int result = reqMapper.update(new Requerimiento(
				id, 
				model.getNombre(), 
				model.getDescripcion(), 
				model.getRutaAnexo(), 
				model.getEstado())
				);
		
		if(result == 0) {
			response.setStatus(404);
			response.setMessage("Requerimiento no encontrado");
		} else {
			response.setMessage("Requerimiento actualizado");
			response.setData(reqMapper.getById(id));
		}
		return response;
	}
	
	public Response delete(int id) {
		response = new Response();
		response.setStatus(200);
		response.setData(null);
		int result = reqMapper.delete(id);
		if (result == 0) {
			response.setStatus(404);
			response.setMessage("Requerimiento no encontrado");
		} else {
			response.setMessage("Requerimiento eliminado");
		}
		return response;
	}
}
