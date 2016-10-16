package lab2;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
public class SelectSql extends ActionSupport{
	private List<Book> list=new ArrayList<Book>();
	private int i;
	private String isbn;
	public List<Book> getList(){
		return list;
	}
	public String execute(){
		try{
			Lian newl=new Lian();	
			java.sql.Connection conn=newl.connection();
		    java.sql.Statement stmt = conn.createStatement();
		    String sql = "select * from bookdb.book";
		    java.sql.ResultSet res = stmt.executeQuery(sql);
		    list.clear();
		    try{
			    while(res.next()) {    
			    	Book b=new Book();
			    	b.authorid=res.getString("AuthorID"); 
			    	b.isbn=res.getString("isbn");
			    	b.publishdate=res.getString("publishdate");
			    	b.publisher=res.getString("publisher");
			    	b.title=res.getString("title");
			    	b.price=res.getDouble("price");
			    	list.add(b);
			    }
			    sql = "select count(*) from bookdb.book";
			    res = stmt.executeQuery(sql);
			    if (res.next())
			    	setI(res.getInt(1));
		    }		    
		    catch(Exception e){
		    	return ERROR;
		    }
		    res.close();  
		    stmt.close();  
		    conn.close();		
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;			
		}
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String delete(){
		try{
			Lian newl=new Lian();			
			//3获取表达式SQL  
			java.sql.Connection conn=newl.connection();
		    java.sql.Statement stmt = conn.createStatement();  
		    //4.执行SQL  
		    String sql = "DELETE FROM bookdb.book WHERE isbn='"+isbn+"';";
		    stmt.execute(sql);
		    sql = "select * from bookdb.book";
		    java.sql.ResultSet res = stmt.executeQuery(sql);
		    //5.打印结果集里的数
		    try{
			    while(res.next()) {    
			    	Book b=new Book();
			    	b.authorid=res.getString("AuthorID"); 
			    	b.isbn=res.getString("isbn");
			    	b.publishdate=res.getString("publishdate");
			    	b.publisher=res.getString("publisher");
			    	b.title=res.getString("title");
			    	b.price=res.getDouble("price");
			    	list.add(b);
			    }
			    sql = "select count(*) from bookdb.book";
			    res = stmt.executeQuery(sql);
			    if (res.next())
			    	setI(res.getInt(1));
		    }		    
		    catch(Exception e){
		    	return ERROR;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}

}
