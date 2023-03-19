package qaautomation.maret2023;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import qaautomation.maret2023.utils.GraphQLRequestBuilder;
import static io.restassured.RestAssured.given;

public class GraphQLTest {
	
	@Test
	public void checkGenus() {
		GraphQLRequestBuilder gql = new GraphQLRequestBuilder();
		String query = "query MyQuery{pokemon_v2_pokemonspeciesname(limit:5){genus name}}";
		gql.setQuery(query);
		String jsonStringQueryString = gql.getJSONString();
		
		Response responseGenusResponse = given().contentType(ContentType.JSON)
				.body(jsonStringQueryString)
				.when()
				.post("https://beta.pokeapi.co/graphql/v1beta");
		String expectedgenus = "Pokémon Graine";
		String genusName = responseGenusResponse.jsonPath().get("data.pokemon_v2_pokemonspeciesname[4].genus");
		System.out.println("genusName"+genusName);
		assertEquals(genusName, expectedgenus);
	}		
}
