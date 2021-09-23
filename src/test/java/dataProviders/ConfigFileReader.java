package dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private final String propertyFilePath = "configs/Configuration.properties";
	FileInputStream reader = null;
	static Properties properties = null;

	public ConfigFileReader() {
		try {
			reader = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static String getBROWSER() {
		String BROWSER = properties.getProperty("BROWSER");
		if (BROWSER != null)
			return BROWSER;
		else
			throw new RuntimeException("BROWSER not specified in the Configuration.properties file.");
	}
	
	public static String getBaseURL() {
		String baseURL = properties.getProperty("baseURL");
		if (baseURL != null)
			return baseURL;
		else
			throw new RuntimeException("BaseURL not specified in the Configuration.properties file.");
	}
	
	public static String getUserEmail() {
		String userEmail = properties.getProperty("userEmail");
		if (userEmail != null)
			return userEmail;
		else
			throw new RuntimeException("UserEmail not specified in the Configuration.properties file.");
	}
	
	public static String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file.");
	}
	
	public static String getLoginPageTitle() {
		String loginPageTitle = properties.getProperty("loginPageTitle");
		if (loginPageTitle != null)
			return loginPageTitle;
		else
			throw new RuntimeException("LoginPageTitle not specified in the Configuration.properties file.");
	}
	
	public static String getHomePageTitle() {
		String homePageTitle = properties.getProperty("homePageTitle");
		if (homePageTitle != null)
			return homePageTitle;
		else
			throw new RuntimeException("HomePageTitle not specified in the Configuration.properties file.");
	}
	
	public static String getPageSearchTerm() {
		String pageSearchTerm = properties.getProperty("pageSearchTerm");
		if (pageSearchTerm != null)
			return pageSearchTerm;
		else
			throw new RuntimeException("PageSearchTerm not specified in the Configuration.properties file.");
	}
	
	public static String getChannelSearchTerm() {
		String channelSearchTerm = properties.getProperty("channelSearchTerm");
		if (channelSearchTerm != null)
			return channelSearchTerm;
		else
			throw new RuntimeException("ChannelSearchTerm not specified in the Configuration.properties file.");
	}
	
	public static String getPostText() {
		String postText = properties.getProperty("postText");
		if (postText != null)
			return postText;
		else
			throw new RuntimeException("PostText not specified in the Configuration.properties file.");
	}
	
	public static String getInterviewChannelPageTitle() {
		String interviewChannelPageTitle = properties.getProperty("interviewChannelPageTitle");
		if (interviewChannelPageTitle != null)
			return interviewChannelPageTitle;
		else
			throw new RuntimeException("InterviewChannelPageTitle not specified in the Configuration.properties file.");
	}
	
	public static String getChannelPostText() {
		String channelPostText = properties.getProperty("channelPostText");
		if (channelPostText != null)
			return channelPostText;
		else
			throw new RuntimeException("ChannelPostText not specified in the Configuration.properties file.");
	}
	
	public static String getCommentAddedBy() {
		String commentAddedBy = properties.getProperty("commentAddedBy");
		if (commentAddedBy != null)
			return commentAddedBy;
		else
			throw new RuntimeException("CommentAddedBy not specified in the Configuration.properties file.");
	}
	
	public static String getAnnouncement() {
		String itsAnnouncement = properties.getProperty("itsAnnouncement");
		if (itsAnnouncement != null)
			return itsAnnouncement;
		else
			throw new RuntimeException("Announcement text not specified in the Configuration.properties file.");
	}
	
	
	public static String getPageContent() {
		String pageContent = properties.getProperty("pageContent");
		if (pageContent != null)
			return pageContent;
		else
			throw new RuntimeException("PageContent text not specified in the Configuration.properties file.");
	}
}
