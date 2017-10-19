package com.shakedown.main;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shakedown.entitys.Eventos;
import com.shakedown.entitys.Report_Bench_Drive;
import com.shakedown.entitys.RutaGoogle;
import com.shakedown.persistence.api.EventoDAO;
import com.shakedown.persistence.api.PersistenceException;
import com.shakedown.persistence.api.Report_Bench_DriveDAO;
import com.shakedown.persistence.api.RutaGoogleDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:data-applicationContext.xml")
public class MainTest {
	
	@Autowired
	private Report_Bench_DriveDAO reporteBenchDrive;
	@Autowired
	private EventoDAO eventoDao;
	@Autowired
	private RutaGoogleDAO rutaGoogleDAO;
	 
	
	
	@Test
	public void listaReporteBenchDrive() throws PersistenceException{
		
		RutaGoogle rutaGoogle= rutaGoogleDAO.findByPK(1);
		
		
		
		Report_Bench_Drive reporte = 	Report_Bench_Drive.builder()
											.nombre("PruebaInserta 2")
											.semana("42")
											.fecha(new Date())
											.status("A")
											.tipo("DT")
											.idFileEvento(rutaGoogle).build();
		Eventos eventos = Eventos.builder()
							.complete(1)
							.fails(2)
							.drops(3)
							.status("A").build();
		
		eventos.setIdReporte(reporte);
		
		eventoDao.save(eventos);
		
		
		
		for(int i=0; i<2; i++) {
			
			
			if(i == 0) {
				List<Report_Bench_Drive> list = reporteBenchDrive.lisReportBenchDriveFindAll("BM");
				for(Report_Bench_Drive bd : list) {
					System.out.println("BM -->" + bd);
				}
			}else {
				List<Report_Bench_Drive> list = reporteBenchDrive.lisReportBenchDriveFindAll("DT");
				for(Report_Bench_Drive bd : list) {
					System.out.println("DT -->" + bd);
				}
			}
		}
		
	}
}
