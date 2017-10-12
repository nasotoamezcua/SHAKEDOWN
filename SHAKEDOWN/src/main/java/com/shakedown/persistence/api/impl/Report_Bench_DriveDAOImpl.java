package com.shakedown.persistence.api.impl;

import java.util.List;

//import org.hibernate.Criteria;
import org.hibernate.Query;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shakedown.entitys.Report_Bench_Drive;
import com.shakedown.persistence.api.PersistenceException;
import com.shakedown.persistence.api.Report_Bench_DriveDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("report_Bench_DriveDAO")
public class Report_Bench_DriveDAOImpl extends GenericDAOImpl<Report_Bench_Drive, Integer>
		implements Report_Bench_DriveDAO {
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Report_Bench_Drive> lisReportBenchDriveFindAll(String tipo) throws PersistenceException {
		// TODO Auto-generated method stub
		
		List<Report_Bench_Drive> listReporBenchDrive = null;
		
		try {
			//Utilizando dos tablas con criteria y con campos no llave (idEventos.status)
			//Cuando son campos llave no se senecita crear la sentencia "c.createCriteria"
			
			/*
			Criteria c = getSessionFactory().getCurrentSession().createCriteria(Report_Bench_Drive.class);
					c.add(Restrictions.eq("tipo", tipo)).add(Restrictions.eq("status","A")).addOrder(Order.desc("semana"));
					c = c.createCriteria("idEventos");
					c.add(Restrictions.eq("status","A"));
					listReporBenchDrive = 	c.list();
			*/
			
			//Utilizando HQL
			String hql = 	"	select distinct bd from Report_Bench_Drive bd " +
							"		join fetch bd.idEventos e " +
							"	where bd.tipo = :tipo " +
							"	and bd.status = 'A' " +
							"	and e.status = 'A' " +
							"	order by bd.semana desc ";
			
			Query q = getSessionFactory().getCurrentSession().createQuery(hql);
			q.setParameter("tipo", tipo);
			
			listReporBenchDrive = q.list();

		}catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return listReporBenchDrive;
	}

	@Override
	public List<Report_Bench_Drive> ReportBenchDriveFindId(Integer idReport) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
