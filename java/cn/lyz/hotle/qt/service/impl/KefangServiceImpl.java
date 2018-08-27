package cn.lyz.hotle.qt.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.back.dao.FinanceDao;
import cn.lyz.hotle.back.entity.Finance;
import cn.lyz.hotle.qt.dao.KefangDao;
import cn.lyz.hotle.qt.dao.MemberDao;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Check;
import cn.lyz.hotle.qt.entity.Hotel;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Room;
import cn.lyz.hotle.qt.service.KefangService;

@Service
public class KefangServiceImpl implements KefangService {
	@Resource(name="kefangDao")
	KefangDao kefangDao;
	@Resource(name="memberDao")
	MemberDao memberDao;
	
	@Resource(name="financeDao")
	FinanceDao financeDao;
	public List<Room> findRoomObjects(String site) {
		if(site==null){
			throw new RuntimeException("��¥��ͷ�Ϊ��");
		}
		return kefangDao.findRoomObjects(site);
	}
	public List<Room> findRoomSite() {
		return kefangDao.findRoomSite();
	}
	public Room findRoomById(Integer id) {
		if(id==null){
			throw new RuntimeException("��ѯ�ͷ�idΪ��");
		}
		return kefangDao.findRoomById(id);
	}
	public void insertCheck(Check check) {
		if(check==null){
			throw new RuntimeException("��ס��ϢΪ��");
		}
		check.setCheck_in_time(new Date());
		int row=kefangDao.insertCheck(check);
		if(row<1){
			throw new RuntimeException("��ס����ʧ��Ϊ��");
		}
		
		
	}
	public void updateRoom(String roomid) {
		if(roomid==null){
			throw new RuntimeException("�޸Ŀͷ���Ϊ��");
		}
		int row = kefangDao.updateRoom(roomid);
		if(row<1){
			throw new RuntimeException("�ͷ�״̬����ʧ��");
		}
		
	}
	public Map<String,Object> findcheckByIdAndRoom(Integer id,String room_id) {
		if(room_id==null){
			throw new RuntimeException("��ѯ�ͷ���Ϣ�ͷ���Ϊ��");
		}
		if(id==null){
			throw new RuntimeException("��ѯ�ͷ�idΪ��");
		}
		Check check=kefangDao.findcheckByIdAndRoom(room_id);
		Room room=kefangDao.findRoomById(id);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("check", check);
		map.put("room", room);
		
		return map;
	}
	public void updateRoomState(Integer id) {
		if(id==null){
			throw new RuntimeException("���¿ͷ�idΪ��");
		}
		int row=kefangDao.updateRoomState(id);
		if(row<1){
			throw new RuntimeException("�ͷ�״̬����ʧ��");
		}
		
	}
	public Check updateChecktate(String room_id,String id) {
		if(room_id==null){
			throw new RuntimeException("�޸Ŀͷ���Ϊ��");
		}
		Double discount=1.0;
		Double price=0.0;
		Double m_integral=0.0;

		Check c=kefangDao.findChecktimeAndMoney(room_id);//��ѯ��סʱ�� ����ס�ļ۸�
		Double money = c.getRoom_price();
		Date time = c.getCheck_in_time();
		Date time1=new Date();
		//����ʵ����ס������
		int day =  (int) Math.ceil((time1.getTime()-time.getTime())/24/60/60/1000);
		double money1 = (day+1)*money;
		Finance f=new Finance();
		f.setType("�ͷ�");
		f.setMoney(money1+"");
		f.setTime(time1);
		Calendar cal = Calendar.getInstance();
		int day1 = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		f.setYear(year);
		f.setMonth(month);
		f.setDay(day1);
		financeDao.updateFinace(f);// ��ӿͷ���ס���
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.format(time);
		Check CheckImpl=kefangDao.findcheckByIdAndRoom(room_id);//��ѯ��ǰ�ͷ���ס������Ϣ
		
	
		//�жϻ�Ա����Ƿ����
		int con=1;
		if(id!=null || id!=""){
			Member member = memberDao.getMemberByIdAddTel(id);
			discount=member.getM_discount();//��ȡ��Ա���ۿ�
			price = member.getM_price();
			m_integral = member.getM_integral();
			if(price<(money1*discount)){
				CheckImpl.setRemarke("��Ա���㣬��Ա�ֿ۽�� "+price+"Ԫ������֧����� "+((money1*discount)-price)+"Ԫ�����λ���"+(int)((money1*discount)/10)+" ��ǰ���� "+(m_integral+(int)((money1*discount)/10)));
				con = memberDao.updatePriceById(id, 0.0, (m_integral+(int)((money1*discount)/10)));
			}
			if(price >=(money1*discount)){
				CheckImpl.setRemarke("��Ա�ֿ۽�� "+(money1*discount)+"Ԫ��ʣ���� "+(price-(money1*discount))+"Ԫ�����λ���"+(int)((money1*discount)/10)+" ��ǰ���� "+(m_integral+(int)((money1*discount)/10)));
				con = memberDao.updatePriceById(id, (price-(money1*discount)), (m_integral+(int)((money1*discount)/10)));
			}
			if(con <1){
				throw new RuntimeException("��Ա�۸����ʧ��");
			}
		}
		CheckImpl.setCheck_price(money1*discount);//���ý�����
		System.out.println("money1*discount=="+money1*discount);
		System.out.println(CheckImpl.getRemarke());
		CheckImpl.setRtime(formatter.format(time));//ת����סʱ���ʽ
		int row=kefangDao.updateChecktate(room_id, new Date());
		int row1=kefangDao.updateRoomIdState(room_id);
		if(row<1&&row1<1){
			throw new RuntimeException("�˷�ʧ��");
		}
		return CheckImpl;
	}
	
	
	public Hotel findHotel() {
		
		return kefangDao.findHotel();
	}
	public List<Room> findRooms() {
		return kefangDao.findRooms();
	}
	public List<Room> findRoomsById(String room_id) {
		
		return kefangDao.findRoomsById(room_id);
	}
	public void insertRoom(Room room) {
		if(room==null){
			throw new RuntimeException("��ӿͷ���ϢΪ��");
		}
		int row = kefangDao.insertRoom(room);
		if(row<1){
			throw new RuntimeException("�ͷ���Ϣ���ʧ��");
		}
		
	}
	public void updateRoomById(Room room) {
		if(room==null){
			throw new RuntimeException("�޸Ŀͷ���ϢΪ��");
		}
		int row = kefangDao.updateRoomById(room);
		if(row<1){
			throw new RuntimeException("�ͷ���Ϣ�޸�ʧ��");
		}
	}
	public void roomDelById(Integer id) {
		if(id==null){
			throw new RuntimeException("ɾ���ͷ�idΪ��");
		}
		int row=kefangDao.roomDelById(id);
		if(row<1){
			throw new RuntimeException("�ͷ���Ϣɾ��ʧ��");
		}
		
	}
	
	public BookRoom findRoomByRoomId(String room_id) {
		if(room_id==null){
			throw new RuntimeException("�鿴Ԥ��������Ϣ�ͷ���Ϊ��");
		}
		return kefangDao.findRoomByRoomId(room_id);
	}
}
