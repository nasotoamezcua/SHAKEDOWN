package com.shakedown.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="T_EVENTOS", schema = "dbo", catalog = "SHAKEDOWN")
@NoArgsConstructor
@ToString
public class Eventos {
	
	@Id
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
	@OneToOne
	@JoinColumn(name = "idReporte")
	private @Getter @Setter Report_Bench_Drive idReporte;
	
	public Eventos(Integer complete,Integer fails,Integer drops){
		this.complete = complete;
		this.fails = fails;
		this.drops = drops;
				
	}

}
