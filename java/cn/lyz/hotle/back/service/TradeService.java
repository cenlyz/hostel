package cn.lyz.hotle.back.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.back.entity.Trade;

public interface TradeService {
	/** ����ѯ*/
	List<Trade> findTradeObjects();
	/** ģ����ѯ*/
	List<Trade> findTradeByIdObjects( String goods_id);
	/** �޸Ŀ��*/
	void editGoods(Trade trade);
	/** ��ӿ��*/
	void addGoods(Trade trade);
	/** ����IDɾ�����*/
	void delGoodsById(@Param("id") Integer id);
}
