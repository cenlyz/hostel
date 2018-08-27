package cn.lyz.hotle.qt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.qt.dao.BookDao;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Room;
import cn.lyz.hotle.qt.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Resource(name="bookDao")
	BookDao bookDao;
	
	public List<Room> findBookRoomType() {
		List<Room> list=bookDao.findBookRoomType();
		System.out.println(list);
		return list;
	}

	public void insertBook(BookRoom bookRoom) {
		if(bookRoom==null){
			throw new RuntimeException("Ԥ����ϢΪ��");
		}
		System.out.println(bookRoom.getBook_count()+"="+bookRoom.getBook_type());
		List<Room> room=bookDao.findRoomCount(bookRoom.getBook_type());
		System.out.println(room.size());
		if(room.size()<bookRoom.getBook_count()){
			throw new RuntimeException("�ͷ�Ԥ����������");
		}
		int num=bookDao.insertBook(bookRoom);
		if(num<1){
			throw new RuntimeException("�ͷ�Ԥ��ʧ��");
		}
		int bookId=bookDao.findMaxId();
				
		for(int i=0;i<bookRoom.getBook_count();i++){
			String roomId=room.get(i).getRoom_id();
			int row=bookDao.updateRoomID(roomId,bookId);
			if(row<1){
				throw new RuntimeException("�ͷ�Ԥ��ʧ��");
			}
		}
		
	}



}
