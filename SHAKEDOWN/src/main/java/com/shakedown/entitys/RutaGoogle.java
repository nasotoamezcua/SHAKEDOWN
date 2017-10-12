package com.shakedown.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "T_RUTA_GOOGLE", schema = "dbo", catalog = "SHAKEDOWN")
@NoArgsConstructor
@ToString
public class RutaGoogle {
	
	@Id
	@Column(name = "idFileEvento", unique = true, nullable = false)
	private @Getter @Setter Integer id;
	@Column(name = "file_js")
	private @Getter @Setter String file_js;
	@Column(name = "zoom")
	private @Getter @Setter Integer zoom;
	@Column(name = "lat")
	private @Getter @Setter Double lat;
	@Column(name = "lon")
	private @Getter @Setter Double lon;
	@Column(name = "status")
	private @Getter @Setter String status;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idFileEvento")
	private @Getter @Setter Set<Report_Bench_Drive> fileEventos = new HashSet<Report_Bench_Drive>();

}
