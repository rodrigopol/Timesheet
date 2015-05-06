package com.gft.timesheet.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface AddTimeEventHandler extends EventHandler{
	void onAddTime(AddTimeEvent event);
}