package cn.lyz.hotle.qt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Room;

public interface BookService {
	/**��ѯ�ͷ�����*/
	 List<Room> findBookRoomType();
	 /**�ͷ�Ԥ��*/
	 void insertBook(BookRoom bookRoom);

}
