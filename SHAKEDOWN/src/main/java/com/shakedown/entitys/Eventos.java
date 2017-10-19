package com.shakedown.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name ="T_EVENTOS", schema = "dbo", catalog = "SHAKEDOWN")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Eventos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEvento", unique = true, nullable = false)
	private @Getter @Setter Integer id;
	@Column(name = "complete")
	private @Getter @Setter Integer complete;
	@Column(name = "fails")
	private @Getter @Setter Integer fails;
	@Column(name = "drops")
	private @Getter @Setter Integer drops;
	@Column(name = "status")
	private @Getter @Setter String status;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "idReporte")
	private @Getter Report_Bench_Drive idReporte;
	
	public Eventos(Integer complete,Integer fails,Integer drops){
		this.complete = complete;
		this.fails = fails;
		this.drops = drops;
	}

	public void setIdReporte(Report_Bench_Drive idReporte) {
		this.idReporte = idReporte;
		idReporte.setIdEventos(this);
	}
	
	
}
