/**
 * 
 */
package com.assignment.recipes.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.recipes.model.Recipes;
import com.assignment.recipes.repository.RecipesRepository;
import com.assignment.recipes.service.RecipesService;

@Service
@Transactional
public class RecipesServiceImpl implements RecipesService {
	
	@Autowired
	private RecipesRepository recipesRepository;
	/**
	 * create a recipe
	 * @param recipes
	 * @return created recipes
	 */
	@Override
	public Recipes createRecipes(Recipes recipes) {
		return recipesRepository.save(recipes);
	}
	/**
	 * get all the recipes available
	 * @return List of recipes
	 */
	@Override
	public List<Recipes> getAllRecipes() {
		return recipesRepository.findAll();
	}
	/**
	 * get recipe by id
	 * @param recipe id
	 * @return retrieved recipe if present or else null
	 */
	@Override
	public Recipes getRecipesById(Long id) {
		return recipesRepository.findById(id).orElse(null);
	}
	/**
	 * get list of recipes by people count
	 * @param number of people
	 * @return list of recipes
	 */
	@Override
	public List<Recipes> getRecipesByNumberOfPeople(Integer peopleCount) {
		return recipesRepository.findByNumberOfPeople(peopleCount);
	}
	/**
	 * get list of recipes matching by indicator
	 * @param indicator
	 * @return list of recipes
	 */
	@Override
	public List<Recipes> getRecipesByIndicator(String indicator) {
		return recipesRepository.findByIndicator(indicator.toUpperCase());
	}
	/**
	 * get list of recipes matching by its name
	 * @param recipe name
	 * @return list of recipes
	 */
	@Override
	public List<Recipes> getRecipesByRecipeName(String recipeName) {
		return recipesRepository.findByRecipeName(recipeName.toUpperCase());
	}
	/**
	 * get list of recipes matching by its ingrediant
	 * @param recipe ingrediant
	 * @return list of recipes
	 */
	@Override
	public List<Recipes> getRecipesByIngrediant(String ingrediant) {
		return recipesRepository.findByIngrediant(ingrediant.toUpperCase());
	}
	/**
	 * get list of recipes matching by its instruction
	 * @param recipe instruction
	 * @return list of recipes
	 */
	@Override
	public List<Recipes> getRecipesByInstruction(String instruction) {
		return recipesRepository.findByInstruction(instruction.toUpperCase());
	}
	/**
	 * update the receipe with the received recipesDetails
	 * @param recipes id to be updated
	 * @param recipes details to be updated
	 * @return updated recipe if matching found, if not available returns null
	 */
	@Override
	public Recipes updateRecipesById(Long recipesId, Recipes recipesDetails) {
		Recipes recipes = getRecipesById(recipesId);
		if(null!=recipes) {
			recipes.setCount(recipesDetails.getCount());
			recipes.setIndicator(recipesDetails.getIndicator());
			recipes.setIngrediants(recipesDetails.getIngrediants());
			recipes.setInstructions(recipesDetails.getInstructions());
			recipes.setRecipeName(recipesDetails.getRecipeName());
			Recipes updatedRecipes = recipesRepository.save(recipes);
			return updatedRecipes;
		}else {
			return null;
		}
	}
	/**
	 * deletes recipe by recipes id
	 * @param recipes id to be deleted
	 * @return message whether recipe deleted or not
	 */
	@Override
	public String deleteRecipesById(Long recipesId) {
		Recipes recipes = getRecipesById(recipesId);
		if(null!=recipes) {
			recipesRepository.deleteById(recipesId);
			return "Recepie "+recipesId+" successfully deleted";
		}else {
			return "Recepie "+recipesId+" is not available for deletion";
		}
	}
	/**
	 * get list of recipes matching by its ingrediants
	 * @param recipe ingrediants {comma [,] separated}
	 * @return list of recipes
	 */
	@Override
	public Set<Recipes> getRecipesByIngrediants(String ingrediants) {
		String[] arrayOfIngrediants = ingrediants.split(",");
		Set<Recipes> matchingRecipes = new HashSet<>();
		for(String ingrediant: arrayOfIngrediants) {
			List<Recipes> recipes = getRecipesByIngrediant(ingrediant);
			if(null!=recipes) {
				matchingRecipes.addAll(recipes);
			}
		}
		return matchingRecipes;
	}
	/**
	 * get list of recipes matching by its instructions
	 * @param recipe instructions {comma [,] separated}
	 * @return list of recipes
	 */
	@Override
	public Set<Recipes> getRecipesByInstructions(String instructions) {
		String[] arrayOfInstructions = instructions.split(",");
		Set<Recipes> matchingRecipes = new HashSet<>();
		for(String instruction: arrayOfInstructions) {
			List<Recipes> recipes = getRecipesByInstruction(instruction);
			if(null!=recipes) {
				matchingRecipes.addAll(recipes);
			}
		}
		return matchingRecipes;
	}

}
