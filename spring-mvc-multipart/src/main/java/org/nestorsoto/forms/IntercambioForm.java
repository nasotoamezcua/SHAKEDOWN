package org.nestorsoto.forms;

import java.util.List;

import org.nestorsoto.bean.Intercambio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntercambioForm {
	
	private List<Intercambio> intercambios;
}
