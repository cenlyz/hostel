package cn.lyz.hotle.back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.back.entity.Finance;

@Repository("financeDao")
@MyBatisRepository
public interface FinanceDao {
	List<Finance> findFinanceList(@Param("year") String year,
			@Param("month") String month,
			@Param("day") String day);
	List<Finance> findFinanceTime();
	/** ��״ͼ����*/
	List<Finance> findFinanceMonth(@Param("year") Integer year);
	/** ����ͼ*/
	List<Finance> findFinanceYearMonth(@Param("year") Integer year,
			@Param("month") Integer month);
	/** ��ӿͷ���ס���*/
	int updateFinace(Finance f);
}
