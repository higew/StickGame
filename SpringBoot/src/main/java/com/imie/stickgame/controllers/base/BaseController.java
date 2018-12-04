package com.imie.stickgame.controllers.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.imie.stickgame.database.base.DBItem;
import com.imie.stickgame.dtos.base.BaseDeleteCriteriaDTO;
import com.imie.stickgame.services.base.BaseService;

public abstract class BaseController<T extends DBItem> {

	private static final String BASE_ATTRIBUT_LIST = "items";
	private static final String BASE_ATTRIBUT = "item";
	
	protected abstract BaseService<T> getBaseService();
	protected abstract String getBaseURL();
	protected abstract String getBasePageName();
	protected abstract void setOtherAttributes(Model model);
	protected abstract void setupOtherFields(T item);

	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value= {"","/","/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute(BASE_ATTRIBUT_LIST,this.getBaseService().findAll());
		model.addAttribute("pageName",this.getBasePageName()+" index");
		model.addAttribute("baseUrl", this.getBaseURL());
		ArrayList<String> roles = new ArrayList<>();
        SecurityContext securityContext = SecurityContextHolder.getContext();
		Collection<? extends GrantedAuthority> role = securityContext.getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : role) {
            roles.add(grantedAuthority.getAuthority());
        }
        model.addAttribute("roles", roles);
		return this.getBaseURL()+"/index";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/delete/{id}"}, method=RequestMethod.GET)
	public String deleteId(Model model, @PathVariable Integer id) {
		this.getBaseService().deleteById(id);
		return "redirect:"+this.getBaseURL()+"/index";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/delete"}, method=RequestMethod.GET)
	public String deleteCriteria(Model model) {
		model.addAttribute("pageName",this.getBasePageName()+" suppression critere");
		return this.getBaseURL()+"/delete";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/delete"}, method=RequestMethod.POST)
	public String deleteCriteriaSearch(Model model, @ModelAttribute T item) {
		List<T> items = this.getBaseService().findWithCriteria(item);
		if (items.size() > 0) {
			model.addAttribute(BASE_ATTRIBUT_LIST,items);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName",this.getBasePageName()+" suppression critere");
		return this.getBaseURL()+"/delete";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/deletecriteria"}, method=RequestMethod.POST)
	public String deleteCriteriaDelete(@ModelAttribute BaseDeleteCriteriaDTO<T> form) {
		this.getBaseService().delete(form.getItems());
		return "redirect:"+this.getBaseURL()+"/delete";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value= {"/find"}, method=RequestMethod.GET)
	public String findCriteria(Model model) {
		model.addAttribute("pageName",this.getBasePageName()+" find criteria");
		return this.getBaseURL()+"/find";
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value= {"/find"}, method=RequestMethod.POST)
	public String findCriteriaSearch(Model model, @ModelAttribute T item) {
		List<T> trek = this.getBaseService().findWithCriteria(item);
		if (trek.size() > 0) {
			model.addAttribute(BASE_ATTRIBUT_LIST,trek);
		}else {
			model.addAttribute("notFound","No match");
		}
		
		model.addAttribute("pageName",this.getBasePageName()+" find criteria");
		return this.getBaseURL()+"/find";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/edit"}, method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("pageName",this.getBasePageName()+" create");
		model.addAttribute("detailPath",this.getBaseURL());
		this.setOtherAttributes(model);
		return this.getBaseURL()+"/edit";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/edit/{id}"}, method=RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id) {
		model.addAttribute(BASE_ATTRIBUT,this.getBaseService().find(id).get());
		model.addAttribute("pageName",this.getBasePageName()+" edit");
		return this.getBaseURL()+"/edit";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/edit"}, method=RequestMethod.POST)
	public String editSave(@ModelAttribute T item) {
		this.setupOtherFields(item);
		this.getBaseService().save(item);
		return "redirect:"+this.getBaseURL()+"/index";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value= {"/edit"}, method=RequestMethod.DELETE)
	public String editDelete() {
		return "redirect:"+this.getBaseURL()+"/index";
	}
}
