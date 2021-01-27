package com.assignment.recipes.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.assignment.recipes.model.Recipes;

@Component
public interface RecipesService {
	public Recipes createRecipes(Recipes recipes);
	public List<Recipes> getAllRecipes();
	public Recipes getRecipesById(Long id);
	public List<Recipes> getRecipesByNumberOfPeople(Integer peopleCount);
	public List<Recipes> getRecipesByIndicator(String indicator);
	public List<Recipes> getRecipesByRecipeName(String recipeName);
	public List<Recipes> getRecipesByIngrediant(String ingrediant);
	public List<Recipes> getRecipesByInstruction(String instruction);
	public Recipes updateRecipesById(Long recipesId, Recipes recipesDetails);
	public String deleteRecipesById(Long recipesId);
	public Set<Recipes> getRecipesByIngrediants(String ingrediants);
	public Set<Recipes> getRecipesByInstructions(String instructions);
	
}
