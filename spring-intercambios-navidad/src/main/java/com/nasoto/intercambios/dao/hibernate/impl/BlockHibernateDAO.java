package com.nasoto.intercambios.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.api.IBlock;
import com.nasoto.intercambios.dao.hibernate.GenericHibernateDAO;
import com.nasoto.intercambios.entities.Block;

@Repository("blockHibernateDAO")
public class BlockHibernateDAO extends GenericHibernateDAO<Block, Long>
	implements IBlock{

	public BlockHibernateDAO() {
		super(Block.class);
	}

}
