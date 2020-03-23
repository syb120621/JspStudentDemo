package org.Student.service;

import org.Student.dao.StudentDao;
import org.Student.entity.Login;
import org.Student.entity.Student;

import java.util.List;

//业务逻辑层，逻辑性的增删改查，对dao层进行组装
public class StudentService {
	StudentDao studentDao=new StudentDao();
	//修改密码
	public boolean changePwd(Login login) {
		if(!studentDao.cheakName(login)) {
			return studentDao.changePwd(login);
		}
			return false;
	}
	
	//注册
	public boolean register(Login login) {
		if(!studentDao.cheakName(login)) {
			return studentDao.addUser(login);
		}
			return false;
	}
	
	//登录
	public boolean login(Login login) {
		return studentDao.cheakName(login);
	}
	
	//根据学号查询学生
	public Student queryStudentByNo(int sno) {
		return studentDao.queryStudentByno(sno);
	}
	
	//查询全部学生
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	//根据学号修改
	public boolean updateStudentByNo(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno,student);
		}
			return false;
	}
	
	//根据学号删除
	public boolean deleteStudentByNo(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentByno(sno);
		}
			return false;
	}
	
	//增加学生
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getNo())){
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("此人已经存在！");
			return false;
		}
	}
}
