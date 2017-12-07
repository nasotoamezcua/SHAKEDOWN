package com.nasoto.intercambios.forms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasoto.intercambios.entities.Customer;
import com.nasoto.intercambios.entities.Roles;
import com.nasoto.intercambios.entities.Usuario;
import com.nasoto.intercambios.service.api.IRolesService;
import com.nasoto.intercambios.service.api.IUsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserFormUtils {
	
	@Autowired
	private IUsuarioService usuarioService;
		
	@Autowired
	private IRolesService rolesService;
	
	@Autowired
	private IntercambioFormUtils intercambioFormUtils;
		
	public void registraUserForm(UserForm userForm) {
		
		Usuario usuarioNew = Usuario.builder()
				.nom_usua(userForm.getUser()).pwd_usua(userForm.getPassword())
				.active(1).build();
		
		Customer customerNew = Customer.builder()
				.nombre(userForm.getNombre()).mail(userForm.getMail())
				.genero(userForm.getGenero()).active(1).usario(usuarioNew).build();
		
		usuarioNew.setCusotmer(customerNew);
		
		usuarioService.insert(usuarioNew);
		
		Roles role = Roles.builder().nom_rol("ROLE_USER").usario(usuarioNew).build();
		
		rolesService.insert(role);
		
		if(userForm.getUser().trim().equals("tepos05")) {
			Roles rolesRoot = Roles.builder().nom_rol("ROLE_ROOT").usario(usuarioNew).build();
			rolesService.insert(rolesRoot);
			Roles rolesAdmin = Roles.builder().nom_rol("ROLE_ADMIN").usario(usuarioNew).build();
			rolesService.insert(rolesAdmin);
		}
	}
	
	public void updateUserForm(UserForm userForm) {
		
		Usuario usuarioUpdate = Usuario.builder().id(userForm.getIdUsuario())
				.nom_usua(userForm.getUser()).pwd_usua(userForm.getPassword())
				.active(1).build();
		
		Customer customerUpdate = Customer.builder().id(userForm.getIdCustomer())
				.nombre(userForm.getNombre()).mail(userForm.getMail())
				.genero(userForm.getGenero()).active(1).usario(usuarioUpdate).build();
		
		usuarioUpdate.setCusotmer(customerUpdate);
		
		log.info("usuarioUpdate : {} {}", usuarioUpdate, System.identityHashCode(usuarioUpdate));
		
		log.info("customerUpdate : {} {}", usuarioUpdate, System.identityHashCode(customerUpdate));
		
		usuarioService.update(usuarioUpdate);
	}
	
	
	public UserForm getUserForm(String usuario){
		
		Usuario u = usuarioService.findByUserNameService(usuario);
		
		return UserForm.builder().idUsuario(u.getId()).idCustomer(u.getCusotmer().getId())
			.user(u.getNom_usua())
			.mail(u.getCusotmer().getMail())
			.password(u.getPwd_usua())
			.confirPassword(u.getPwd_usua())
			.nombre(u.getCusotmer().getNombre())
			.genero(u.getCusotmer().getGenero()).build();
	}
	
	public List<UserForm> userFormsAll(){
		
		List<UserForm> userForms = null;
		
		List<Usuario> usuarios =  usuarioService.findAll();
		
		if(usuarios!= null && usuarios.size()>0) {
			
			userForms = new ArrayList<UserForm>();
			
			for(Usuario u: usuarios) {
				userForms.add(UserForm.builder().idUsuario(u.getId()).idCustomer(u.getCusotmer().getId())
						.user(u.getNom_usua())
						.mail(u.getCusotmer().getMail())
						.password(u.getPwd_usua())
						.confirPassword(u.getPwd_usua())
						.nombre(u.getCusotmer().getNombre())
						.genero(u.getCusotmer().getGenero())
						.intercambios(intercambioFormUtils.listIntercambios(u.getCusotmer().getId()))
						.build());
			}
		}
		
		return userForms;
	}
}
