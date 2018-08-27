package cn.lyz.hotle.qt.dao;

import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.Message;

@Repository("messageDao")
@MyBatisRepository
public interface MessageDao {
	/** �������*/
	int insertMessage(Message message);
	/** ��ѯ����*/
	Message findMessage();
}
