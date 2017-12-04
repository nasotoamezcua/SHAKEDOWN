package com.nasoto.intercambios.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"roles"})
@EqualsAndHashCode(exclude = {"roles"})
@Entity
@Table(name = "USUARIOS")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long id;
	private String nom_usua;
	private String pwd_usua;
	private int active; 
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usario")
	private Customer cusotmer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usario")
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
	private @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) Set<Roles> roles = new HashSet<Roles>();

}
