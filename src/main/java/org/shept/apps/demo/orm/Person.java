package org.shept.apps.demo.orm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.shept.persistence.ModelCreation;
import org.springframework.util.StringUtils;

/**
 * @version $$Id: $$
 *
 * @author Andi
 *
 */
@Entity
public class Person implements Serializable, ModelCreation {

/**
	 * 
	 */

private static final long serialVersionUID = 1L;

private Integer id;

private Integer version;

private String name;

private String firstName;

private Boolean male;

private Calendar birthdate;

private List<Address> addresses = new ArrayList<Address>();

private byte[] image;

/**
  * @return the id
  */
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
public Integer getId() {
 return id;
}

/**
  * @param id the id to set
  */
public void setId(Integer id) {
 this.id = id;
}

/**
  * @return the version
  */
@Version
public Integer getVersion() {
 return version;
}

/**
  * @param version the version to set
  */
public void setVersion(Integer version) {
 this.version = version;
}

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

/**
  * @return the male
  */
public Boolean getMale() {
 return male;
}

/**
  * @param male the male to set
  */
public void setMale(Boolean male) {
 this.male = male;
}

/**
  * @return the birthdate
  */
@Temporal(TemporalType.DATE)
public Calendar getBirthdate() {
 return birthdate;
}

/**
  * @param birthdate the birthdate to set
  */
public void setBirthdate(Calendar birthdate) {
 this.birthdate = birthdate;
}

/**
 * @return the image
 */
public byte[] getImage() {
	return image;
}

/**
 * @param image the image to set
 */
public void setImage(byte[] image) {
	this.image = image;		
}

/**
 * @return the image (file upload accessor)
 */
@Transient
public byte[] getUploadImage() {
	return image;
}

/**
 * @param image the image to set
 */
public void setUploadImage(byte[] image) {
	if (image != null && image.length > 0) {
		this.image = image;				
	}
}

/**
 * @return the delpic
 */
@Transient
public Boolean getDelpic() {
	return this.image == null;
}

/**
 * @param delpic the delpic to set
 * Transient - Annotation einf�gen !!!!!!!!!!!!!!!!!
 */

public void setDelpic(Boolean delpic) {
	if (delpic) this.image = null;
}

/**
 * @return the addresses
 */
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
public List<Address> getAddresses() {
	return addresses;
}

/**
 * @param addresses the addresses to set
 */
public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
}

public boolean isCreationAllowed(Object arg0) {
	Person person = (Person) arg0;
	if ( ! StringUtils.hasText(person.getName())) return false;
	if (StringUtils.hasText(name) && name.equalsIgnoreCase(person.getName())) {
		return false;
	}
	return true;
}

@Transient
public boolean isTransient() {
	return getId() == null;
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((male == null) ? 0 : male.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}

/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	if (birthdate == null) {
		if (other.birthdate != null)
			return false;
	} else if (!birthdate.equals(other.birthdate))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (male == null) {
		if (other.male != null)
			return false;
	} else if (!male.equals(other.male))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

}