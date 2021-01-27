package com.assignment.recipes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.recipes.model.Recipes;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long> {
	@Query("SELECT recipes from Recipes recipes WHERE recipes.count=:count")
	List<Recipes> findByNumberOfPeople(@Param("count") Integer count);
	
	@Query("SELECT recipes from Recipes recipes WHERE upper(recipes.indicator)=:indicator")
	List<Recipes> findByIndicator(@Param("indicator") String indicator);
	
	@Query("SELECT recipes from Recipes recipes WHERE upper(recipes.recipeName) LIKE %:recipeName%")
	List<Recipes> findByRecipeName(@Param("recipeName") String recipeName);
	
	@Query("SELECT recipes from Recipes recipes WHERE upper(recipes.instructions) LIKE %:instruction%")
	List<Recipes> findByInstruction(@Param("instruction") String instruction);
	
	@Query("SELECT recipes from Recipes recipes WHERE upper(recipes.ingrediants) LIKE %:ingrediant%")
	List<Recipes> findByIngrediant(@Param("ingrediant") String ingrediant);

}
