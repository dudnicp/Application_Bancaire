package model;

import java.util.Date;

public class Document {
	private String name;
	private Date date;
	
	
	public Document(String name, Date date) {
		this.setName(name);
		this.date = new Date(date.getTime());
	}
	
	public Document(Document other) {
		this(other.name, other.date);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	/* public void afficher() {
		//TODO
	}*/
}
