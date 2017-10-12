package com.shakedown.service.assembler;

import org.springframework.stereotype.Component;

import com.shakedown.dto.ReportBenchDriveDTO;
import com.shakedown.entitys.Eventos;
import com.shakedown.entitys.Report_Bench_Drive;

@Component("reportBenchDriveAssembler")
public class ReportBenchDriveAssembler 
		extends Assembler<ReportBenchDriveDTO, Report_Bench_Drive> {

	@Override
	public ReportBenchDriveDTO getDTOTransform(Report_Bench_Drive mapping) {
		
		
		ReportBenchDriveDTO dto = new ReportBenchDriveDTO();
		dto.setId(mapping.getId());
		dto.setNombre(mapping.getNombre());
		dto.setComplete(mapping.getIdEventos().getComplete());
		dto.setFails(mapping.getIdEventos().getFails());
		dto.setDrops(mapping.getIdEventos().getDrops());
		dto.setSemana(mapping.getSemana());
		dto.setFecha(mapping.getFecha());
		
		return dto;
	}

	@Override
	public Report_Bench_Drive getMappingTransform(ReportBenchDriveDTO dto) {
		
		Report_Bench_Drive mapping = new Report_Bench_Drive();
		mapping.setId(dto.getId());
		mapping.setNombre(dto.getNombre());
		mapping.setIdEventos(new Eventos(dto.getComplete(), dto.getFails(), dto.getDrops()));
		mapping.setSemana(dto.getSemana());
		mapping.setFecha(dto.getFecha());
		
		return mapping;
	}

}
