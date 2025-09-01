package com.example.SpringSecurity;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc


public class SpringSecurityApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	// ✅ Public page access without login
	@Test
	public void testPublicPageAccess() throws Exception {
		mockMvc.perform(get("/about"))
				.andExpect(status().isOk());
	}

	// ❌ Denied access for unauthenticated user
	@Test
	public void testProtectedPageWithoutLogin() throws Exception {
		mockMvc.perform(get("/books"))
				.andExpect(status().is3xxRedirection()); // Redirect to login
	}

	// ✅ Student access
	@Test
	@WithMockUser(username = "student", roles = {"STUDENT"})
	public void testStudentAccessBooks() throws Exception {
		mockMvc.perform(get("/books"))
				.andExpect(status().isOk());
	}

	// ❌ Student denied admin access
	@Test
	@WithMockUser(username = "student", roles = {"STUDENT"})
	public void testStudentDeniedAdminPage() throws Exception {
		mockMvc.perform(get("/admin/reports"))
				.andExpect(status().isForbidden());
	}

	// ✅ Admin access
	@Test
	@WithMockUser(username = "admin", roles = {"ADMIN"})
	public void testAdminAccess() throws Exception {
		mockMvc.perform(get("/admin/reports"))
				.andExpect(status().isOk());
	}
}


