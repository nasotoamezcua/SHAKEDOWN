package com.nasoto.intercambios.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nasoto.intercambios.entities.Customer;
import com.nasoto.intercambios.entities.Intercambios;
import com.nasoto.intercambios.entities.Roles;
import com.nasoto.intercambios.entities.Usuario;
import com.nasoto.intercambios.service.api.ICustomerService;
import com.nasoto.intercambios.service.api.IIntercambiosService;
import com.nasoto.intercambios.service.api.IRolesService;
import com.nasoto.intercambios.service.api.IUsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback(false)
public class UserTestService {
	
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IRolesService rolesService;
	@Autowired
	private IIntercambiosService intercambiosService;
	
	@Before
	public void setUp() {
		Assert.assertNotNull(usuarioService);
		Assert.assertNotNull(customerService);
		Assert.assertNotNull(rolesService);
		Assert.assertNotNull(intercambiosService);
	}
	
	@Test
	public void createUserTest() {
		log.info("createUserTest -------------------");
		
		Usuario usuarioNew = Usuario.builder()
				.nom_usua("tepos05").pwd_usua("nasa050684")
				.active(1).build();
		
		Customer customerNew = Customer.builder()
				.nombre("Nestor Alejandro").mail("nasotoamezcua@gmail.com")
				.genero("Masculino").active(1).usario(usuarioNew).build();
		
		usuarioNew.setCusotmer(customerNew);
		
		usuarioService.insert(usuarioNew);
		
		log.info("usuarioNew : {} {}", usuarioNew, System.identityHashCode(usuarioNew));
		
		usuarioService.detach(usuarioNew);
		
		log.info("usuarioNew (detached) : {} {}", usuarioNew, System.identityHashCode(usuarioNew));
		
		Usuario usuario = usuarioService.findById(usuarioNew.getId());
		
		Assert.assertEquals(usuario, usuarioNew);
		
		log.info("usuario : {} {}", usuario, System.identityHashCode(usuario));
		
		Customer customer = customerService.findById(usuarioNew.getCusotmer().getId());
		
		Assert.assertEquals(customer, usuarioNew.getCusotmer());
		
		log.info("customer : {} {}", customer, System.identityHashCode(customer));
		
		Roles rolesRoot = Roles.builder().nom_rol("ROLE_ROOT").usario(usuarioNew).build();
		Roles rolesAdmin = Roles.builder().nom_rol("ROLE_ADMIN").usario(usuarioNew).build();
		Roles rolesUser = Roles.builder().nom_rol("ROLE_USER").usario(usuarioNew).build();
		
		rolesService.insert(rolesRoot);
		rolesService.insert(rolesAdmin);
		rolesService.insert(rolesUser);
		
		Intercambios intercambios1 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios2 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios3 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios4 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios5 = Intercambios.builder().customer(customerNew).build();
		
		intercambiosService.insert(intercambios1);
		intercambiosService.insert(intercambios2);
		intercambiosService.insert(intercambios3);
		intercambiosService.insert(intercambios4);
		intercambiosService.insert(intercambios5);
	}

}
