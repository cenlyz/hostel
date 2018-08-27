package cn.lyz.hotle.login.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.login.entity.Admin;

@Repository("adminDao")
@MyBatisRepository
public interface AdminDao {
	/** ��½*/ 
	Admin findAdminByUserName(@Param("username") String username);
	/** ������Ϣ*/
	int updateAdminUser(Admin admin);
	/***/
	int changePwd(@Param("password") String password,
			@Param("username") String username);
	/** �һ�����*/
	public Admin findByUsername(String id);
}
