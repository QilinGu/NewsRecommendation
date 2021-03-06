package edu.ruc.WebService;
import java.io.PrintWriter;
import java.util.Date;

import edu.ruc.log.BrowseAnalysis;
import edu.ruc.log.ClickAnalysis;
import edu.ruc.log.CollectAnalysis;
import edu.ruc.log.CommentAnalysis;
import edu.ruc.log.LogAnalysis;
import edu.ruc.log.NewsAnalysis;
import edu.ruc.news.News;
import edu.ruc.user.OnlineUsers;
import edu.ruc.user.User;
import net.sf.json.*;
public class Click extends DataAnalysis{
	private long UserID;
	private long NewsID;
	private Date date;
	private LogAnalysis analysis;
	
	@SuppressWarnings("deprecation")
	public Click(JSONObject json) {
		UserID = json.getLong("UserID");
		NewsID = json.getLong("NewsID");
		date = new Date(json.getString("Date"));
	}
	/**
     * Analyse user's behavior.
     */
	public void BehaveAnalyse(User u,News news) {
		NewsAnalysis na = new NewsAnalysis(news,NewsID);
		analysis = new ClickAnalysis(u,na,date.getTime());
	}
	/**
     * Update user's profile.
     */
	public void UpdateUserProfile(PrintWriter pw_log) {
		analysis.UpdateUser(pw_log);
	}
	/**
     * Get uid.
     */
	public long getUid() {
		return UserID;
	}
	
	/**
     * Get nid.
     */
	public long getNid() {
		return NewsID;
	}
}
