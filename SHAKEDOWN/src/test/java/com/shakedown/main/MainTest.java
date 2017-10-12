package com.shakedown.main;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shakedown.entitys.Report_Bench_Drive;
import com.shakedown.entitys.Reporte;
import com.shakedown.persistence.api.PersistenceException;
import com.shakedown.persistence.api.Report_Bench_DriveDAO;
import com.shakedown.persistence.api.ReporteDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:data-applicationContext.xml")
public class MainTest {
	
	@Autowired
	private ReporteDAO reporteDAO;
	@Autowired
	private Report_Bench_DriveDAO reporteBenchDrive;
	
	
	@Test
	public void listaReporteBenchDrive() throws PersistenceException{
		
		for(int i=0; i<2; i++) {
			if(i == 0) {
				List<Report_Bench_Drive> list = reporteBenchDrive.lisReportBenchDriveFindAll("BM");
				for(Report_Bench_Drive bd : list) {
					System.out.println(bd);
				}
			}else {
				List<Report_Bench_Drive> list = reporteBenchDrive.lisReportBenchDriveFindAll("DT");
				for(Report_Bench_Drive bd : list) {
					System.out.println(bd);
				}
			}
		}
		
	}
	
	@Test
	public void listaRepotes() throws PersistenceException {
		List<Reporte> listReports = reporteDAO.listReportsIdZona(1);
		for(Reporte r: listReports) {
			System.out.println(r);
		}
	}
	
	@Test
	public void findRepor() throws PersistenceException {
		Reporte report = reporteDAO.findReportId(1);
		System.out.println(report);
		
	}

}
