package com.example.appnew;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppServer {

	   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	   static final String USER = "hr";
	   static final String PASS = "hr";
	   
	   public Map<String,List<ContentWrapperData>> getContent() {
		   List<ContentWrapperData> dataList;
		   Map<String,List<ContentWrapperData>> resultMap = new HashMap<String,List<ContentWrapperData>>();
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected successfully...");
		      
		      stmt = conn.createStatement();
		
		      String sql = "SELECT * FROM content";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		    	  
		    	  ContentWrapperData wrapperObj = new ContentWrapperData();
		    	  wrapperObj.setMonth(rs.getString("month"));
		    	  Blob blob=rs.getBlob("content");
		    	  wrapperObj.setContent(blob.getBinaryStream());
		    	  wrapperObj.setAuthor(rs.getString("author"));
		    	  wrapperObj.setYear(rs.getInt("year"));
		    	  
		    	  if(resultMap.containsKey(wrapperObj.getMonth().toLowerCase()))
		    		  dataList=resultMap.get(wrapperObj.getMonth().toLowerCase()) ; 
		    	  else
		    		  dataList= new ArrayList<ContentWrapperData>();
		    	  
		    	  dataList.add(wrapperObj);
		    	  resultMap.put(wrapperObj.getMonth().toLowerCase(), dataList);
		        
		      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		    	  se.printStackTrace();
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		   return resultMap;
	}

}
