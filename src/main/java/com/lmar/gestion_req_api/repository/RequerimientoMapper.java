package com.lmar.gestion_req_api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lmar.gestion_req_api.model.Requerimiento;

@Mapper
public interface RequerimientoMapper {

	List<Requerimiento> getAll();
	
	Requerimiento getById(int id);
	
	int add(Requerimiento model);
	
	int update(Requerimiento model);
	
	int delete(int id);
}
