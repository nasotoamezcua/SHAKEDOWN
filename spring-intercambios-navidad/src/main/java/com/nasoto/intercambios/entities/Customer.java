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
import javax.persistence.JoinColumn;
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
@ToString(exclude = {"usario","intercambios"})
@EqualsAndHashCode(exclude = {"usario","intercambios"})
@Builder
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_customer")
	private Long id;
	private String nombre;
	private String mail;
	private String genero;
	private int active;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
	private @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) Set<Intercambios> intercambios = new HashSet<Intercambios>();

}
