package controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pojo.Items;
import pojo.QueryVo;
import service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/itemlist")
	public ModelAndView getItemList() throws Exception {

		List<Items> itemList = itemService.getItemList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", itemList);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}

	@RequestMapping(value = "/itemedit/{id}")
	public ModelAndView editItem(@PathVariable("id") Integer id,HttpServletRequest request) {
		
		Items items = itemService.getItemById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item", items);
		modelAndView.setViewName("editItem");
		return modelAndView;
	}

	
	//这里参数列表中必须有BindingResult这个参数，该参数用于验证请求
	@RequestMapping(value = "/updateitem", method = RequestMethod.POST)
	public String updateItems(Items items,BindingResult bindingResult,MultipartFile pic) throws Exception {
		// 把图片保存到图片的目录下
		// 保存图片，这个图片有的时候文件名可能会重复，你保存多了会把原来的图片给覆盖掉，这就不太合适了
		// 所以为每个文件生成一个新的文件名。
		String picName = UUID.randomUUID().toString();
		String oriName = pic.getOriginalFilename();
		if(pic != null && oriName != null && oriName.length()>0){
			String pic_path = "D:\\Server\\upload\\pic\\";
			String newFileName = UUID.randomUUID() + oriName.substring(oriName.lastIndexOf("."));
			File newFile = new File(pic_path+newFileName);
			pic.transferTo(newFile);
			items.setPic(newFileName);
		}else{
			Items temp = itemService.getItemById(items.getId());
			items.setPic(temp.getPic());
		}
		
		itemService.updateItems(items);
		return "forward:/itemedit";
	}

	@RequestMapping(value = "queryitem")
	public String queryItem(QueryVo queryVo, String[] ids) {
		// for(int x=0;x<queryVo.getIds().length;x++){
		// System.out.println(queryVo.getIds()[x].split(" ")[0]);
		// }
		System.out.println(queryVo.getItems().getId());
		System.out.println(queryVo.getItems().getName());
		return "success";
	}
	
	//JSON数据交互
	//@RequestBody：接收json数据并转换成pojo对象
	//@ResponseBody:响应json数据，把pojo对象转换成json数据并响应
	@RequestMapping(value="/json_test")
	@ResponseBody
	public Items jsonTest(@RequestBody Items items){
		System.out.println(items.getName());
		System.out.println(items.getPrice());
		return items;
	}
}
