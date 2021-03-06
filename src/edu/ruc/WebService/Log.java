package edu.ruc.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import edu.ruc.data.Alphabet;
import edu.ruc.data.Dictionary;
import edu.ruc.database.NewsDatabase;
import edu.ruc.ranker.ResultStore;
import edu.ruc.user.OnlineUsers;
import net.sf.json.*;
public class Log extends DataAnalysis{
	private String js;
	private JSONObject json;
	
	@SuppressWarnings("deprecation")
	public Log(JSONObject J) {
		json = J;
		js = J.toString();
		UserID = J.getLong("UserID");
	}
	public String deal(OnlineUsers users,NewsDatabase newsData, ResultStore resultStore, 
			Dictionary dict,Alphabet attributeSet, Connection con)throws Exception {
		String strsql = "insert into log(logID, uid, json, flag)" + " values(?,?,?,?)";
		long uid = json.getLong("UserID");
		String logID = ""+System.currentTimeMillis()+""+uid;

		PreparedStatement pstmt = con.prepareStatement(strsql);
	    pstmt.setString(1, logID);
	    pstmt.setLong(2, uid);
	    pstmt.setString(3, js);
	    pstmt.setInt(4, 0);
	    pstmt.execute();
	    return "ok";
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
