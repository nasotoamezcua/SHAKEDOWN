package com.nasoto.intercambios.forms;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasoto.intercambios.entities.Intercambios;
import com.nasoto.intercambios.entities.Usuario;
import com.nasoto.intercambios.service.api.IIntercambiosService;
import com.nasoto.intercambios.service.api.IUsuarioService;

@Component
public class IntercambioFormUtils {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IIntercambiosService intercambiosService;
	
	public void registraIntercambio(IntercambioForm interForm,String usuCap, String fileName,String path) {
		
		Usuario u = usuarioService.findByUserNameService(usuCap);
		
		Intercambios intercambio = Intercambios.builder()
				.opcion(interForm.getOpcion()).img(fileName).path(path)
				.anio(Calendar.getInstance().get(Calendar.YEAR))
				.active(1).customer(u.getCusotmer()).build();
		
		intercambiosService.insert(intercambio);
	}
	
	public List<Intercambios> listIntercambios(Long idCustomer){
		return intercambiosService.finByIntercambiosIDCustomerService(idCustomer);
	}
	
	public Intercambios deleteIntercambio(Long id) {
		Intercambios intercambioDelete = intercambiosService.delete(id);
		
		if(!intercambioDelete.getImg().equals("no-define")) {
			String path = intercambioDelete.getPath() + "/" + intercambioDelete.getImg();
			File ficheDelete = new File(path);
			ficheDelete.delete();
		}
		
		return intercambioDelete;
	}

}
