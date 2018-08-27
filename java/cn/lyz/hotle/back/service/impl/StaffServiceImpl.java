package cn.lyz.hotle.back.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.back.service.StaffService;
import cn.lyz.hotle.login.dao.StaffDao;
import cn.lyz.hotle.login.entity.Staff;


@Service("staffServiceImpl")
public class StaffServiceImpl implements StaffService {
	@Resource(name="staffDao")
	StaffDao dao;
	
	public List<Staff> findStaffs() {
		return dao.findStaffs();
	}
	public  List<Staff> findUserName(String username) {
		return dao.findUserName(username);
	}
	public void insertStaff(Staff staff) {
		if(staff==null){
			throw new  RuntimeException("����û�����Ϊ��");
		}
		dao.insertStaff(staff);
		
	}
	public void staffDelId(Integer id) {
		if(id==null){
			throw new  RuntimeException("����û�idΪ��");
		}
		dao.staffDelId(id);
		
	}
	public void staffDelIds(String[] ids) {
		dao.staffDelIds(ids);
	}
	public void editStaff(Staff staff) {
		if(staff==null){
			throw new  RuntimeException("����û�����Ϊ��");
		}
		dao.editStaff(staff);
	}

}
