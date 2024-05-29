package unfv.edu.pe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import unfv.edu.pe.model.Local;

@WebMvcTest
@AutoConfigureMockMvc
public class LocalControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void registrarLocal() throws Exception {
		
		Local local = Local.builder()
				.id(1L)
				.name("PetShop")
				.floor("Third floor")
				.build();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/recurso/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(local)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().string("Recurso creado exitosamente."));
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
