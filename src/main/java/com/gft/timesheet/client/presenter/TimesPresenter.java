package com.gft.timesheet.client.presenter;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.gft.timesheet.shared.Time;
import com.gft.timesheet.shared.TimeServiceAsync;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class TimesPresenter implements Presenter{
	
	  public interface Display {		    
		    void setDataGrid(BaseModel timeModel);
		    void setDataTree(ModelData timeModel);
		    Widget asWidget();
		  }
	  
	  private final TimeServiceAsync timeService;
	  private final HandlerManager eventBus;
	  private final Display display;
	  
	  public TimesPresenter(TimeServiceAsync timeService, HandlerManager eventBus, Display view) {
		this.timeService = timeService;
		this.eventBus = eventBus;
		this.display = view;
	  }
	 
	  
	  private void fetchTimes(){
		  timeService.getTimes(new AsyncCallback<List<Time>>() {
			
			@Override
			public void onSuccess(List<Time> result) {
				
				for(Time time : result)
				{
					BaseModel timeModel = new BaseModel();
					
					timeModel.set("dtStart", DateTimeFormat.getFormat("dd/mm/yyyy HH:mm:ss").format(time.getDtStart()));
					timeModel.set("dtEnd", DateTimeFormat.getFormat("dd/mm/yyyy HH:mm:ss").format(time.getDtEnd()));
					timeModel.set("description", time.getDescription());
				
					display.setDataGrid(timeModel);										
				}
				
				display.setDataTree(new BaseModel());
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
				Window.alert(caught.getMessage());
				
			}
		});
	  }
	
	@Override
	public void go(HasWidgets container) {		
	    container.clear();
	    container.add(display.asWidget());
	    fetchTimes();		
	}

}
