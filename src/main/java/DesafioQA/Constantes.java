package DesafioQA;

import io.restassured.http.ContentType;

public interface Constantes {
	
	String APP_BASE_URL = "https://pokeapi.co/api/v2/";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 5000L;
	

}
