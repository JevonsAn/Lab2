package lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;

public class Lian {
	public java.sql.Connection connection() throws SQLException{
		try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {           
            e.printStackTrace();  
        }                    
		
        java.sql.Connection conn = java.sql.DriverManager.getConnection(  
                "jdbc:mysql://nkywraxknsjb.rds.sae.sina.com.cn:10584/bookdb?autoReconnect=true&useUnicode=true&characterEncoding=utf8",  
                "root", "19951224");
        java.sql.Statement stmt = conn.createStatement();
        String sql="select count(*) from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='bookdb' and TABLE_NAME = 'book';";
        //String sql2="select count(*) from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='bookdb' and TABLE_NAME = 'author';";
        String sqlcreate="CREATE TABLE `bookdb`.`book` (`isbn` VARCHAR(13) NOT NULL, `title` VARCHAR(100) NOT NULL, `authorid` VARCHAR(45) NOT NULL, `publisher` VARCHAR(100) NOT NULL,`publishdate` DATE NOT NULL,`price` DOUBLE NULL,PRIMARY KEY (`isbn`))ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;";
        String sqlcreate2="CREATE TABLE `bookdb`.`author` (";        
	        sqlcreate2+="`authorid` VARCHAR(45) NOT NULL,";
	        sqlcreate2+="`name` VARCHAR(100) NOT NULL,";
			sqlcreate2+="`age` INT(11) NULL,";
			sqlcreate2+="`country` VARCHAR(100) NULL,";
			sqlcreate2+="PRIMARY KEY (`authorid`))";
			sqlcreate2+="ENGINE = InnoDB  ";
			sqlcreate2+="DEFAULT CHARACTER SET = utf8;";
		String sqlcreate3="ALTER TABLE `bookdb`.`book` ";
			sqlcreate3+="ADD CONSTRAINT `FK`";
			sqlcreate3+="FOREIGN KEY (`authorid`)";
			sqlcreate3+="REFERENCES `bookdb`.`author` (`authorid`)";
			sqlcreate3+="ON DELETE CASCADE  ";
			sqlcreate3+="ON UPDATE CASCADE;";
        java.sql.ResultSet res = stmt.executeQuery(sql);
        int flag1=0;
        if (res.next())
        	flag1=res.getInt(1);
        
        if (flag1==0){
        	
        	stmt.execute(sqlcreate);
        	stmt.execute(sqlcreate2);
        	stmt.execute(sqlcreate3);
        	sql = "INSERT INTO bookdb.author(authorid,name,age,country) VALUES('1','易中天','40','中国');";
        	stmt.execute(sql);
        	sql = "INSERT INTO bookdb.book(isbn,title,authorid,publisher,publishdate,price) VALUES('9787533946012','大宋革新','1','浙江文艺出版社','2016-9-15',88.00);";
        	stmt.execute(sql);
        	sql = "INSERT INTO bookdb.book(isbn,title,authorid,publisher,publishdate,price) VALUES('9787533946013','大宋革新2','1','浙江文艺出版社','2016-9-16',88.00);";
        	stmt.execute(sql);
        }
        
         
        res.close();  
        stmt.close();  
        return conn;
        
	}

}
