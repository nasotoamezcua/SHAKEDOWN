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
@ToString(exclude = {"usario"})
@EqualsAndHashCode(exclude = {"usario"})
@Entity
@Table(name = "ROLES")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_role")
	private Long id;
	
	private String nom_rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private @Getter(AccessLevel.NONE) Usuario usario;

}
