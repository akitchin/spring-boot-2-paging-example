package com.hazmit.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AttributeController {
	
	@Autowired
	AttributeService attributeService;
	
	@RequestMapping(value="/v1/source/attribute",method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	Slice<AttributeResponse> list(Pageable pageable){
		return attributeService.listAllByPage(pageable);
	} 

}
