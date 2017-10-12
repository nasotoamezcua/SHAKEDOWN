package com.shakedown.service.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakedown.dto.ReportBenchDriveDTO;
import com.shakedown.entitys.Report_Bench_Drive;
import com.shakedown.persistence.api.GenericDAO;
import com.shakedown.persistence.api.PersistenceException;
import com.shakedown.persistence.api.Report_Bench_DriveDAO;
import com.shakedown.service.api.ReportBenchDriveService;
import com.shakedown.service.api.ServiceException;
import com.shakedown.service.assembler.Assembler;
import com.shakedown.service.assembler.ReportBenchDriveAssembler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("reportBenchDriveService")
public class ReportBenchDriveServiceImpl extends GenericServiceImpl<Report_Bench_Drive, ReportBenchDriveDTO, Integer> 
		implements ReportBenchDriveService {
	
	@Autowired
	private Report_Bench_DriveDAO dao;
	
	@Autowired
	private ReportBenchDriveAssembler assembler;

	@Override
	protected GenericDAO<Report_Bench_Drive, Integer> getDAO() {
		return dao;
	}

	@Override
	protected Assembler<ReportBenchDriveDTO, Report_Bench_Drive> getAssembler() {
		return assembler;
	}

	@Override
	public List<ReportBenchDriveDTO> lisReportBenchDriveFindAllService(String tipo) throws ServiceException {
		
		List<ReportBenchDriveDTO> listReportBenchDriveDTO = null;
		
		try {
			List<Report_Bench_Drive> entity_= dao.lisReportBenchDriveFindAll(tipo);
			listReportBenchDriveDTO = assembler.getDTOListTransform(entity_);
		}catch (PersistenceException e) {
			log.error(e.getMessage(), e);
		}
		
		return listReportBenchDriveDTO;
	}

}
