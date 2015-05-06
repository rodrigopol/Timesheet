package com.gft.timesheet.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.tips.QuickTip;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.gft.timesheet.client.presenter.TimesPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TimesView extends Composite implements TimesPresenter.Display{
	
	final Grid<BaseModel> grdTimes;
	private static ListStore<BaseModel> listStore;
	private ColumnModel cm;
	
	final TreePanel<BaseTreeModel> treePanel;
	private TreeStore<BaseTreeModel> treeStore;
		
	private ContentPanel panel;
	private ContentPanel lcwest;  
	private ContentPanel lccenter;
	
	private ToolBar toolBar;
		
	public TimesView() {
		
		panel = new ContentPanel();    		   
		panel.setHeadingText("Time List");    
		panel.setWidth("100%");
		panel.setHeight(600);
		panel.setLayout(new BorderLayout());			
				 		
	    initWidget(panel);
	    
	    /*Toolbar*/
	    
	    toolBar = new ToolBar();
	    toolBar.add(new Button("Add", IconHelper.createStyle("add16")));
	    toolBar.setWidth("100%");
	    
	    panel.add(toolBar);
	    
	    
	    lcwest = new ContentPanel();
	    lcwest.setHeaderVisible(false);  
	    VBoxLayout westLayout = new VBoxLayout();  
	    westLayout.setPadding(new Padding(5));  
	    westLayout.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);  
	    lcwest.setLayout(westLayout);  
	    BorderLayoutData west = new BorderLayoutData(LayoutRegion.WEST, 150, 100, 250);  
	    west.setMargins(new Margins(35, 5, 5, 5));  
	    west.setSplit(true);  
	  
	    panel.add(lcwest, west);
	    
	    lccenter = new ContentPanel();
	    lccenter.setHeaderVisible(true);	    
	    lccenter.setLayout(new FitLayout());  	      
	    BorderLayoutData center = new BorderLayoutData(LayoutRegion.CENTER);  
	    center.setMargins(new Margins(35, 5, 5, 5));  
	    
	    panel.add(lccenter, center); 	    
	    
	    
	    /*Grid*/
	    
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
		listStore = new ListStore<BaseModel>();
									
	    ColumnConfig column = new ColumnConfig();
	   	    
	    column.setId("dtStart");  
	    column.setHeaderHtml("Start");  
	    column.setWidth(200);    
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("dtEnd");  
	    column.setHeaderHtml("End");  
	    column.setWidth(200);  
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("description");  
	    column.setHeaderHtml("Description");  
	    column.setWidth(400);  
	    configs.add(column); 
	  	
	    cm = new ColumnModel(configs);  
	    	
	    grdTimes = new Grid<BaseModel>(listStore, cm);
		
	    lccenter.add(grdTimes);
	     
		new QuickTip(grdTimes); 
		
		
		/*TreeView*/
		
		treeStore = new TreeStore<BaseTreeModel>();
		treePanel = new TreePanel<BaseTreeModel>(treeStore);
		treePanel.setDisplayProperty("teste");
		lcwest.add(treePanel);
	}
	
		
	
	public Widget asWidget() {
	    return this;
	  }


	@Override
	public void setDataGrid(BaseModel timeModel) {
		listStore.add(timeModel);			
	}


	@Override
	public void setDataTree(ModelData timeModel) {
		
		BaseTreeModel baseModel = new BaseTreeModel();
		
		baseModel.set("teste", "teste1");
		
		treeStore.add(baseModel, true);
				
	}



}
