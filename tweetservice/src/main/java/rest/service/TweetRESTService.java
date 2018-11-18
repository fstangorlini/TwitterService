package rest.service;

import static spark.Spark.get;

import com.google.gson.Gson;
 
public class TweetRESTService {

	public static void main(String[] args)
	{
		get("/getTopFollowers", (req, res)->
		{
			res.type("application/json");
			return new Gson().toJson(
				      new Response(new Gson().toJsonTree(TweetService.getTopFollowers())));
		});
		
		get("/getTweetsCountPerHour", (req, res)->
		{
			res.type("application/json");
			return new Gson().toJson(
				      new Response(new Gson().toJsonTree(TweetService.getTweetsCountPerHour())));
		});
		
		get("/getTweetsCountPerLocation", (req, res)->
		{
			res.type("application/json");
			return new Gson().toJson(
				      new Response(new Gson().toJsonTree(TweetService.getTweetsCountPerLocation())));
		});

	}

}
