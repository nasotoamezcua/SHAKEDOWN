package com.nasoto.intercambios.service.hibernate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.dao.api.IBlock;
import com.nasoto.intercambios.entities.Block;
import com.nasoto.intercambios.service.api.IBlockService;
import com.nasoto.intercambios.service.hibernate.GenericHibernateService;

@Service("blockHibernateService")
public class BlockHibernateService extends GenericHibernateService<Block, Long>
	implements IBlockService{
	
	@Autowired
	private IBlock dao;

	@Override
	protected IGenericDAO<Block, Long> getDAO() {
		// TODO Auto-generated method stub
		return dao;
	}

}
