package cn.lyz.hotle.qt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.Discount;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Vip;
@Repository("memberDao")
@MyBatisRepository
public interface MemberDao {
	/** ��ѯ���л�Ա*/
	List<Member > findMemberObjects(@Param("str") String str);
	/** ����id��ѯ��Ա״̬*/
	Member findMemberState(@Param("id") Integer id);
	/** �޸Ļ�Ա״̬*/
	int updateMemberState(@Param("m_state") String m_state,@Param("id") Integer id);
	/** ��ӻ�Ա*/
	int saveMemberObjct(Member m);
	int getRowCount(@Param("m_id")String m_id,//��Ա��
			@Param("check_tel") String check_tel);
	/**
	 * name,//�û��������Ŀ��
	 * valid,//�û������״̬
	 * startIndex,//��ҳ��ʼλ��
	 * pageSize     //��ʾ����
	 */
	List<Member> findPageObjects(
			@Param("m_id")String m_id,//��Ա��
			@Param("check_tel") String check_tel,//�绰����
			@Param("startIndex")int startIndex,//��ҳ��ʼλ��
			@Param("pageSize")int pageSize     //��ʾ����
			);
	List<Vip> getMemberSearch();
	/** ��ѯ��ԱID�Ƿ����*/
	int findMemberCount(@Param("m_id")String m_id);
	/** ��ѯ��Ա�Ƿ���ڼ������Ϣ*/
	Member getMemberByIdAddTel(@Param("id") String id);
	/** ��ȡ�û�Ա���ۿ�*/
	Discount getDiscountByType(@Param("type") String type);
	/** ���ݻ�Ա�Ż���tel���»�Ա���*/
	int updatePriceById(@Param("id") String id,@Param("price") Double price,@Param("m_integral") Double m_integral);
	/** ���»�Ա�ۿ�*/
	int updateDiscount(@Param("type") String type, @Param("discount") String discount);
}
