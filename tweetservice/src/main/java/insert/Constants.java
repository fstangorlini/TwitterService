package insert;

/**
 *
 * @author Felipe S.
 */
public class Constants
{
    public static final String[]  ARR_HASHTAGS = {"#openbanking","#apifirst","#devops","#cloudfirst","#microservices","#apigateway","#oauth","#swagger","#raml","#openapis"};
    public static final int    NUMBER_OF_TWEETS = 100;
    public static final String ERR_FILE_PROP = "Unable to load the properties file";
    public static final String PROP_CONSUMER_KEY = "prop.ConsumerKey";
    public static final String PROP_CONSUMER_SECRET = "prop.ConsumerSecret";
    public static final String PROP_ACCESS_TOKEN = "prop.AccessToken";
    public static final String PROP_ACCESS_TOKEN_SECRET = "prop.AccessTokenSecret";
    public static final String PROP_FILE_PATH = "src/main/java/properties/twitterAuth.properties";
    public static final String ERR_CONNECTION = "It was not possible to connect...";
    public static final String ERR_TW_QUERY = "It was not possible to query Twitter...";
    
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_CONN_STRING = "jdbc:mysql://localhost/TweetDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "admin";
    public static final String DB_CREATE_TABLE =    "CREATE TABLE Tweets (\n" +
                                                    "    TweetID bigint PRIMARY KEY,\n" +
                                                    "    UserName varchar(30),\n" +
                                                    "    Followers int,\n" +
                                                    "    TweetDate DATETIME,\n" +
                                                    "    TweetLocation varchar(100),\n" +
                                                    "	 TweetLanguage varchar(10),\n" +
                                                    "	 TweetText varchar(500));";
    
    public static final String DB_INSERT_STATEMENT = "INSERT IGNORE INTO Tweets (TweetID, UserName, Followers, TweetDate, TweetLocation, TweetLanguage, TweetText) VALUES (?,?,?,?,?,?,?)";
    
    //Queries
    public static final String DB_GET_TOP_FOLLOWERS = 				"SELECT DISTINCT UserName, Followers\r\n" + 
											    					"FROM Tweets\r\n" + 
											    					"ORDER BY Followers DESC LIMIT 5;";
    public static final String DB_GET_TWEET_COUNT_PER_HOUR =		"SELECT COUNT(TweetID) AS TweetCount,\r\n" + 
														    		"DATE_FORMAT(TweetDate, \"%H\") AS Hour\r\n" + 
														    		"FROM Tweets\r\n" + 
														    		"GROUP BY DATE_FORMAT(TweetDate, \"%H\")\r\n" + 
														    		"ORDER BY DATE_FORMAT(TweetDate, \"%H\");"; 
    public static final String DB_GET_TWEET_COUNT_PER_LOCATION =	"SELECT COUNT(TweetID) AS TweetCount,\r\n" + 
														    		"TweetLocation\r\n" + 
														    		"FROM Tweets\r\n" + 
														    		"GROUP BY TweetLocation\r\n" + 
														    		"ORDER BY COUNT(TweetID);";
}
