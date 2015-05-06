package com.gft.timesheet.client;

import com.gft.timesheet.client.event.AddTimeEvent;
import com.gft.timesheet.client.event.AddTimeEventHandler;
import com.gft.timesheet.client.presenter.Presenter;
import com.gft.timesheet.client.presenter.TimesPresenter;
import com.gft.timesheet.client.view.TimesView;
import com.gft.timesheet.shared.TimeServiceAsync;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String>{

	private final TimeServiceAsync timeService; 
	private final HandlerManager eventBus;
	private HasWidgets container;
	
	
	public AppController(TimeServiceAsync timeService, HandlerManager eventBus) {
	
		this.timeService = timeService;
		this.eventBus = eventBus;
		bind();
	}
	
	private void bind(){
		History.addValueChangeHandler(this);
		
		eventBus.addHandler(AddTimeEvent.TYPE, new AddTimeEventHandler() {
			
			@Override
			public void onAddTime(AddTimeEvent event) {
				History.newItem("add");				
			}
		});
	}
	
	@Override
	public void go(HasWidgets container) {	
		this.container = container;
	    
	    if ("".equals(History.getToken())) {
	      History.newItem("list");
	    }
	    else {
	      History.fireCurrentHistoryState();
	    }
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		
		 String token = event.getValue();
		    
		    if (token != null) {
		      Presenter presenter = null;

		      if (token.equals("list")) {
		        presenter = new TimesPresenter(timeService, eventBus, new TimesView());
		      }
		     
		      if (presenter != null) {
		        presenter.go(container);
		      }
		    }
	}

}
