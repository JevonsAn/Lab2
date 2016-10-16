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
		//3��ȡ���ʽSQL  
		java.sql.Connection conn=newl.connection();
        java.sql.Statement stmt = conn.createStatement();  
        //4.ִ��SQL  
        String sql = "select authorid from bookdb.author where name='"+name+"';";
        java.sql.ResultSet res = stmt.executeQuery(sql);
        //5.��ӡ������������
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
        //���Բ������ݿ�Ĺ��ܣ�  
        //String inSql = "insert into test(user,addr) values('����2','�µ�ַ2')";  
        //stmt.executeUpdate(inSql);  
          
        //6.�ͷ���Դ���ر����ӣ�����һ�����õ�ϰ�ߣ�  
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
