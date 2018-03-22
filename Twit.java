import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthConsumerKey("BNsJAqjjVItWotG4C4tomM4Tz")
				.setOAuthConsumerSecret("3ZeE7zcjR26q2qvP2GBuXr0gqfq3XJfAxqGdbCyhLdElP0amL1")
				.setOAuthAccessToken("947181835204915205-j4lWojrZf1z27XQ3PIgzgTCFRCvm2K0")
				.setOAuthAccessTokenSecret("waOEzloiD0ciqmuzs4QojY0gYY3HJfVBmGMZfb9J6DjdZ");

		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();

		try {
			// The factory instance is re-useable and thread safe. Twitter twitter =
			// TwitterFactory.getSingleton();

			Query query = new Query("bots");
			QueryResult result = twitter.search(query);
			for (Status status : result.getTweets()) {
				System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
				System.out.println("@" + status.getUser().isVerified() + ":" + status.getUser().getTimeZone());
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
