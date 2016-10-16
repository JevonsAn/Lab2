package lab2;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class Insert extends ActionSupport{
	private static String isbn,title,name,publisher,publishdate,price,country;
	private static int age;
	private static String author_id;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String execute()
	{
		try{
			int flag=0;
			Lian newl=new Lian(); 
			java.sql.Connection conn=newl.connection();
	        java.sql.Statement stmt = conn.createStatement();  
	        
	        String sql = "select authorid from bookdb.author where name='"+name+"';";
	        java.sql.ResultSet res = stmt.executeQuery(sql);
	        if(res.next()) {    
	        	author_id=res.getString("AuthorID");  
	        }
	        else{
	        	return INPUT;
	        }
	        
	        sql = "INSERT INTO bookdb.book(isbn,title,authorid,publisher,publishdate,price) VALUES('"+
	        isbn+"','"+title+"','"+author_id+"','"+publisher+"','"+publishdate+"',"+price+");";
	        stmt.execute(sql);
	        
	        res.close();  
	        stmt.close();  
	        conn.close(); 
	        return SUCCESS;
		}
		catch(Exception e){
			return ERROR;			
		}		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String insertauthor(){
		try{
			Lian newl=new Lian(); 
			java.sql.Connection conn=newl.connection();
	        java.sql.Statement stmt = conn.createStatement();  
	        author_id="";
	        String sql = "SELECT count(*) FROM bookdb.author;";
	        java.sql.ResultSet res = stmt.executeQuery(sql);
	        if (res.next())
	        	author_id+=(res.getInt(1)+3);
	        sql = "INSERT INTO bookdb.author(authorid,name,age,country) VALUES('"+
	        author_id+"','"+name+"',"+age+",'"+country+"');";
	        stmt.execute(sql);
	        sql = "INSERT INTO bookdb.book(isbn,title,authorid,publisher,publishdate,price) VALUES('"+
	    	        isbn+"','"+title+"','"+author_id+"','"+publisher+"','"+publishdate+"',"+price+");";
	    	stmt.execute(sql);
	        stmt.close();  
	        conn.close();
	        return SUCCESS;
		}
		catch(Exception e){
			return ERROR;			
		}		
	}

}
