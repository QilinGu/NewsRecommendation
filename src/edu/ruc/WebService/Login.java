package edu.ruc.WebService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import test.MakeRandomHashmap;
import edu.ruc.data.Alphabet;
import edu.ruc.data.Dictionary;
import edu.ruc.database.NewsDatabase;
import edu.ruc.news.News;
import edu.ruc.news.NewsList;
import edu.ruc.ranker.Ranker;
import edu.ruc.ranker.RankerType;
import edu.ruc.ranker.ResultStore;
import edu.ruc.user.OnlineUsers;
import edu.ruc.user.User;
import net.sf.json.*;
public class Login extends DataAnalysis{
	private long UserID;
	private String Password;
	public Login(JSONObject json) {
		UserID = json.getLong("UserID");
		Password = json.getString("Password");
	}
	/**
     * Get uid.
     */
	public long getUid() {
		return UserID;
	}
	public String deal(OnlineUsers users,NewsDatabase newsData, ResultStore resultStore, 
			Dictionary dict,Alphabet attributeSet, Connection con)throws Exception {
			
		 MakeRandomHashmap MakeRandomHashmap = new MakeRandomHashmap();
	 	 User user = users.findUser(UserID);
		 System.out.println("---------pp-------");
		 String s;
		 s = "UserID : "+user.getUid()+"<br />";
		 s = s + user.getHashmap(dict,attributeSet).keySet().toString()+"<br /><br />";
		 
		 Ranker ranker = new Ranker();
		 
		 NewsList temp = ranker.query(resultStore, user, "all", newsData.getNewsListbyTopic(
				 user.getHashmap(dict,attributeSet),"headline",dict,attributeSet).getNewsList(), RankerType.VSM, 10);
		 List<News> ans = temp.getNewsList();
		 s = s + "     VSM 推荐的新闻为：   <br />";
		 for(int j=0;j<ans.size();j++){
			 s = s + ans.get(j).getTitle()+"<br />";
		 }
		 s = s+"<br />";
		 
		 temp = ranker.query(resultStore, user, "all", newsData.getNewsListbyTopic(
				 user.getHashmap(dict,attributeSet),"headline",dict,attributeSet).getNewsList(), RankerType.VSM, 10);
		 ans = temp.getNewsList();
		 s = s + "     POPULARITY 推荐的新闻为：   <br />";
		 for(int j=0;j<ans.size();j++){
			 s = s + ans.get(j).getTitle()+"<br />";
		 }
		 s = s+"<br />";
		 
		 
		 temp = ranker.query(resultStore, user, "all", newsData.getNewsListbyTopic(
				 user.getHashmap(dict,attributeSet),"headline",dict,attributeSet).getNewsList(), RankerType.VSM, 10);
		 ans = temp.getNewsList();
		 s = s + "     TIME 推荐的新闻为：   <br />";
		 for(int j=0;j<ans.size();j++){
			 s = s + ans.get(j).getTitle()+"<br />";
		 }
		 s = s+"<br />";
		 
		 
		 
		 /*JSONObject json = new JSONObject();
		 String s;
		 System.out.println("User ID: " + user.getUid());
		 s = "UserID : "+user.getUid()+"<br />";
		 s = s + user.getHashmap(dict,attributeSet).keySet().toString()+"<br />";
		 s = s + "     推荐的新闻为：   <br />";
		 for(int j=0;j<ans.size();j++){
			 s = s + ans.get(j).getTitle()+"<br />";
			 json.put("News"+j, ans.get(j).getTitle());
		 }
		 System.out.println(json.toString());
	//	return json.toString();
*/		 return s;
	}
}
