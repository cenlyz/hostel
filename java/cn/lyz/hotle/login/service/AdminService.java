package cn.lyz.hotle.login.service;


import cn.lyz.hotle.login.entity.Admin;

public interface AdminService {
	/** ��½*/ 
	String findAdminByUserName(String username,String password);
	Admin findAdmin(String username);
	/** ������Ϣ*/
	String updateAdminUser(Admin admin);
	/** �޸�����*/
	String changePwd(String password,String username);
	/** �һ�����*/
	public Admin findByUsername(String id);
}
