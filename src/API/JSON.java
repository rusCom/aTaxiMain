package API;


/**
 * Cache' Java Class Generated for class API.JSON on version Cache for Windows (x86-32) 2010.2.2 (Build 600) Wed Dec 8 2010 16:51:00 EST.<br>
 *
 * @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON</A>
**/

public class JSON extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 3350;
    private static String CACHE_CLASS_NAME = "API.JSON";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>API.JSON.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public JSON (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public JSON (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "API.JSON" in Cache
       database and corresponding object of class
       <code>API.JSON</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public JSON (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class API.JSON as it is in
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
        checkAllMethods(db, CACHE_CLASS_NAME, JSON.class);
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#%IsA"> Method %IsA</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#Answer"> Method Answer</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#Answer"> Method Answer</A>
    */
    public static void Answer (com.intersys.objects.Database db, java.lang.String GUID, java.lang.String inCode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(GUID);
        args[1] = new com.intersys.cache.Dataholder(inCode);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Answer",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method FromUTF in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inText represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#FromUTF"> Method FromUTF</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#GUID"> Method GUID</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#GenerationSQLArray"> Method GenerationSQLArray</A>
    */
    public static java.lang.String GenerationSQLArray (com.intersys.objects.Database db, java.lang.String inSQL) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inSQL);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GenerationSQLArray",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method SQLQeurySet in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inSQL represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#SQLQeurySet"> Method SQLQeurySet</A>
    */
    public static void SQLQeurySet (com.intersys.objects.Database db, java.lang.String inSQL) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inSQL);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"SQLQeurySet",args,com.intersys.objects.Database.RET_NONE);
        return;
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#addField"> Method addField</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#addField"> Method addField</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#addFieldSQLArray"> Method addFieldSQLArray</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#addToArray"> Method addToArray</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#addToArray"> Method addToArray</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#addToNamedArray"> Method addToNamedArray</A>
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
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#addToNamedArray"> Method addToNamedArray</A>
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
     <p>Runs method replValue in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param inValue represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://WIN-SXXN5RR5F37:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=ATAXI&CLASSNAME=API.JSON#replValue"> Method replValue</A>
    */
    public static java.lang.String replValue (com.intersys.objects.Database db, java.lang.String inValue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(inValue);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"replValue",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
}
