package cn.lyz.hotle.qt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Room;

@Repository("bookDao")
@MyBatisRepository
public interface BookDao {
	 List<Room> findBookRoomType();
	 int insertBook(BookRoom bookRoom);
	 /** ��ѯԤ���������͵�����*/
	 List<Room> findRoomCount(@Param("type") String type);
	 /** ����Ԥ��״̬*/
	 int updateRoomID(@Param("roomId") String roomId,@Param("bookId") Integer bookId);
	 
	 int findMaxId();
}
