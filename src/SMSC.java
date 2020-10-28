package API;


/**
 * Cache' Java Class Generated for class API.SMSC on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 * Description: СМС через сервис smsc.ru
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC</A>
**/

public class SMSC extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 1649;
    private static String CACHE_CLASS_NAME = "API.SMSC";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>API.SMSC.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public SMSC (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public SMSC (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "API.SMSC" in Cache
       database and corresponding object of class
       <code>API.SMSC</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public SMSC (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class API.SMSC as it is in
      Cache Database. Note, that this is a static method, so no
      object specific information can be returned. Use
      <code>getCacheClass().getName()</code> to get the class name
      for specific object.
       @return Cache class name as a <code>String</code>
      @see #getCacheClass()
      @see com.intersys.objects.reflect.CacheClass#getName()
     */
    public static String getCacheClassName( ) {
        return CACHE_CLASS_NAME;
    }

   /**
           Allows access metadata information about type of this object
           in Cache database. Also can be used for dynamic binding (accessing
           properties and calling methods without particular class known).

           @return <code>CacheClass</code> object for this object type.
   */
    public com.intersys.objects.reflect.CacheClass getCacheClass( ) throws com.intersys.objects.CacheException {
        return mInternal.getCacheClass();
    }

    public static void checkAllFieldsValid(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
    }

    /**
       Verifies that all fields from Cache class are exposed with
       accessor methods in Java class and that values for indexes in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p>But if there is any inconsistency in zObjVal indexes this is fatal and class can not work correctly and must be regenerated

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see com.intersys.objects.InvalidPropertyException

     */
    public static void checkAllMethods(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
        checkAllMethods(db, CACHE_CLASS_NAME, SMSC.class);
    }
    /**
     <p>Runs method %ClassName in Cache.</p>
     <p>Description: Returns the object's class name. The <var>fullname</var> determines how the
class name is represented. If it is 1 then it returns the full class name
including any package qualifier. If it is 0 (the default) then it returns the
name of the class without the package, this is mainly for backward compatibility
with the pre-package behaviour of %ClassName.</p>
     @param db represented as com.intersys.objects.Database
     @param fullname represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#%ClassName"> Method %ClassName</A>
    */
    public static java.lang.String sys_ClassName (com.intersys.objects.Database db, java.lang.Boolean fullname) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(fullname);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%ClassName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method %IsA in Cache.</p>
     <p>Description: Returns true (1) if instances of this class are also instances of the isclass parameter.
That is 'isclass' is a primary superclass of this object.</p>
     @param db represented as com.intersys.objects.Database
     @param isclass represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method DriverGPSMonitorGetForGeocooding in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#DriverGPSMonitorGetForGeocooding"> Method DriverGPSMonitorGetForGeocooding</A>
    */
    public static java.lang.String DriverGPSMonitorGetForGeocooding (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DriverGPSMonitorGetForGeocooding",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DriverGPSMonitorSetLocationName in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inName represented as java.lang.String
     @param inDsc represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#DriverGPSMonitorSetLocationName"> Method DriverGPSMonitorSetLocationName</A>
    */
    public static java.lang.String DriverGPSMonitorSetLocationName (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inName, java.lang.String inDsc) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        args[2] = new com.intersys.cache.Dataholder(inName);
        args[3] = new com.intersys.cache.Dataholder(inDsc);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DriverGPSMonitorSetLocationName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetDistanceForCalc in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#GetDistanceForCalc"> Method GetDistanceForCalc</A>
    */
    public static java.lang.String GetDistanceForCalc (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetDistanceForCalc",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetFCMMessages in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#GetFCMMessages"> Method GetFCMMessages</A>
    */
    public static java.lang.String GetFCMMessages (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetFCMMessages",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetMessages in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#GetMessages"> Method GetMessages</A>
    */
    public static java.lang.String GetMessages (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetMessages",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetMessagesForCheckStatus in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#GetMessagesForCheckStatus"> Method GetMessagesForCheckStatus</A>
    */
    public static java.lang.String GetMessagesForCheckStatus (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetMessagesForCheckStatus",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetDistance in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inClassID represented as java.lang.String
     @param inDistance represented as java.lang.String
     @param inStatus represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#SetDistance"> Method SetDistance</A>
    */
    public static java.lang.String SetDistance (com.intersys.objects.Database db, java.lang.String inClassID, java.lang.String inDistance, java.lang.String inStatus) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inClassID);
        args[1] = new com.intersys.cache.Dataholder(inDistance);
        args[2] = new com.intersys.cache.Dataholder(inStatus);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetDistance",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetSended in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inID represented as java.lang.String
     @param inCount represented as java.lang.String
     @param inCost represented as java.lang.String
     @param inBalance represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#SetSended"> Method SetSended</A>
    */
    public static void SetSended (com.intersys.objects.Database db, java.lang.String inID, java.lang.String inCount, java.lang.String inCost, java.lang.String inBalance) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inID);
        args[1] = new com.intersys.cache.Dataholder(inCount);
        args[2] = new com.intersys.cache.Dataholder(inCost);
        args[3] = new com.intersys.cache.Dataholder(inBalance);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetSended",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetStatus in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inID represented as java.lang.String
     @param inStatus represented as java.lang.String
     @param inLastDate represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.SMSC#SetStatus"> Method SetStatus</A>
    */
    public static void SetStatus (com.intersys.objects.Database db, java.lang.String inID, java.lang.String inStatus, java.lang.String inLastDate) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inID);
        args[1] = new com.intersys.cache.Dataholder(inStatus);
        args[2] = new com.intersys.cache.Dataholder(inLastDate);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetStatus",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
}
