package com.nasoto.intercambios.forms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasoto.intercambios.entities.Block;
import com.nasoto.intercambios.service.api.IBlockService;

@Component("adminFormUtils")
public class AdminFormUtils {
	
	@Autowired
	private IBlockService blockService;
	
	public List<Block> findAllBlocks(){
		
		List<Block> listBlocks = blockService.findAll();
		
		return listBlocks;
	}
	
	public Block findIdBlocks(Long idBlock) {
		
		Block block = blockService.findById(idBlock);
		return block;
	}
	
	public void blockActiveAdmin(Long idBlock) {
		
		Block block = this.findIdBlocks(idBlock);
		block.setActive(1);
		
		blockService.update(block);
	}
	
	public void blockInactiveAdmin(Long idBlock) {
		
		Block block = this.findIdBlocks(idBlock);
		block.setActive(0);
		
		blockService.update(block);
	}
}
