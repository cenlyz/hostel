package cn.lyz.hotle.qt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Check;
import cn.lyz.hotle.qt.entity.Hotel;
import cn.lyz.hotle.qt.entity.Room;

public interface KefangService {
	List<Room> findRoomObjects(String site);
	List<Room> findRoomSite();
	Room findRoomById(Integer id);
	void insertCheck(Check check);
	void updateRoom( String roomid);
	Map<String, Object> findcheckByIdAndRoom(Integer id, String room_id);
	void updateRoomState(Integer id);
	/** ���¿�����ס״̬*/
	Check updateChecktate(String room_id,String id);
	/** ��ѯ�Ƶ���Ϣ*/
	Hotel findHotel();
	/** ��ѯ���пͷ���Ϣ*/
	List<Room> findRooms();
	/** ���߿ͷ��Ų�ѯ�ͷ���Ϣ*/
	List<Room> findRoomsById(String room_id);
	/** ��ӿͷ���Ϣ*/
	void insertRoom(Room room);
	/** �޸Ŀͷ���Ϣ*/
	void updateRoomById(Room room);
	/** ɾ���ͷ���Ϣ*/
	void roomDelById( Integer id);
	/** ��ѯԤ����Ϣ*/
	BookRoom findRoomByRoomId(String room_id);

}
