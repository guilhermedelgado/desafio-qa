package DesafioQA;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class PokemonTests extends BaseTest{
	
	
	@Test
	public void deveValidarPikachu() 
	{		
		given()
			.log().all()
		.when()
			.get("pokemon/pikachu/")		
		.then()
			.statusCode(200)
			.body("id", is(notNullValue()))
			.body("weight", is(60))
			.body("height", is(4))
			.body("abilities.ability[0].name", is("lightning-rod"))	
			.body("base_experience", lessThan(113))
			.body("moves.move[0].name",is("mega-punch"))
			;		
	}
	
	@Test
	public void deveValidarPokemon1() 
	{		
		given()
			.log().all()
		.when()
			.get("pokemon/1/")		
		.then()
			.statusCode(200)			
			.body("name", is("bulbasaur"))
			.body("base_experience",greaterThan(63))
			.body("id", is(notNullValue()))
			.body("abilities.ability.name", hasItems("overgrow","chlorophyll"))	
			.body("moves.move[77].name", is("confide"))			
			;		
	}
	
	@Test
	public void deveValidarPokemonCharizard() 
	{		
		given()
			.log().all()
		.when()
			.get("pokemon/charizard/")		
		.then()
			.statusCode(200)
			.body("id", is(notNullValue()))
			.body("types.type[1].name", is("fire"))
			.body("weight", is(905))
			.body("location_area_encounters", containsString("/6/encounters"))				
			;
		
	}
	
	
	@Test
	public void deveValidarPokemonType4() 
	{		
		given()
			.log().all()
		.when()
			.get("type/4/")		
		.then()
			.statusCode(200)
			.body("id", is(notNullValue()))
			.body("pokemon", hasSize(72))	
			.body("moves.name[2]",is("poison-powder"))
			.body("game_indices.generation[0].name", is("generation-i"))				
			;		
	}
	
	@Test
	public void excecaoValidarTypeInexistente()
	{
		given()
		.when()
			.get("type/3250/")	
		.then()
			.statusCode(404)
		;		
	}		
	
	@Test
	public void excecaoValidarLinkInexistente()
	{
		given()
		.when()
			.get("hability/4")	
		.then()
			.statusCode(404)
		;		
	}
	
	
	@Test
	public void excecaoValidarAcaoNaoPermitida()
	{
		given()
		.when()
			.delete("hability/4")	
		.then()
			.statusCode(404)
		;		
	}
	
	
	
	
	

}
