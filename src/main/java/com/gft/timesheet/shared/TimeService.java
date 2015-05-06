package com.gft.timesheet.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("times")
public interface TimeService extends RemoteService{

	List<Time> getTimes();
	
}
