package insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Felipe S.
 */
public class GetTweets {

    
    private ConfigurationBuilder cb = new ConfigurationBuilder();
    private Twitter twitter;
    private ArrayList<Status> tweets;
    private Properties props;

    GetTweets()
    {
        try
        {
            props = getProperties();
        } catch (IOException e)
        {
            System.err.println(Constants.ERR_FILE_PROP);
        }
            cb.setDebugEnabled(true).setOAuthConsumerKey(props.getProperty(Constants.PROP_CONSUMER_KEY))
                            .setOAuthConsumerSecret(props.getProperty(Constants.PROP_CONSUMER_SECRET))
                            .setOAuthAccessToken(props.getProperty(Constants.PROP_ACCESS_TOKEN))
                            .setOAuthAccessTokenSecret(props.getProperty(Constants.PROP_ACCESS_TOKEN_SECRET));
            twitter = new TwitterFactory(cb.build()).getInstance();
            tweets = new ArrayList<>();
    }
    
    public void queryForTweets(String hashTags)
    {
        Query query = new Query(hashTags);
        query.setCount(Constants.NUMBER_OF_TWEETS);
        QueryResult result = null;
        try
        {
            result = twitter.search(query);
        } catch (TwitterException ex) {System.err.println(Constants.ERR_TW_QUERY);}
        for (Status status : result.getTweets())
        {
            tweets.add(status);/*
            System.out.print("ID: "+status.getId()+"\n");
            System.out.print("@"+status.getUser().getScreenName()+"\n");
            System.out.print("Followers: "+status.getUser().getFollowersCount()+"\n");
            System.out.print("Date: "+status.getCreatedAt().toString()+"\n");
            System.out.print("Location: "+status.getUser().getLocation()+"\n");
            System.out.print("Language: "+status.getLang()+"\n");
            System.out.print("Text: "+status.getText()+"\n\n");*/
        }
        //System.out.println("Tweets Size: "+tweets.size());
    }
    
    private Properties getProperties() throws IOException
    {
        props = new Properties();
        FileInputStream file = new FileInputStream(Constants.PROP_FILE_PATH);
        props.load(file);
        return props;
    }
    
    public void writeResults()
    {
        try
        {
            Class.forName(Constants.DB_DRIVER);
        } catch (ClassNotFoundException e)
        {
            System.err.println("MySQL JDBC Driver not found...");
            return;
		}
		Connection connection = null;
		try
	        {
	            connection = DriverManager.getConnection(Constants.DB_CONN_STRING,Constants.DB_USER, Constants.DB_PASS);
		} catch (SQLException e)
	        {
	            System.err.println("Connection Failed! Check connection error below:");
	            e.printStackTrace();
	            return;
		}
		if (connection != null)
	        {
	            Statement stmt;
	            String query = Constants.DB_INSERT_STATEMENT;
	            final int batchSize = 1000; //Batch size is important.
	            
	            //Create Table
	            /*try {
	                stmt = connection.createStatement();
	                stmt.execute(Constants.DB_CREATE_TABLE);
	            }catch (SQLException ex){System.err.println(ex);}*/
	            try {
	                connection.setAutoCommit(false);  
	                PreparedStatement ps = connection.prepareStatement(query);            
	                for (Status s : tweets)
	                {
	                    ps.setLong(1,s.getId());
	                    ps.setString(2,s.getUser().getScreenName());
	                    ps.setInt(3,s.getUser().getFollowersCount());
	                    ps.setTimestamp(4, new Timestamp(s.getCreatedAt().getTime()));
	                    ps.setString(5,s.getUser().getLocation());
	                    ps.setString(6,s.getLang());
	                    ps.setString(7,s.getText());
	                    ps.addBatch();
	                }
	                ps.executeBatch();
	                connection.commit();
	            }catch (SQLException ex){System.err.println(ex);}
	            
		}
	        else
	        {
	            
		}
	    }
    
    
    
}
