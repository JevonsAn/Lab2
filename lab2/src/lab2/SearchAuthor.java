package lab2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAuthor extends ActionSupport{
	private List<Search> list=new ArrayList<Search>();
	private String name;
	private String title;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public String execute(){
		try{
		Lian newl=new Lian();
		//3获取表达式SQL  
		java.sql.Connection conn=newl.connection();
        java.sql.Statement stmt = conn.createStatement();  
        //4.执行SQL  
        String sql = "select authorid from bookdb.author where name='"+name+"';";
        java.sql.ResultSet res = stmt.executeQuery(sql);
        //5.打印结果集里的数据
        String author_id = new String();
        while(res.next()) {    
        	author_id=res.getString("AuthorID");   
        }
        sql = "select title,isbn from bookdb.book where authorid="+author_id;
        res = stmt.executeQuery(sql);
        list.clear();
        while(res.next()) {   
        	Search s=new Search();
        	s.title=res.getString(1);
        	s.isbn=res.getString(2);
        	list.add(s);
        } 
        //测试插入数据库的功能：  
        //String inSql = "insert into test(user,addr) values('插入2','新地址2')";  
        //stmt.executeUpdate(inSql);  
          
        //6.释放资源，关闭连接（这是一个良好的习惯）  
        res.close();  
        stmt.close();  
        conn.close();		
		return SUCCESS;}
		catch(Exception e){
			return ERROR;			
		}
	}
	public List<Search> getList() {
		return list;
	}
	public void setList(List<Search> list) {
		this.list = list;
	}

}
