package com.shakedown.main;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shakedown.entitys.Reporte;
import com.shakedown.persistence.api.PersistenceException;
import com.shakedown.persistence.api.ReporteDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:data-applicationContext.xml")
public class MainTest {
	
	@Autowired
	private ReporteDAO reporteDAO;
	
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
