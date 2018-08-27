package cn.lyz.hotle.qt.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Check;
import cn.lyz.hotle.qt.entity.Hotel;
import cn.lyz.hotle.qt.entity.Room;

@Repository("kefangDao")
@MyBatisRepository
public interface KefangDao {
	/** ��ѯ���пͷ���Ϣ*/
	List<Room> findRoomObjects(@Param("room_site") String room_site);
	/** ��ѯ���пͷ������ڵ�¥����Ϣ*/
	List<Room> findRoomSite();
	/** ��ѯ���пͷ���Ϣ*/
	List<Room> findRooms();
	/** ����id��ѯ�ͷ���Ϣ*/
	Room findRoomById(@Param("id") Integer id);
	/** ���߿ͷ��Ų�ѯ�ͷ���Ϣ*/
	List<Room> findRoomsById(@Param("room_id") String room_id);
	/** ���߿ͷ��Ų�ѯԤ����Ϣ*/
	BookRoom findRoomByRoomId(@Param("room_id") String room_id);
	/** ��ӿ�����ס��Ϣ*/
	
	int insertCheck(Check check);
	/** ���¿ͷ�Ϊ��ס״̬*/
	int updateRoom(@Param("room_id") String room_id);
	/** ��ѯ��ǰ�ͷ���ס������Ϣ*/
	Check findcheckByIdAndRoom(@Param("room_id") String room_id);
	/** ����id���·���״̬Ϊ�շ�״̬*/
	int updateRoomState(@Param("id") Integer id);
	/** ���߿ͷ��Ÿ��·���Ϊ�շ�״̬*/
	int updateRoomIdState(@Param("room_id") String room_id);
	/** �����˷��Ը���Check*/
	int updateChecktate(@Param("room_id") String room_id,@Param("time") Date time);
	/** ��ѯ�Ƶ���Ϣ*/
	Hotel findHotel();
	/** ��ӿͷ���Ϣ*/
	int insertRoom(Room room);
	/** �޸Ŀͷ���Ϣ*/
	int updateRoomById(Room room);
	/** ɾ���ͷ���Ϣ*/
	int roomDelById(@Param("id") Integer id);
	/** ��ѯ��סʱ�� ����ס�ļ۸�*/
	Check findChecktimeAndMoney(@Param("room_id") String room_id);

}
