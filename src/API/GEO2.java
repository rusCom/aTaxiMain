package API;


/**
 * Cache' Java Class Generated for class API.GEO2 on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2</A>
**/

public class GEO2 extends API.JSON implements java.io.Serializable {
    private static final long serialVersionUID = 5560;
    private static String CACHE_CLASS_NAME = "API.GEO2";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>API.GEO2.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public GEO2 (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public GEO2 (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "API.GEO2" in Cache
       database and corresponding object of class
       <code>API.GEO2</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public GEO2 (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class API.GEO2 as it is in
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
        checkAllMethods(db, CACHE_CLASS_NAME, GEO2.class);
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method Answer in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param GUID represented as java.lang.String
     default argument inCode set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Answer(com.intersys.objects.Database,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#Answer"> Method Answer</A>
    */
    public static void Answer (com.intersys.objects.Database db, java.lang.String GUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(GUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Answer",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method Answer in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param GUID represented as java.lang.String
     @param inCode represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#Answer"> Method Answer</A>
    */
    public static void Answer (com.intersys.objects.Database db, java.lang.String GUID, java.lang.String inCode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(GUID);
        args[1] = new com.intersys.cache.Dataholder(inCode);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Answer",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method Distance in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     default argument inBlunder set to 0.5
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Distance(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#Distance"> Method Distance</A>
    */
    public static java.lang.String Distance (com.intersys.objects.Database db, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[1] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[2] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Distance",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Distance in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     @param inBlunder represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#Distance"> Method Distance</A>
    */
    public static java.lang.String Distance (com.intersys.objects.Database db, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude, java.lang.String inBlunder) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[1] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[2] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLongitude);
        args[4] = new com.intersys.cache.Dataholder(inBlunder);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Distance",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceDataToCalc in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#DistanceDataToCalc"> Method DistanceDataToCalc</A>
    */
    public static java.lang.String DistanceDataToCalc (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceDataToCalc",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceForCalc in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#DistanceForCalc"> Method DistanceForCalc</A>
    */
    public static java.lang.String DistanceForCalc (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceForCalc",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     default argument inBlunder set to 0.5
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #DistanceGet(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#DistanceGet"> Method DistanceGet</A>
    */
    public static java.lang.String DistanceGet (com.intersys.objects.Database db, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[1] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[2] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLongitude);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceGet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     @param inBlunder represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#DistanceGet"> Method DistanceGet</A>
    */
    public static java.lang.String DistanceGet (com.intersys.objects.Database db, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude, java.lang.String inBlunder) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[1] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[2] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLongitude);
        args[4] = new com.intersys.cache.Dataholder(inBlunder);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method DistanceSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inBeginLatitude represented as java.lang.String
     @param inBeginLongitude represented as java.lang.String
     @param inEndLatitude represented as java.lang.String
     @param inEndLongitude represented as java.lang.String
     @param inDistance represented as java.lang.String
     @param inDuration represented as java.lang.String
     @param inStatus represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#DistanceSet"> Method DistanceSet</A>
    */
    public static java.lang.String DistanceSet (com.intersys.objects.Database db, java.lang.String inBeginLatitude, java.lang.String inBeginLongitude, java.lang.String inEndLatitude, java.lang.String inEndLongitude, java.lang.String inDistance, java.lang.String inDuration, java.lang.String inStatus) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[7];
        args[0] = new com.intersys.cache.Dataholder(inBeginLatitude);
        args[1] = new com.intersys.cache.Dataholder(inBeginLongitude);
        args[2] = new com.intersys.cache.Dataholder(inEndLatitude);
        args[3] = new com.intersys.cache.Dataholder(inEndLongitude);
        args[4] = new com.intersys.cache.Dataholder(inDistance);
        args[5] = new com.intersys.cache.Dataholder(inDuration);
        args[6] = new com.intersys.cache.Dataholder(inStatus);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DistanceSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method FromUTF in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inText represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#FromUTF"> Method FromUTF</A>
    */
    public static java.lang.String FromUTF (com.intersys.objects.Database db, java.lang.String inText) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inText);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"FromUTF",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GUID in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#GUID"> Method GUID</A>
    */
    public static java.lang.String GUID (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GUID",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GenerationSQLArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSQL represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#GenerationSQLArray"> Method GenerationSQLArray</A>
    */
    public static java.lang.String GenerationSQLArray (com.intersys.objects.Database db, java.lang.String inSQL) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inSQL);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GenerationSQLArray",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GeoCodeDriverGPSMonitor in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#GeoCodeDriverGPSMonitor"> Method GeoCodeDriverGPSMonitor</A>
    */
    public static java.lang.String GeoCodeDriverGPSMonitor (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeoCodeDriverGPSMonitor",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GeoCodeDriverGPSMonitorSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inName represented as java.lang.String
     default argument inDsc set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #GeoCodeDriverGPSMonitorSet(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#GeoCodeDriverGPSMonitorSet"> Method GeoCodeDriverGPSMonitorSet</A>
    */
    public static java.lang.String GeoCodeDriverGPSMonitorSet (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inName) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        args[2] = new com.intersys.cache.Dataholder(inName);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeoCodeDriverGPSMonitorSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GeoCodeDriverGPSMonitorSet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inLatitude represented as java.lang.String
     @param inLongitude represented as java.lang.String
     @param inName represented as java.lang.String
     @param inDsc represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#GeoCodeDriverGPSMonitorSet"> Method GeoCodeDriverGPSMonitorSet</A>
    */
    public static java.lang.String GeoCodeDriverGPSMonitorSet (com.intersys.objects.Database db, java.lang.String inLatitude, java.lang.String inLongitude, java.lang.String inName, java.lang.String inDsc) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inLatitude);
        args[1] = new com.intersys.cache.Dataholder(inLongitude);
        args[2] = new com.intersys.cache.Dataholder(inName);
        args[3] = new com.intersys.cache.Dataholder(inDsc);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeoCodeDriverGPSMonitorSet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetGeoCode in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inName represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#GetGeoCode"> Method GetGeoCode</A>
    */
    public static java.lang.String GetGeoCode (com.intersys.objects.Database db, java.lang.String inName) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inName);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetGeoCode",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SQLQeurySet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSQL represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#SQLQeurySet"> Method SQLQeurySet</A>
    */
    public static void SQLQeurySet (com.intersys.objects.Database db, java.lang.String inSQL) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inSQL);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SQLQeurySet",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method SetGeoCode in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inName represented as java.lang.String
     @param inPlaceID represented as java.lang.String
     @param inData represented as java.lang.String
     default argument inUTF set to "1"
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #SetGeoCode(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#SetGeoCode"> Method SetGeoCode</A>
    */
    public static java.lang.String SetGeoCode (com.intersys.objects.Database db, java.lang.String inName, java.lang.String inPlaceID, java.lang.String inData) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inName);
        args[1] = new com.intersys.cache.Dataholder(inPlaceID);
        args[2] = new com.intersys.cache.Dataholder(inData);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetGeoCode",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SetGeoCode in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inName represented as java.lang.String
     @param inPlaceID represented as java.lang.String
     @param inData represented as java.lang.String
     @param inUTF represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#SetGeoCode"> Method SetGeoCode</A>
    */
    public static java.lang.String SetGeoCode (com.intersys.objects.Database db, java.lang.String inName, java.lang.String inPlaceID, java.lang.String inData, java.lang.String inUTF) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inName);
        args[1] = new com.intersys.cache.Dataholder(inPlaceID);
        args[2] = new com.intersys.cache.Dataholder(inData);
        args[3] = new com.intersys.cache.Dataholder(inUTF);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SetGeoCode",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method addField in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     default argument inReplace set to 1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #addField(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#addField"> Method addField</A>
    */
    public static void addField (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName, java.lang.String inFieldValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        args[2] = new com.intersys.cache.Dataholder(inFieldValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addField",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addField in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     @param inReplace represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#addField"> Method addField</A>
    */
    public static void addField (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName, java.lang.String inFieldValue, java.lang.Integer inReplace) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        args[2] = new com.intersys.cache.Dataholder(inFieldValue);
        args[3] = new com.intersys.cache.Dataholder(inReplace);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addField",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addFieldSQLArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inQuery represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#addFieldSQLArray"> Method addFieldSQLArray</A>
    */
    public static void addFieldSQLArray (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName, java.lang.String inQuery) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        args[2] = new com.intersys.cache.Dataholder(inQuery);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addFieldSQLArray",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addToArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     default argument inIsGUID set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #addToArray(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#addToArray"> Method addToArray</A>
    */
    public static void addToArray (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName, java.lang.String inFieldValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        args[2] = new com.intersys.cache.Dataholder(inFieldValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addToArray",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addToArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     @param inIsGUID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#addToArray"> Method addToArray</A>
    */
    public static void addToArray (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName, java.lang.String inFieldValue, java.lang.Integer inIsGUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        args[2] = new com.intersys.cache.Dataholder(inFieldValue);
        args[3] = new com.intersys.cache.Dataholder(inIsGUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addToArray",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addToNamedArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inArrayName represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     default argument inIsGUID set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #addToNamedArray(com.intersys.objects.Database,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Integer)
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#addToNamedArray"> Method addToNamedArray</A>
    */
    public static void addToNamedArray (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inArrayName, java.lang.String inFieldName, java.lang.String inFieldValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inArrayName);
        args[2] = new com.intersys.cache.Dataholder(inFieldName);
        args[3] = new com.intersys.cache.Dataholder(inFieldValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addToNamedArray",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method addToNamedArray in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inArrayName represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @param inFieldValue represented as java.lang.String
     @param inIsGUID represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#addToNamedArray"> Method addToNamedArray</A>
    */
    public static void addToNamedArray (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inArrayName, java.lang.String inFieldName, java.lang.String inFieldValue, java.lang.Integer inIsGUID) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inArrayName);
        args[2] = new com.intersys.cache.Dataholder(inFieldName);
        args[3] = new com.intersys.cache.Dataholder(inFieldValue);
        args[4] = new com.intersys.cache.Dataholder(inIsGUID);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"addToNamedArray",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method getField in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inGUID represented as java.lang.String
     @param inFieldName represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#getField"> Method getField</A>
    */
    public static java.lang.String getField (com.intersys.objects.Database db, java.lang.String inGUID, java.lang.String inFieldName) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(inGUID);
        args[1] = new com.intersys.cache.Dataholder(inFieldName);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"getField",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method replValue in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inValue represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.GEO2#replValue"> Method replValue</A>
    */
    public static java.lang.String replValue (com.intersys.objects.Database db, java.lang.String inValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"replValue",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
}
