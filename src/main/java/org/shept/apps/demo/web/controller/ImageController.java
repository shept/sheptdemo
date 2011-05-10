package org.shept.apps.demo.web.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shept.apps.demo.orm.Person;
import org.shept.apps.demo.orm.dao.SheptDemoDao;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ImageController extends AbstractController {

	private SheptDemoDao dao;
	
	   @Override
	   protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		  
		  int id = ServletRequestUtils.getRequiredIntParameter(req, "id");
	      resp.setContentType("image/jpeg");
		  Person foundPerson = (Person) dao.getHibernateTemplateExtended().get(Person.class, id);
		  if (foundPerson != null) {
		      resp.getOutputStream().write(foundPerson.getImage());
		  }
	      return null;
	   }

	/**
	 * @param dao the dao to set
	 */
	@Resource
	public void setDao(SheptDemoDao dao) {
		this.dao = dao;
	}
}
