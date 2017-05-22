package datojava.hsqldb.main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
  
public class ConectarBase {
	
		private Connection con;
	    private PreparedStatement consulta;
	    private ResultSet datos;
	    private string Server,User,bd,pass;
	    
	    public ConectarBase()
	    {
	    	this.Server="localhost";
	    	this.bd="PUBLIC";
	    	this.User="root";
	    	this.pass=""; 	
    	
	    }
	    public void Conectar() throw SQLException
	    {
	    	
	     try { 
	        
	    	Class.forName("org.hsqldb.jdbcDriver")
	    	this.con=DriverManager.getConnection("jdbc:hsqldb:hsql://"+this.Server+"/"this.bd,this.User,this.pass);    /*jdbc:hsqldb:hsql://localhost/PUBLIC/SA/""*/
	    	 	    		
	    	 }catch(ClassNotFoundException e){
	    		 
	    		 e.printStackTrace();
	    	 }
	     
	     public void Desconectar() throw SQLException /*método para cerrar conexión*/
	     {
	       this.con.close();    	 
	     }	    
	     
	     
	     public resultSet getDatos() throw SQLException /*pruebo una consulta para ver si todo me funca OK*/
	     {
	    	this.con(); 	    
	    	this.consulta=this.con.prepareStatement("Select * from Usuarios");
	    	this.datos=this.consulta.executeQuery();
	    	return this.datos;
	     }
	     
	     
	    }
}	    