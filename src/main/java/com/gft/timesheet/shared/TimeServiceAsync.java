package com.gft.timesheet.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TimeServiceAsync {
	
	void getTimes(AsyncCallback<List<Time>> callback);
	
}
