package cn.lyz.hotle.back.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.login.entity.Staff;

public interface StaffService {
	/** ��ѯ�����û�*/
	List<Staff> findStaffs();
	 /** �����û�����ѯ*/
	 List<Staff> findUserName( String username);
	 /** ����û�*/
	 void insertStaff(Staff staff);
	 /** ɾ���û�*/
	 void staffDelId(Integer id);
	 /** ����ɾ��*/
	 void staffDelIds(String[] ids);
	 /** �޸��û�*/
	 void editStaff(Staff staff);
}
