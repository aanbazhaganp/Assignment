package com.assignment.recipes.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.recipes.model.Recipes;
import com.assignment.recipes.service.RecipesService;

@RestController
@RequestMapping("/api/assignment/recipes")
public class RecipesController {
	
	@Autowired
	private RecipesService recipesService;
	/**
	 * POST MAPPING used to create a recipe in JSON format (using POSTMAN)
	 * @param recipes to be created in JSON format
	 * @return created recipe in JSON format
	 */
	@PostMapping("/add")
	public Recipes createRecipes(@RequestBody Recipes recipes) {
		return recipesService.createRecipes(recipes);
	}
	/**
	 * GET MAPPING used to get all recipes in JSON format (using POSTMAN)
	 * @return list of available recipes
	 */
	@GetMapping("/getAll")
	public List<Recipes> getAllRecipes(){
		return recipesService.getAllRecipes();
	}
	/**
	 * GET MAPPING used to get recipes based on id in JSON format (using POSTMAN)
	 * @param recipesId to be retrieved
	 * @return recipes in JSON format if available else null
	 */
	@GetMapping("/getById/{id}")
	public Recipes getRecipesById(@PathVariable(value="id") Long recipesId){
		return recipesService.getRecipesById(recipesId);
	}
	/**
	 * GET MAPPING used to get list of recipes based on number of people count in JSON format (using POSTMAN)
	 * @param peopleCount number of people the recipie is suitable for
	 * @return list of matching recipes in JSON format if available else null
	 */
	@GetMapping("/getByNumberOfPeople/{count}")
	public List<Recipes> getRecipesByNumberOfPeople(@PathVariable(value="count") Integer peopleCount){
		return recipesService.getRecipesByNumberOfPeople(peopleCount); 
	}
	/**
	 * GET MAPPING used to get list of recipes based on indicator in JSON format (using POSTMAN)
	 * @param indicator whether veg or nonveg
	 * @return list of matching recipes in JSON format if available else null
	 */
	@GetMapping("/getByIndicator/{indicator}")
	public List<Recipes> getRecipesByIndicator(@PathVariable(value="indicator") String indicator){
		return recipesService.getRecipesByIndicator(indicator);
	}
	/**
	 * GET MAPPING used to get list of recipes based on recipeName in JSON format (using POSTMAN)
	 * @param recipeName name of the recipie
	 * @return list of matching recipes in JSON format if available else null
	 */
	@GetMapping("/getByRecipeName/{recipeName}")
	public List<Recipes> getRecipesByRecipeName(@PathVariable(value="recipeName") String recipeName){
		return recipesService.getRecipesByRecipeName(recipeName);
	}
	/**
	 * GET MAPPING used to get list of recipes based on ingrediant in JSON format (using POSTMAN)
	 * @param ingrediant - one
	 * @return list of matching recipes in JSON format if available else null
	 */
	@GetMapping("/getByIngrediant/{ingrediant}")
	public List<Recipes> getRecipesByIngrediant(@PathVariable(value="ingrediant") String ingrediant){
		return recipesService.getRecipesByIngrediant(ingrediant);
	}
	/**
	 * GET MAPPING used to get list of recipes based on instruction in JSON format (using POSTMAN)
	 * @param instruction - one
	 * @return list of matching recipes in JSON format if available else null
	 */
	@GetMapping("/getByInstruction/{instruction}")
	public List<Recipes> getRecipesByInstruction(@PathVariable(value="instruction") String instruction){
		return recipesService.getRecipesByInstruction(instruction);
	}
	/**
	 * POST MAPPING to update the recipe by id and recipe details
	 * @param recipesId to be updated
	 * @param recipesDetails to be udpated
	 * @return updaetd recipe if availabe else null
	 */
	@PostMapping("/updateById/{id}")
	public Recipes updateRecipesById(@PathVariable(value="id") Long recipesId, @RequestBody Recipes recipesDetails){
		return recipesService.updateRecipesById(recipesId, recipesDetails);
	}
	/**
	 * DELETE MAPPING to update the recipie by id
	 * @param recipesId to be deleted
	 * @return message if recipe is deleted or not
	 */
	@DeleteMapping("/deleteById/{id}")
	public String deleteRecipesById(@PathVariable(value="id") Long recipesId){
		return recipesService.deleteRecipesById(recipesId);
	}
	/**
	 * GET MAPPING used to get list of recipes based on ingrediants in JSON format (using POSTMAN)
	 * @param ingrediants (comma separated ingrediants)
	 * @return list of matching recipes in JSON format if available else null
	 */
	@GetMapping("/getByIngrediants/{ingrediants}")
	public Set<Recipes> getRecipesByIngrediants(@PathVariable(value="ingrediants") String ingrediants){
		return recipesService.getRecipesByIngrediants(ingrediants);
	}
	/**
	 * GET MAPPING used to get list of recipes based on instructions in JSON format (using POSTMAN)
	 * @param instructions (comma separated instructions)
	 * @return list of matching recipes in JSON format if available else null
	 */
	@GetMapping("/getByInstructions/{instructions}")
	public Set<Recipes> getRecipesByInstructions(@PathVariable(value="instructions") String instructions){
		return recipesService.getRecipesByInstructions(instructions);
	}

}
