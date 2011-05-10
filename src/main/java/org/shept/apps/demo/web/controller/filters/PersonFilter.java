/**
 * 
 */
package org.shept.apps.demo.web.controller.filters;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.shept.persistence.provider.hibernate.HibernateCriteriaDefinition;
import org.shept.persistence.provider.hibernate.HibernateCriteriaFilter;
import org.springframework.beans.support.SortDefinition;
import org.springframework.util.StringUtils;


/**
 *  
 * @version $Rev: 74 $
 * @author Andreas Hahn
 *
 */
public class PersonFilter extends HibernateCriteriaFilter implements HibernateCriteriaDefinition, Serializable {
	
	/**
	 * A filter for finding persons by name and firstname.
	 * @see http://shept.org/docs/Demo1/Create_person
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String firstName;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.shept.apps.demo.web.controller.filter.DefaultCriteriaFilter#getCriteria(org.springframework.beans.support.SortDefinition)
	 */
	@Override
	public DetachedCriteria getCriteria(SortDefinition sortDefinition) {
		DetachedCriteria crit = super.getCriteria(sortDefinition);
		if (StringUtils.hasText(name)) {
			crit.add(Restrictions.ilike("name", "%"+name+"%"));
		}
		if (StringUtils.hasText(firstName)) {
			crit.add(Restrictions.ilike("firstName", "%"+firstName+"%"));
		}
		return crit;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
