package jmydays.util;

import java.io.File;
import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.DriverManager;


/*
 * Using Driver from:
 * http://www.zentus.com/sqlitejdbc/index.html
 * http://www.xerial.org/trac/Xerial/Fwiki/SQLiteJDBC
 * http://www.xerial.org/maven/repository/artifact/org/xerial/sqlite-jdbc/
 */
public class Database implements jmydays.JMyDaysConstants {

    /**
     * Private constructor tu avoid instantiation of the class.
     */
    private Database(){
        super();
    }

    private static String rutaFinalArchivo;

    /**
     * Method used to change the path of the DB file used to generate the DB connection.
     * @param newDBFilename
     */
    public static void changeDBFilePath(final String newDBFilename){
        rutaFinalArchivo = getDBFilePath(newDBFilename);
    }

    /**
     * Method used to obtain a String that contains the path to a file at parent
     * directory to the DEFAULT (zero level) CLASS PACKAGE.
     *
     * @param dbFilename The name of the SQLite database file.
     * @return String containing path and SQLite database file name.
     */
    public static synchronized String getDBFilePath(final String dbFilename){
        
        java.net.URL archivoURL = Database.class.getResource("/" + PROPS_CONFIG_FILENAME); //Any file existing at the class package root directory.
        String rutaArchivo;
        
        if( Util.getOS() == OS.WINDOWS ){
        	rutaArchivo = archivoURL.toString().substring( archivoURL.toString().indexOf(":/")+2 );
        }else{
        	rutaArchivo = archivoURL.toString();
        }

        try{
            rutaArchivo = URLDecoder.decode(rutaArchivo, "UTF-8");
        }catch(UnsupportedEncodingException uee){
            System.out.println("UnsupportedEncodingException: " + uee.getMessage());
        }

        //Go one folder level down... (to not look at lowest level INSIDE JAR, but rather at level of JAR FILE
        rutaArchivo = rutaArchivo.substring( 0, rutaArchivo.lastIndexOf("/") );
        rutaArchivo = rutaArchivo.substring( 0, rutaArchivo.lastIndexOf("/") );
        rutaArchivo += "/" + dbFilename;
        
        return rutaArchivo;
    }
    
    /*
    FileInputStream in = new FileInputStream(file) {
	try {
	    java.nio.channels.FileLock lock = in.getFileChannel().lock();
	    try {
	        Reader reader = new InputStreamReader(in, charset);
	        ...
	    } finally {
	        lock.release();
	    }
	} finally {
	    in.close();
	}
	*/

    private static java.sql.Connection dbConnection = null;
    public static synchronized java.sql.Connection generaConexion(){
    	
    	try{
	    	if( dbConnection == null || dbConnection.isClosed() ){
	    		if( rutaFinalArchivo == null ){
	    			rutaFinalArchivo = getDBFilePath(DB_FILENAME); 
	    		}
	    		dbConnection = generaNuevaConexion();
	    	}
        } catch (Exception e) {
            System.err.println("Exception when generation DB connection:" + e.getMessage());
            return null;
        }
        
    	return dbConnection;
    }
    
    /**
     * Metodo que inicia una nueva conexion a la base de datos.
     * @return java.sql.Connection
     */
    public static synchronized java.sql.Connection generaNuevaConexion() throws Exception{
    	System.out.println("Generation DB connection.");
        
        //conectamos con DB...
        Class.forName("org.sqlite.JDBC").newInstance(); //Initializes SQLite JDBC Driver class.
        
        if( Util.getOS() != OS.WINDOWS ){
        	rutaFinalArchivo = rutaFinalArchivo.toString().substring( rutaFinalArchivo.toString().indexOf(":/")+1 );
        }
        return DriverManager.getConnection("jdbc:sqlite:" + rutaFinalArchivo);
    }
    
    

    public static boolean createInstanceLock(){
    	
    	File instanceLock = new File( rutaFinalArchivo.substring( 0, rutaFinalArchivo.lastIndexOf("/") )+ "/" + INSTANCE_LOCK_FILENAME );
    	
    	if( instanceLock.exists() ){
    		return false;
    	}else{
    		try {
				return instanceLock.createNewFile();
			} catch (IOException e) {
				System.out.println("Exception when creating new file: " + e.getMessage());
				return true;
			}finally{
				instanceLock.deleteOnExit();
			}
    		
    	}
    	
    }
    
    public static void removeInstanceLock(){
    	File instanceLock = new File( rutaFinalArchivo.substring( 0, rutaFinalArchivo.lastIndexOf("/") )+ "/" + INSTANCE_LOCK_FILENAME );
    	
    	if( instanceLock.exists() ){
    		instanceLock.delete();
    	}
    }
    
}
