package com.assignment.recipes.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.assignment.recipes.model.Recipes;
import com.assignment.recipes.service.RecipesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = RecipesController.class)
public class RecipesControllerTest {
	
	@InjectMocks
	private RecipesController recipesController;

	@Mock
	private RecipesService recipesService;
	
	private MockMvc mvc;

	private MockHttpServletRequestBuilder getAllRequest;
	
	@Before
	public void init() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(recipesController).build();
		getAllRequest = MockMvcRequestBuilders.get("/api/assignment/recipes/getAll")
											.contentType(MediaType.APPLICATION_JSON);
	}
	
	@WithMockUser (value="admin")
	@Test
	public void givenAuthRequestOnGetAllRecipes_shouldSucceedWith200() throws Exception{
		List<Recipes> recipesList = new ArrayList<>();
		Recipes recipe = new Recipes();
		recipe.setIndicator("V");
		recipe.setRecipeName("Veg Pizza - Pan");
		recipe.setCount(1);
		recipe.setIngrediants("crust, cheese, potato");
		recipe.setInstructions("1. Prepare crust; 2. Add toppings; 3. Add cheese; 4. Bake ; 5. Serve");
		recipesList.add(recipe);
		String inputJson = RecipesControllerTest.mapToJson(recipe);
		inputJson = "["+inputJson+"]";
		Mockito.when(recipesService.getAllRecipes()).thenReturn(recipesList);
		mvc.perform(getAllRequest).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private static String mapToJson(final Object object)  {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
