package cn.lyz.hotle.qt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.execption.ServiceException;
import cn.lyz.hotle.qt.dao.MemberDao;
import cn.lyz.hotle.qt.entity.Discount;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Vip;
import cn.lyz.hotle.qt.service.MemberService;
import cn.lyz.hotle.web.PageObject;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource(name="memberDao")
	MemberDao dao;

	public List<Member> findMemberObjects(String str) {
		return dao.findMemberObjects(str);
	}

	public void updateMemberState(String m_state,Integer id) {
		if(id==null){
			throw new ServiceException("�޸Ļ�ԱidΪ��");
		}
		if(m_state==null){
			throw new ServiceException("�޸Ļ�Ա״̬Ϊ��");
		}
		Member m=dao.findMemberState(id);
		if(m_state.equals(m.getM_state())){
			throw new ServiceException("��Ա״̬����"+m_state+"״̬�����޸�");
		}
		int row = dao.updateMemberState(m_state, id);
		if(row<1){
			throw new ServiceException("�޸Ļ�Ա״̬ʧ��");
		}
	}

	public void saveMemberObjct(Member m) {
		if(m==null){
			throw new ServiceException("��ӻ�Ա��ϢΪ��");
		}
		m.setM_state("����");
		if(m.getM_price()<1000.0){
			m.setM_integral(10.0);
		}
		if(m.getM_price()>1000.0){
			m.setM_integral(500.0);
		}
		if(m.getM_price()==1000.0){
			m.setM_integral(100.0);
		}
		String type=m.getM_type();
		if(type!=null){
			Discount dis=dao.getDiscountByType(type);
			m.setM_discount(dis.getDiscount());
		}
		System.out.println(m.getM_integral());
		System.out.println(m.getM_discount());
		int row=dao.saveMemberObjct(m);
		if(row<1){
			throw new ServiceException("��ӻ�Աʧ��");
		}
		
	}

	public Map<String, Object> findPageObjects(String id, String tel, int pageCurrent) {
		PageObject pageObject=new PageObject();
		int pageSize=7;//��ʾ����
		int startIndex=(pageCurrent-1)*pageSize;
		//��ȡ��ǰҳ����
		List<Member> list=dao.findPageObjects(id, tel, startIndex, pageSize);
		System.out.println("list=="+list);
		int rowCount=dao.getRowCount(id, tel);//��ȡ����¼����
		//��ȡ�ܼ�¼������װ��ҳ��Ϣ
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		//��װ��map
		System.out.println(rowCount);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list",list);
		map.put("pageObject", pageObject);
		return  map;
	}

	public List<Vip> getMemberSearch() {
		
		return dao.getMemberSearch();
	}

	public boolean findMemberCount(String m_id) {
		if(m_id==null){
			throw new ServiceException("��ӻ�ԱIDΪ��");
		}
		System.out.println("m_id==="+m_id);
		int row=dao.findMemberCount(m_id);
		System.out.println(row);
		if(row<1){
			return true;
		}
		return false;
	}

	public Member getMemberByIdAddTel(String id) {

		return dao.getMemberByIdAddTel(id);
	}

	public void updateDiscount(String type, String discount) {
		if(type==null){
			throw new ServiceException("�޸��ۿۻ�Ա����Ϊ��");
		}
		if(discount==null){
			throw new ServiceException("�޸��ۿ�Ϊ��");
		}
		int row=dao.updateDiscount(type, discount);
		if(row<1){
			throw new ServiceException("�޸��ۿ�ʧ��");
		}
		
	}

	
}
