package com.niit.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller
public class CategoryController
{

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		List<Category> listCategories=categoryDAO.listCategories();
		
		m.addAttribute("categoryList", listCategories);
		
		return "category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String saveCategoryDetail(@RequestParam("catName")String categoryname,@RequestParam("catDesc") String categoryDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryname(categoryname);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.addCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		
		return "category";
	}
	
	@RequestMapping(value="/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id")int id,Model m)
	{
		Category category=categoryDAO.getCategory(id);
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		
		return "category";
	}
	
	@RequestMapping(value="/editCategory/{id}")
	public String editCategory(@PathVariable("id")int id,Model m)
	{
		Category category=categoryDAO.getCategory(id);
		m.addAttribute(category);
		return "updatecategory";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	 public String UpdateCategory(Model m,@RequestParam("catId")int id,@RequestParam("catName")String categoryname,@RequestParam("catDesc")String categoryDesc)
	 {
		 Category category=categoryDAO.getCategory(id);
		 category.setCategoryname(categoryname);
		 category.setCategoryDesc(categoryDesc);
		 categoryDAO.updateCategory(category);
		 List<Category> listCategories=categoryDAO.listCategories();
		 m.addAttribute("categoryList",listCategories);
		 return "category";
	 }

	
}
