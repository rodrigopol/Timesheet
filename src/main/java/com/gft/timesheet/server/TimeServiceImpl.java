package com.gft.timesheet.server;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gft.timesheet.shared.Time;
import com.gft.timesheet.shared.TimeService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TimeServiceImpl extends RemoteServiceServlet implements TimeService{

	@Override
	public List<Time> getTimes() {
		
		List<Time> listTime = new ArrayList<Time>();
		
		for(int i = 0; i<10; i++)
		{
			listTime.add(new Time(i, new Date(), new Date(), "Desc " + i));
		}
		
		return listTime;
		
	}

}
