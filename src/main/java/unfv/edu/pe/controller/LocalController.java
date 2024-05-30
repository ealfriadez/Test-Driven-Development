package unfv.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unfv.edu.pe.model.Local;

@RestController
@RequestMapping("api/recurso")
public class LocalController {

	@PostMapping("/save")
	ResponseEntity<String> registerLocal(@RequestBody Local local){
		//Logica para guardar el objeto Local en tu servicio
		String message = "Recurso creado exitosamente.";
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	} 
	
	@GetMapping
	ResponseEntity<List<Local>> getAllLocals(){
		
		List<Local> localList = new ArrayList<>();
		
		for (long i = 0; i <= 4; i++) {
			Local local = new Local();
			local.setId(i);
			local.setName("Local " + i);
			local.setFloor("Floor " + i);
			localList.add(local);
		}
		
		/*
		 * Local local1 = new Local(); local1.setId(1L); local1.setName("Local Uno");
		 * local1.setFloor("Primer Piso"); localList.add(local1);
		 * 
		 * Local local2 = new Local(); local1.setId(2L); local1.setName("Local Dos");
		 * local1.setFloor("Segundo Piso"); localList.add(local2);
		 * 
		 * Local local3 = new Local(); local1.setId(3L); local1.setName("Local Tres");
		 * local1.setFloor("Tercer Piso"); localList.add(local3);
		 * 
		 * Local local4 = new Local(); local1.setId(4L); local1.setName("Local Cuatro");
		 * local1.setFloor("Cuarto Piso"); localList.add(local4);
		 * 
		 * Local local5 = new Local(); local1.setId(5L); local1.setName("Local Cinco");
		 * local1.setFloor("Quinto Piso"); localList.add(local5);
		 */
		
		return ResponseEntity.ok(localList);
	}
}
