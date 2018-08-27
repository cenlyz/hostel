package cn.lyz.hotle.qt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Vip;

public interface MemberService {
	/** ��ѯ���л�Ա*/
	List<Member> findMemberObjects(String str);
	/** �޸Ļ�Ա״̬*/
	void updateMemberState(String m_state, Integer id);
	/** ��ӻ�Ա*/
	void saveMemberObjct(Member m);
	/**��ҳ��ѯ����*/
	Map<String,Object> findPageObjects(String m_id, String check_tel, int pageCurrent);
	
	/** ��ѯ���л�Ա*/
	List<Vip> getMemberSearch();
	/** ��ѯ��ԱID�Ƿ����*/
	boolean findMemberCount(String m_id);
	/** ��ѯ��Ա�Ƿ����*/
	Member getMemberByIdAddTel(String id);
	/** ���»�Ա�ۿ�*/
	void updateDiscount( String type,  String discount);
}
