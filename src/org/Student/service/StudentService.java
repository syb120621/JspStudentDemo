package org.Student.service;

import org.Student.dao.StudentDao;
import org.Student.entity.Login;
import org.Student.entity.Student;

import java.util.List;

//ҵ���߼��㣬�߼��Ե���ɾ�Ĳ飬��dao�������װ
public class StudentService {
	StudentDao studentDao=new StudentDao();
	//�޸�����
	public boolean changePwd(Login login) {
		if(!studentDao.cheakName(login)) {
			return studentDao.changePwd(login);
		}
			return false;
	}
	
	//ע��
	public boolean register(Login login) {
		if(!studentDao.cheakName(login)) {
			return studentDao.addUser(login);
		}
			return false;
	}
	
	//��¼
	public boolean login(Login login) {
		return studentDao.cheakName(login);
	}
	
	//����ѧ�Ų�ѯѧ��
	public Student queryStudentByNo(int sno) {
		return studentDao.queryStudentByno(sno);
	}
	
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	//����ѧ���޸�
	public boolean updateStudentByNo(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno,student);
		}
			return false;
	}
	
	//����ѧ��ɾ��
	public boolean deleteStudentByNo(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentByno(sno);
		}
			return false;
	}
	
	//����ѧ��
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getNo())){
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("�����Ѿ����ڣ�");
			return false;
		}
	}
}
