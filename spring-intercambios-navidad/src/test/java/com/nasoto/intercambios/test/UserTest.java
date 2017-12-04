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

import com.nasoto.intercambios.dao.api.ICustomerDAO;
import com.nasoto.intercambios.dao.api.IIntercambiosDAO;
import com.nasoto.intercambios.dao.api.IRolesDAO;
import com.nasoto.intercambios.dao.api.IUsuarioDAO;
import com.nasoto.intercambios.dao.hibernate.api.IHibernateExtraOperationsDAO;
import com.nasoto.intercambios.entities.Customer;
import com.nasoto.intercambios.entities.Intercambios;
import com.nasoto.intercambios.entities.Roles;
import com.nasoto.intercambios.entities.Usuario;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/hibernate/data-applicationContext.xml"})
@Transactional
@Rollback(false)
public class UserTest {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private IRolesDAO rolesDAO;
	
	@Autowired
	private IIntercambiosDAO intercambiosDAO;
	
	@Before
	public void setUp() {
		Assert.assertNotNull(usuarioDAO);
		Assert.assertNotNull(customerDAO);
		Assert.assertNotNull(rolesDAO);
		Assert.assertNotNull(intercambiosDAO);
	}
	
	@Test
	public void finByIntercambiosIDCustomerTest() {
		log.info("finByIntercambiosIDCustomerTest -------------------");
		List<Intercambios> listIntercambios = intercambiosDAO.finByIntercambiosIDCustomer(1L);
		for(Intercambios i: listIntercambios) {
			log.info("intercambio: {}", i);
		}
	}
	
	@Test
	public void findByUserNameTest() {
		
		log.info("findByUserNameTest -------------------");
		Usuario usuario = usuarioDAO.findByUserName("tepos05");
		log.info("usuario : {} {}", usuario, System.identityHashCode(usuario));
		
	}
	
	@Test
	public void findByCustomerEmail() {
		log.info("findByCustomerEmail -------------------");
		Customer customer = customerDAO.findByCustomerEmail("nasotoamezcua@gmail.com");
		log.info("customer : {} {}", customer, System.identityHashCode(customer));
	}
	
	@SuppressWarnings("unchecked")
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
		
		usuarioDAO.insert(usuarioNew);
		
		log.info("usuarioNew : {} {}", usuarioNew, System.identityHashCode(usuarioNew));
		
		((IHibernateExtraOperationsDAO<Usuario, Long>)usuarioDAO).detach(usuarioNew);
		
		log.info("usuarioNew (detached) : {} {}", usuarioNew, System.identityHashCode(usuarioNew));
		
		Usuario usuario = usuarioDAO.findById(usuarioNew.getId());
		
		Assert.assertEquals(usuario, usuarioNew);
		
		log.info("usuario : {} {}", usuario, System.identityHashCode(usuario));
		
		Customer customer = customerDAO.findById(usuarioNew.getCusotmer().getId());
		
		Assert.assertEquals(customer, usuarioNew.getCusotmer());
		
		log.info("customer : {} {}", customer, System.identityHashCode(customer));
		
		Roles rolesRoot = Roles.builder().nom_rol("ROLE_ROOT").usario(usuarioNew).build();
		Roles rolesAdmin = Roles.builder().nom_rol("ROLE_ADMIN").usario(usuarioNew).build();
		Roles rolesUser = Roles.builder().nom_rol("ROLE_USER").usario(usuarioNew).build();
		
		rolesDAO.insert(rolesRoot);
		rolesDAO.insert(rolesAdmin);
		rolesDAO.insert(rolesUser);
		
		Intercambios intercambios1 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios2 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios3 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios4 = Intercambios.builder().customer(customerNew).build();
		Intercambios intercambios5 = Intercambios.builder().customer(customerNew).build();
		
		intercambiosDAO.insert(intercambios1);
		intercambiosDAO.insert(intercambios2);
		intercambiosDAO.insert(intercambios3);
		intercambiosDAO.insert(intercambios4);
		intercambiosDAO.insert(intercambios5);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void deleteUserTest() {
		
		Usuario usuarioDelete =  usuarioDAO.findById(1L);
		
		log.info("usuarioNew : {} {}", usuarioDelete, System.identityHashCode(usuarioDelete));
		
		((IHibernateExtraOperationsDAO<Usuario, Long>)usuarioDAO).detach(usuarioDelete);
		
		usuarioDAO.delete(usuarioDelete);
		
		log.info("usuarioDelete (deleted) : {} {}", usuarioDelete, System.identityHashCode(usuarioDelete));
		
		Usuario usuario = usuarioDAO.findById(usuarioDelete.getId());
		
		Assert.assertNull(usuario);
		
		log.info("usuario : {} {}", usuario, System.identityHashCode(usuario));
	}

}
