package cn.lyz.hotle.back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.back.entity.Trade;

@Repository("tradeDao")
@MyBatisRepository
public interface TradeDao {
	/** ����ѯ*/
	List<Trade> findTradeObjects();
	/** ģ����ѯ*/
	List<Trade> findTradeByIdObjects(@Param("goods_id") String goods_id);
	/** �޸Ŀ��*/
	int editGoods(Trade trade);
	/** ��ӿ��*/
	int addGoods(Trade trade);
	/** ����IDɾ�����*/
	int delGoodsById(@Param("id") Integer id);
}
