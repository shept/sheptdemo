/**
 * 
 */
package org.shept.apps.demo.orm.dao;

import java.io.ObjectStreamException;
import java.io.Serializable;

import org.shept.org.springframework.orm.hibernate3.support.HibernateDaoSupportExtended;


/**
 *  
 * @version $Rev: 73 $
 * @author Andreas Hahn
 *
 */
public class SheptDemoDao extends HibernateDaoSupportExtended implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * do not serialize / deserialize when parent objects require serialization
	 * 
	 * @throws ObjectStreamException
	 */
	protected Object writeReplace() throws ObjectStreamException{
		return null;
	}
	 
	/**
	 * do not serialize / deserialize when parent objects require serialization
	 * 
	 * @throws ObjectStreamException
	 */
	protected Object readResolve() throws ObjectStreamException {
		return null;
	}

}
