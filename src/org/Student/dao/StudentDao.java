package org.Student.dao;

import java.sql.*;
import java.util.ArrayList;

import org.Student.entity.Login;
import org.Student.entity.Student;

import java.util.List;

public class StudentDao {
	//修改密码
	public boolean changePwd(Login login) {
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="update users set password=? where name=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, login.getPwd());
			pstmt.setString(2, login.getName());
			
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//添加账号
	public boolean addUser(Login login) {
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="insert into users values(?,?)";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, login.getName());
			pstmt.setString(2, login.getPwd());
			
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//判断账号密码是否存在
	public boolean cheakName(Login login) {
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		ResultSet rs=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="select count(*) from users where name=? and password=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, login.getName());
			pstmt.setString(2, login.getPwd());
			
			rs=pstmt.executeQuery();
			
			int count=-1;
			if(rs.next()) {
				count=rs.getInt(1);
				if(count>0) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//判断此人是否存在
	public boolean isExist(int sno) {
		return queryStudentByno(sno)==null?false:true;
	}
		
	//根据学号删除学生
	public boolean deleteStudentByno(int sno) {
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="delete from student where no=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//根据学号修改学生
	public boolean updateStudentBySno(int sno,Student student) {
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="update student set name=?,age=?,address=? where no=?";
			pstmt=connection.prepareStatement(sql);
			//修改内容
			pstmt.setString(1, student.getName());
			pstmt.setInt(2, student.getAge());
			pstmt.setString(3, student.getAddress());
			//修改条件
			pstmt.setInt(4, sno);
			
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	//增加学生
	public boolean addStudent(Student student) {
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="insert into student values(?,?,?,?)";
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getAddress());
			
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	//查询全部
	public List<Student> queryAllStudents() {
		List<Student> students=new ArrayList<>();
		Student student=null;
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		ResultSet rs=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="select * from student";
			pstmt=connection.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
	
			while(rs.next()) {
				int no=rs.getInt("no");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String address=rs.getString("address");
				student=new Student(no,name,age,address);
				students.add(student);
			}
			return students;			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//根据学号查询
	public Student queryStudentByno(int sno){
		Student student=null;
		String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
		String USERNAME="root";
		String PWD="123456";
		PreparedStatement pstmt=null;
		Connection connection=null;
		ResultSet rs=null;
		try {
			//a、导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//加载具体的驱动
			//b、与数据库建立连接
			connection=DriverManager.getConnection(URL,USERNAME,PWD);
			String sql="select * from student where no=? ";
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			
			rs=pstmt.executeQuery();
	
			if(rs.next()) {
				int no=rs.getInt("no");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				String address=rs.getString("address");
				student=new Student(no,name,age,address);
			}
			return student;			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
