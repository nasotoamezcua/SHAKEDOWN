package com.nasoto.intercambios.service.assembler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasoto.intercambios.dto.IntercambiosDTO;
import com.nasoto.intercambios.entities.Intercambios;
import com.nasoto.intercambios.service.api.ICustomerService;



@Component("intercambioAssembler")
public class IntercambiosAssembler extends Assembler<IntercambiosDTO, Intercambios> {
	
	@Autowired
	private ICustomerService customerService;
	
	@Override
	public IntercambiosDTO getDTOTransform(Intercambios mapping) {
			
		
		IntercambiosDTO intercambiosDTO = IntercambiosDTO.builder()
				.idIntercambio(mapping.getId())
				.build();
		return intercambiosDTO;
	}

	@Override
	public Intercambios getMappingTransform(IntercambiosDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
