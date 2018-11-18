package rest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import insert.Constants;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

public interface TweetService
{
	
	public static JSONArray getTopFollowers()
	{
		JSONArray json = new JSONArray();
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(Constants.DB_CONN_STRING,Constants.DB_USER, Constants.DB_PASS);
		}
		catch (SQLException e)
		{
            e.printStackTrace();
		}
		if (connection != null)
		{
			try
			{
				Statement stmt;
				String query = Constants.DB_GET_TOP_FOLLOWERS;
				ResultSet resultSet;
				stmt = connection.createStatement();
	            resultSet = stmt.executeQuery(query);
	            ResultSetMetaData rsmd = resultSet.getMetaData();
	            while(resultSet.next())
	            {
	            	int numColumns = rsmd.getColumnCount();
					JSONObject obj = new JSONObject();
					for (int i=1; i<=numColumns; i++)
					{
						String column_name = rsmd.getColumnName(i);
					    obj.put(column_name, resultSet.getObject(column_name));
					}
					json.put(obj);
	            }
	            
			}
			catch (SQLException e)
			{
	            e.printStackTrace();
			}
			finally
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			return json;
		}
		else
		{
			return null;
		}
	}

	
	public static JSONArray getTweetsCountPerHour()
	{
		JSONArray json = new JSONArray();
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(Constants.DB_CONN_STRING,Constants.DB_USER, Constants.DB_PASS);
		}
		catch (SQLException e)
		{
            e.printStackTrace();
		}
		if (connection != null)
		{
			try
			{
				Statement stmt;
				String query = Constants.DB_GET_TWEET_COUNT_PER_HOUR;
				ResultSet resultSet;
				stmt = connection.createStatement();
	            resultSet = stmt.executeQuery(query);
	            ResultSetMetaData rsmd = resultSet.getMetaData();
	            while(resultSet.next())
	            {
	            	int numColumns = rsmd.getColumnCount();
					JSONObject obj = new JSONObject();
					for (int i=1; i<=numColumns; i++)
					{
						String column_name = rsmd.getColumnName(i);
					    obj.put(column_name, resultSet.getObject(column_name));
					}
					json.put(obj);
	            }
	            
			}
			catch (SQLException e)
			{
	            e.printStackTrace();
			}
			finally
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			return json;
		}
		else
		{
			return null;
		}
	}
	
	public static JSONArray getTweetsCountPerLocation()
	{
		JSONArray json = new JSONArray();
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(Constants.DB_CONN_STRING,Constants.DB_USER, Constants.DB_PASS);
		}
		catch (SQLException e)
		{
            e.printStackTrace();
		}
		if (connection != null)
		{
			try
			{
				Statement stmt;
				String query = Constants.DB_GET_TWEET_COUNT_PER_LOCATION;
				ResultSet resultSet;
				stmt = connection.createStatement();
	            resultSet = stmt.executeQuery(query);
	            ResultSetMetaData rsmd = resultSet.getMetaData();
	            while(resultSet.next())
	            {
	            	int numColumns = rsmd.getColumnCount();
					JSONObject obj = new JSONObject();
					for (int i=1; i<=numColumns; i++)
					{
						String column_name = rsmd.getColumnName(i);
					    obj.put(column_name, resultSet.getObject(column_name));
					}
					json.put(obj);
	            }
	            
			}
			catch (SQLException e)
			{
	            e.printStackTrace();
			}
			finally
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			return json;
		}
		else
		{
			return null;
		}
	}
	
}
