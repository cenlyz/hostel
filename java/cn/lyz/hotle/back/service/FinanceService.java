package cn.lyz.hotle.back.service;

import java.util.List;


import cn.lyz.hotle.back.entity.Finance;

public interface FinanceService {
	/** ��ѯ����*/
	List<Finance> findFinanceList( String year,String month, String day);
	/** ͼ�α���*/
	List<Finance> findFinanceTime();
	/** ��״ͼ����*/
	List<Finance> findFinanceMonth( Integer year);
	/** ����ͼ
	 * @throws Exception */
	List<Finance> findFinanceYearMonth(Integer year, Integer month) throws Exception;
}
