package cn.lyz.hotle.qt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Message;
import cn.lyz.hotle.qt.entity.Vip;

public interface MessageService {
	/** �������*/
	void insertMessage(Message message);
	/** ��ѯ����*/
	Message findMessage();
}
