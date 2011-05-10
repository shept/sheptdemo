/**
 * 
 */
package org.shept.apps.demo.web.controller.filters;

import java.io.Serializable;

import org.shept.persistence.ModelCreation;
import org.shept.persistence.provider.hibernate.HibernateCriteriaDefinition;
import org.shept.persistence.provider.hibernate.HibernateCriteriaFilter;


/**
 *  
 * @version $Rev: 74 $
 * @author Andreas Hahn
 *
 */
public class AddressFilter extends HibernateCriteriaFilter implements HibernateCriteriaDefinition, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ModelCreation getNewModelTemplate() {
		return null;
	}

}
