package com.gft.timesheet.shared;

import java.io.Serializable;
import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;


@SuppressWarnings("serial")
public class Time extends BaseModel implements Serializable{
	
	private int id;
	
	private Date dtStart;
	
	private Date dtEnd;
	
	private String description;
	
	public Time(){
		
	}
	
	public Time(int id, Date dtStart, Date dtEnd, String description){
		this.setId(id);
		this.setDtStart(dtStart);
		this.setDtEnd(dtEnd);
		this.setDescription(description);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDtStart() {
		return dtStart;
	}

	public void setDtStart(Date dtStart) {
		this.dtStart = dtStart;
	}

	public Date getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
