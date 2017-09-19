package com.shakedown.service.assembler;

import org.springframework.stereotype.Component;

import com.shakedown.dto.ReporteDTO;
import com.shakedown.dto.ZonasDTO;
import com.shakedown.entitys.Reporte;
import com.shakedown.entitys.Zonas;

@Component("reporteAssembler")
public class ReporteAssembler extends Assembler<ReporteDTO, Reporte> {
	
	@Override
	public ReporteDTO getDTOTransform(Reporte mapping) {
		
		ReporteDTO reporteDto = new ReporteDTO();
		reporteDto.setId(mapping.getId());
		reporteDto.setNombre(mapping.getNombre());
		reporteDto.setFile_evento_js(mapping.getFile_evento_js());
		reporteDto.setFecha(mapping.getFehca());
		reporteDto.setStatus(mapping.getStatus());
		reporteDto.setZona(new ZonasDTO());
		
		return reporteDto;
	}

	@Override
	public Reporte getMappingTransform(ReporteDTO dto) {

		Reporte reporte = new Reporte();
		reporte.setId(dto.getId());
		reporte.setNombre(dto.getNombre());
		reporte.setFile_evento_js(dto.getFile_evento_js());
		reporte.setFehca(dto.getFecha());
		reporte.setStatus(dto.getStatus());
		reporte.setZona(new Zonas());
		
		return reporte;
	}

}
