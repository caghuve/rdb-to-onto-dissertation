package br.ufpr;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufpr.bean.Column;
import br.ufpr.bean.Record;

@Entity
@Table(name = "t023_column_record_value")
public class ColumnRecordValue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "c003_column_id", nullable = false)
	private Column column;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "c004_record_id", nullable = false)
	private Record record;
	
	@javax.persistence.Column(name = "c023_column_value", nullable = false)
	private String recordValue;
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if(!(o instanceof ColumnRecordValue)) {
			return false;
		}
		
		ColumnRecordValue other = (ColumnRecordValue) o;
		
	    if (this.column.getId() != other.column.getId()) {
	    	return false;
	    }
	    
	    if (this.record.getId() != other.record.getId()) {
	    	return false;
	    }

	    return true;
	}
	
	public int hashCode() {
	    return (int) this.column.getId().hashCode() * this.record.getId().hashCode();
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}	
}