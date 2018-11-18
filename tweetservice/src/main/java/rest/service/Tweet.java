package rest.service;

import java.util.Date;

public class Tweet
{
	private long 			tweetID;
	private String			userName;
	private int 			followers;
	private Date			tweetDate;
	private String			tweetLocation;
	private String			tweetLanguage;
	private String			tweetText;
	
	public Tweet()
	{
		
	}
	
	public Tweet(long tweetID, String userName, int followers, Date tweetDate, String tweetLocation, String tweetLanguage, String tweetText)
	{
		this.tweetID 		= tweetID;
		this.userName 		= userName;
		this.followers 		= followers;
		this.tweetDate 		= tweetDate;
		this.tweetLocation 	= tweetLocation;
		this.tweetLanguage 	= tweetLanguage;
		this.tweetText 		= tweetText;
	}

	public long getTweetID() {
		return tweetID;
	}

	public void setTweetID(long tweetID) {
		this.tweetID = tweetID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetLocation() {
		return tweetLocation;
	}

	public void setTweetLocation(String tweetLocation) {
		this.tweetLocation = tweetLocation;
	}

	public String getTweetLanguage() {
		return tweetLanguage;
	}

	public void setTweetLanguage(String tweetLanguage) {
		this.tweetLanguage = tweetLanguage;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
	
	

}
