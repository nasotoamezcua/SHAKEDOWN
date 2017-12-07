package com.nasoto.intercambios.service.assembler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasoto.intercambios.dto.IntercambiosDTO;
import com.nasoto.intercambios.dto.UsuarioDTO;
import com.nasoto.intercambios.entities.Customer;
import com.nasoto.intercambios.entities.Usuario;
import com.nasoto.intercambios.service.api.IIntercambiosService;

@Component("usuarioAssembler")
public class UsuarioAssembler extends Assembler<UsuarioDTO, Usuario> {
	
	@Autowired
	private IIntercambiosService service;
	
	@Autowired
	private IntercambiosAssembler intercambiosAssembler;

	@Override
	public UsuarioDTO getDTOTransform(Usuario mapping) {
		UsuarioDTO usuarioDTO =  UsuarioDTO.builder().idUsuario(mapping.getId())
				.user(mapping.getNom_usua()).password(mapping.getPwd_usua())
				.idCustomer(mapping.getCusotmer().getId()).nombre(mapping.getCusotmer().getNombre())
				.mail(mapping.getCusotmer().getMail()).genero(mapping.getCusotmer().getGenero())
				.build();
		
		List<IntercambiosDTO> intercambiosDTO = intercambiosAssembler.getDTOListTransform( 
				service.finByIntercambiosIDCustomerService(usuarioDTO.getIdCustomer()));
		
		usuarioDTO.setIntercambiosDTO(intercambiosDTO);
		
		
		return usuarioDTO;
	}

	@Override
	public Usuario getMappingTransform(UsuarioDTO dto) {
		
		Usuario usuario = Usuario.builder()
				.nom_usua(dto.getNombre()).pwd_usua(dto.getPassword())
				.build();
		
		Customer customer = Customer.builder()
				.nombre(dto.getNombre())
				.mail(dto.getMail()).genero(dto.getGenero()).usario(usuario)
				.build();
		
		usuario.setCusotmer(customer);
		
		return usuario;
	}

}
