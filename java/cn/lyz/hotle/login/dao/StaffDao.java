package cn.lyz.hotle.login.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.login.entity.Admin;
import cn.lyz.hotle.login.entity.Staff;

@Repository("staffDao")
@MyBatisRepository
public interface StaffDao {
	/** ��½*/ 
	Staff findStaffByUserName(@Param("username") String username);

	 /** ��ѯ�����û�*/
	 List<Staff> findStaffs();
	 /** �����û�����ѯ*/
	 List<Staff> findUserName(@Param("username") String username);
	 /** ����û�*/
	 int insertStaff(Staff staff);
	 /** ɾ���û�*/
	 int staffDelId(@Param("id") Integer id);
	 /** ����ɾ��*/
	 void staffDelIds(@Param("ids") String[] ids);
	 /** �޸��û�*/
	 int editStaff(Staff staff);
	 /** �޸�����*/
	 int changePwd(@Param("password") String password,@Param("id") Integer id);
	 Staff findByUsername(@Param("username") String username);
	 
}
