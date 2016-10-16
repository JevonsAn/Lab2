package lab2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
//import SelectSql;
public class Select extends ActionSupport{
	private String isbn;
	private List<Book> list=new ArrayList<Book>();
	private List<Author> list2=new ArrayList<Author>();
	public List<Book> getList(){
		return list;
	}
	public List<Author> getList2(){
		return list2;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String execute(){
		try{
			String id;
			Lian newl=new Lian();			
			//3获取表达式SQL  
			java.sql.Connection conn=newl.connection();
		    java.sql.Statement stmt = conn.createStatement();  
		    //4.执行SQL  
		    String sql = "select * from bookdb.book WHERE isbn='"+isbn+"';";
		    java.sql.ResultSet res = stmt.executeQuery(sql);
		    list.clear();
		    //5.打印结果集里的数
		    id="";
		    while(res.next()) {    
		    	Book b=new Book();
		    	b.authorid=res.getString("AuthorID");
		    	id=res.getString("AuthorID");
		    	b.isbn=res.getString("isbn");
		    	b.publishdate=res.getString("publishdate");
		    	b.publisher=res.getString("publisher");
		    	b.title=res.getString("title");
		    	b.price=res.getDouble("price");
		    	list.add(b);
		    }
		    sql = "select * from bookdb.author WHERE authorid='"+id+"';";
		    res = stmt.executeQuery(sql);
		    list2.clear();
		    //5.打印结果集里的数
		    while(res.next()) {    
		    	Author a=new Author();
		    	a.authorid=res.getString("AuthorID");
		    	a.name=res.getString("name");
		    	a.age=res.getString("age");
		    	a.country=res.getString("country");
		    	list2.add(a);
		    }
		    //测试插入数据库的功能：  
		    //String inSql = "insert into test(user,addr) values('插入2','新地址2')";  
		    //stmt.executeUpdate(inSql);  
		    res.close();  
		    stmt.close();  
		    conn.close();		
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;			
		}
	}
	

}
