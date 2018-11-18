package insert;

public class InsertTweetsIntoDB
{
    public static void main(String args[])
    {
        GetTweets t = new GetTweets();
        for(String hashtag : Constants.ARR_HASHTAGS)
        {
            t.queryForTweets(hashtag);
        }
        t.writeResults();
        
    }
}
