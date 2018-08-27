package cn.lyz.hotle.qt.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.service.MemberService;
import cn.lyz.hotle.web.JsonResult;

@Controller
@RequestMapping("/member/")
public class MemberController {
	private Logger log=Logger.getLogger(MemberController.class.getName());//��¼��־
	@Resource(name="memberServiceImpl")
	MemberService memberService;
	@RequestMapping("member.do")
	public String member(){
		return "qt/qt_member";
	}
	
	@RequestMapping("doGetProjectMember.do")
	@ResponseBody
	public JsonResult doGetProjectMember(String str){
		return new JsonResult(memberService.findMemberObjects(str));
	}
	
	@RequestMapping("doStateStop.do")
	@ResponseBody
	public JsonResult doStateStop(String m_state,Integer id){
		memberService.updateMemberState(m_state,id);
		return new JsonResult("�޸�״̬�ɹ�");
	}
	
	@RequestMapping("addMeber.do")
	@ResponseBody
	public JsonResult addMeber(Member m){
		
		if(!memberService.findMemberCount(m.getM_id())){
			return new JsonResult("��ԱID�Ѵ���");
		}
		memberService.saveMemberObjct(m);
		return new JsonResult("ok");
	}
	
	@RequestMapping("getMemberSearch.do")
	@ResponseBody
	public Map<String,Object> doGetPageObjects(String m_id,String check_tel,Integer pageCurrent){
		log.info("projectService="+memberService);//��¼��־
		System.out.println(m_id+"="+check_tel+"="+pageCurrent);
		Map<String,Object> map=memberService.findPageObjects(m_id, check_tel, pageCurrent);
		return map;//map����ת��Ϊjson���ı�ʾ��ʽ����
	}
	
	@RequestMapping("memberList.do")
	@ResponseBody
	public JsonResult memberList(String str){
		log.info("str="+str);//��¼��־
		List<Member> list=memberService.findMemberObjects(str);
		return new JsonResult(list);//map����ת��Ϊjson���ı�ʾ��ʽ����
	}
	
	@RequestMapping("updatDiscount.do")
	@ResponseBody
	public JsonResult updatDiscount(String type,String discount){
		log.info("type="+type+"---discount="+discount);//��¼��־
		memberService.updateDiscount(type, discount);
		return new JsonResult("ok");//map����ת��Ϊjson���ı�ʾ��ʽ����
	}
	
	
	
	
	
	
	
	
	
}


















