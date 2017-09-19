package com.shakedown.persistence.api.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shakedown.entitys.Reporte;
import com.shakedown.persistence.api.PersistenceException;
import com.shakedown.persistence.api.ReporteDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("reporteDAO")
public class ReporteDAOImpl extends GenericDAOImpl<Reporte, Integer> implements ReporteDAO {

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Reporte> listReportsIdZona(Integer idZona) throws PersistenceException {
		
		List<Reporte> listReport = null;
		
		try {
			listReport	 = getSessionFactory().getCurrentSession().createCriteria(Reporte.class)
					.add(Restrictions.eq("zona.id", idZona)).list();
			
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return listReport;
	}

	@Override
	public Reporte findReportId(Integer idReporr) throws PersistenceException {
		
		Reporte reporte = null;
		
		try {
			reporte= (Reporte)getSessionFactory().getCurrentSession().get(Reporte.class, idReporr);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		 
		return reporte;
	}

}
