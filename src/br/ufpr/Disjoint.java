package br.ufpr;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t017_disjoint_class")
public class Disjoint implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "c011_class_id")
	private br.ufpr.bean.Class classD;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "c011_disjoint_class_id")
	private br.ufpr.bean.Class disjointClass;
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if(!(o instanceof Disjoint)) {
			return false;
		}
		
		Disjoint other = (Disjoint) o;
		
	    if (this.classD.getId() != other.classD.getId()) {
	    	return false;
	    }
	    
	    if (this.disjointClass.getId() != other.disjointClass.getId()) {
	    	return false;
	    }

	    return true;
	}
	
	public int hashCode() {
	    return (int) this.classD.getId().hashCode() * this.disjointClass.getId().hashCode();
	}

	public br.ufpr.bean.Class getClassD() {
		return classD;
	}

	public void setClassD(br.ufpr.bean.Class classD) {
		this.classD = classD;
	}

	public br.ufpr.bean.Class getDisjointClass() {
		return disjointClass;
	}

	public void setDisjointClass(br.ufpr.bean.Class disjointClass) {
		this.disjointClass = disjointClass;
	}
	

}