package lab2;
import com.opensymphony.xwork2.ActionSupport;
public class  Update extends ActionSupport{
	private String u2;
	private static String u,isbn,u3;
	public String getU3() {
		return u3;
	}

	public void setU3(String u3) {
		this.u3 = u3;
	}

	public String getU2() {
		return u2;
	}

	public void setU2(String u2) {
		this.u2 = u2;
	}

	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String execute()
	{
		try{
			Lian newl=new Lian(); 
			java.sql.Connection conn=newl.connection();
	        java.sql.Statement stmt = conn.createStatement();  
	        String sql = "";	        
	        if (u3.equals("author")){
	        	String column="";
		        String author_id="";
	        	column="authorid";
	        	sql = "select authorid from bookdb.author where name='"+u2+"';";
		        java.sql.ResultSet res = stmt.executeQuery(sql);
		        if(res.next()) {    
		        	author_id=res.getString("AuthorID");  
		        }
		        else{
		        	sql = "SELECT count(*) FROM bookdb.author;";
			        res = stmt.executeQuery(sql);
			        if (res.next())
			        	author_id+=(res.getInt(1)+1);
			        sql = "INSERT INTO bookdb.author(authorid,name) VALUES('"+
			    	        author_id+"','"+u2+"');";
			    	stmt.execute(sql);
		        }
		        sql = "UPDATE bookdb.book SET "+column+"="+author_id+" WHERE isbn='"+isbn+"';";
		        stmt.execute(sql);
		        res.close();  
		        stmt.close();  
		        conn.close(); 
		        return SUCCESS;
	        }
	        else if (u3.equals("publisher") || u3.equals("publishdate")){
	 
		        sql = "UPDATE bookdb.book SET "+u3+"='"+u2+"' WHERE isbn='"+isbn+"';";	        
		        stmt.execute(sql);		         
		        stmt.close();  
		        conn.close(); 
		        return SUCCESS;
	        }
	        else if (u3.equals("price")){
	        	sql = "UPDATE bookdb.book SET "+u3+"="+u2+" WHERE isbn='"+isbn+"';";	        
		        stmt.execute(sql);		         
		        stmt.close();  
		        conn.close(); 
		        return SUCCESS;
	        }
	        else{
	        	sql=u+" "+u2+" "+u3;
	        	return ERROR;
	        }
		}
		catch(Exception e){
			return ERROR;			
		}		
	}

	public String print(){
		return SUCCESS;
	}
}
