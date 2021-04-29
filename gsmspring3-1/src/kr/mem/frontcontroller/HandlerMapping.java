package kr.mem.frontcontroller;

import java.util.HashMap;

import kr.mem.controller.Controller;
import kr.mem.controller.MemberContentController;
import kr.mem.controller.MemberDeleteController;
import kr.mem.controller.MemberInsertController;
import kr.mem.controller.MemberListController;
import kr.mem.controller.MemberRegisterController;
import kr.mem.controller.MemberUpdateController;

public class HandlerMapping {
    private HashMap<String, Controller> mappings;
    public HandlerMapping() {
    	mappings=new HashMap<String, Controller>();
    	keyValueInit();
    }
    public void keyValueInit() {
    	mappings.put("/memberList.do", new MemberListController());
    	mappings.put("/memberDelete.do", new MemberDeleteController());
   	    mappings.put("/memberContent.do", new MemberContentController());
    	mappings.put("/memberUpdate.do", new MemberUpdateController());
    	mappings.put("/memberInsert.do", new MemberInsertController());
    	mappings.put("/memberInsertForm.do", new MemberRegisterController());
    }
    public Controller getController(String key) {
    	return mappings.get(key);
    }
}
/* 각 요청에 따른 작업하기(분기 작업)
if(command.equals("/memberList.do")) {
		controller=new MemberListController();				  	
}else if(command.equals("/memberDelete.do")) {
	    controller=new MemberDeleteController();		   	   
}else if(command.equals("/memberContent.do")) {
	    controller=new MemberContentController();		   	   
}else if(command.equals("/memberUpdate.do")) {
	    controller=new MemberUpdateController();		  	   	    
}else if(command.equals("/memberInsert.do")) {
	    controller=new MemberInsertController();		  	  
}else if(command.equals("/memberInsertForm.do")) {
	    controller=new MemberRegisterController();	
}*/