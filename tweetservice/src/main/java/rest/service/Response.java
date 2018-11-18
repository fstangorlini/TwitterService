package rest.service;

import com.google.gson.JsonElement;

public class Response
{
	@SuppressWarnings("unused")
	private JsonElement data;
	
	public Response(JsonElement data)
	{
		this.data = data;
	}
}
