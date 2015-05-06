package com.gft.timesheet.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Time_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDescription(com.gft.timesheet.shared.Time instance) /*-{
    return instance.@com.gft.timesheet.shared.Time::description;
  }-*/;
  
  private static native void setDescription(com.gft.timesheet.shared.Time instance, java.lang.String value) 
  /*-{
    instance.@com.gft.timesheet.shared.Time::description = value;
  }-*/;
  
  private static native java.util.Date getDtEnd(com.gft.timesheet.shared.Time instance) /*-{
    return instance.@com.gft.timesheet.shared.Time::dtEnd;
  }-*/;
  
  private static native void setDtEnd(com.gft.timesheet.shared.Time instance, java.util.Date value) 
  /*-{
    instance.@com.gft.timesheet.shared.Time::dtEnd = value;
  }-*/;
  
  private static native java.util.Date getDtStart(com.gft.timesheet.shared.Time instance) /*-{
    return instance.@com.gft.timesheet.shared.Time::dtStart;
  }-*/;
  
  private static native void setDtStart(com.gft.timesheet.shared.Time instance, java.util.Date value) 
  /*-{
    instance.@com.gft.timesheet.shared.Time::dtStart = value;
  }-*/;
  
  private static native int getId(com.gft.timesheet.shared.Time instance) /*-{
    return instance.@com.gft.timesheet.shared.Time::id;
  }-*/;
  
  private static native void setId(com.gft.timesheet.shared.Time instance, int value) 
  /*-{
    instance.@com.gft.timesheet.shared.Time::id = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.gft.timesheet.shared.Time instance) throws SerializationException {
    setDescription(instance, streamReader.readString());
    setDtEnd(instance, (java.util.Date) streamReader.readObject());
    setDtStart(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readInt());
    
    com.extjs.gxt.ui.client.data.BaseModel_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.gft.timesheet.shared.Time instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gft.timesheet.shared.Time();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gft.timesheet.shared.Time instance) throws SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeObject(getDtEnd(instance));
    streamWriter.writeObject(getDtStart(instance));
    streamWriter.writeInt(getId(instance));
    
    com.extjs.gxt.ui.client.data.BaseModel_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gft.timesheet.shared.Time_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gft.timesheet.shared.Time_FieldSerializer.deserialize(reader, (com.gft.timesheet.shared.Time)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gft.timesheet.shared.Time_FieldSerializer.serialize(writer, (com.gft.timesheet.shared.Time)object);
  }
  
}
