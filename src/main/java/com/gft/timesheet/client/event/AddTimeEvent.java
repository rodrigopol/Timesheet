package com.gft.timesheet.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddTimeEvent extends GwtEvent<AddTimeEventHandler> {

	public static Type<AddTimeEventHandler> TYPE = new Type<AddTimeEventHandler>();
	
	@Override
	public Type<AddTimeEventHandler> getAssociatedType() {		
		return TYPE;
	}

	@Override
	protected void dispatch(AddTimeEventHandler handler) {
		handler.onAddTime(this);
		
	}

}
