package com.nasoto.intercambios.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nasoto.intercambios.dao.api.IBlock;
import com.nasoto.intercambios.entities.Block;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback(false)
public class BlockTest {
	
	@Autowired
	private IBlock blockService;
	
	@Before
	public void setUp() {
		Assert.assertNotNull(blockService);
	}
	
	@Test
	public void findAllBlock() {
		log.info("findAllBlock -------------------");
		List<Block> listBlock = blockService.findAll();
		for(Block b : listBlock) 
			log.info("Block: {}", b);
	}
	
	
	
	

}
