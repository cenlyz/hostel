package cn.lyz.hotle.back.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.back.dao.TradeDao;
import cn.lyz.hotle.back.entity.Trade;
import cn.lyz.hotle.back.service.TradeService;

@Service("tradeServiceImpl")
public class TradeServiceImpl implements TradeService {
	@Resource(name="tradeDao")
	TradeDao dao;

	public List<Trade> findTradeObjects() {
		return dao.findTradeObjects();
	}

	public List<Trade> findTradeByIdObjects(String goods_id) {
		if(goods_id==null){
			throw new RuntimeException("��ѯ����Ϊ��");
		}
		return dao.findTradeByIdObjects(goods_id);
	}

	public void editGoods(Trade trade) {
		if(trade==null){
			throw new RuntimeException("�޸�����Ϊ��");
		}
		int row=dao.editGoods(trade);
		if(row<1){
			throw new RuntimeException("�޸Ŀ��ʧ��");
		}
		
	}

	public void addGoods(Trade trade) {
		if(trade==null){
			throw new RuntimeException("�޸�����Ϊ��");
		}
		int row=dao.addGoods(trade);
		if(row<1){
			throw new RuntimeException("�޸Ŀ��ʧ��");
		}
		
	}

	public void delGoodsById(Integer id) {
		if(id==null){
			throw new RuntimeException("Ҫɾ�����idΪ��");
		}
		int row=dao.delGoodsById(id);
		if(row<1){
			throw new RuntimeException("ɾ�����ʧ��");
		}
		
	}
	
}
