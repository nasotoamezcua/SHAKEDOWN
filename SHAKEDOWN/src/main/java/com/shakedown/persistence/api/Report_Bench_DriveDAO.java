package com.shakedown.persistence.api;

import java.util.List;

import com.shakedown.entitys.Report_Bench_Drive;

public interface Report_Bench_DriveDAO 
	extends GenericDAO<Report_Bench_Drive, Integer> {
	
	List<Report_Bench_Drive> lisReportBenchDriveFindAll(String tipo) throws PersistenceException;
	
	List<Report_Bench_Drive> ReportBenchDriveFindId(Integer idReport) throws PersistenceException;

}
