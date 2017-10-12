package com.shakedown.service.api;

import java.util.List;

import com.shakedown.dto.ReportBenchDriveDTO;
import com.shakedown.entitys.Report_Bench_Drive;

public interface ReportBenchDriveService 
	extends GenericService<Report_Bench_Drive, ReportBenchDriveDTO, Integer> {
	
	public List<ReportBenchDriveDTO> lisReportBenchDriveFindAllService(String tipo) throws ServiceException;

}
