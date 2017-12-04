package com.nasoto.intercambios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"customer"})
@EqualsAndHashCode(exclude = {"customer"})
@Entity
@Table(name = "INTERCAMBIOS")
public class Intercambios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_intercambio")
	private Long id;
	
	private String opcion;
	private String img;
	private String path;
	private int active;
	private int anio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer")
	private @Getter(AccessLevel.NONE) Customer customer;
	

}
