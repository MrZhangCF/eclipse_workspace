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

	
	//��������б��б�����BindingResult����������ò���������֤����
	@RequestMapping(value = "/updateitem", method = RequestMethod.POST)
	public String updateItems(Items items,BindingResult bindingResult,MultipartFile pic) throws Exception {
		// ��ͼƬ���浽ͼƬ��Ŀ¼��
		// ����ͼƬ�����ͼƬ�е�ʱ���ļ������ܻ��ظ����㱣����˻��ԭ����ͼƬ�����ǵ�����Ͳ�̫������
		// ����Ϊÿ���ļ�����һ���µ��ļ�����
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
	
	//JSON���ݽ���
	//@RequestBody������json���ݲ�ת����pojo����
	//@ResponseBody:��Ӧjson���ݣ���pojo����ת����json���ݲ���Ӧ
	@RequestMapping(value="/json_test")
	@ResponseBody
	public Items jsonTest(@RequestBody Items items){
		System.out.println(items.getName());
		System.out.println(items.getPrice());
		return items;
	}
}
