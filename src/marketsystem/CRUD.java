/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author netosolis.com
 */
public class CRUD {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st,st2;
    private ResultSet rs;

    public CRUD() {
        try{
            if((con = conexion.getConexionMYSQL())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
             st2 = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //pedir las contraseñas actuales en la bd
    public ResultSet login(String user, String pass){
        try {
            String query = "SELECT * FROM usuarios WHERE nombre_usuario='"+user+"' AND contrasenia_usuario='"+pass+"';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // cambia la contraseña del sistema
    public boolean changePass ( String contranueva,String contraanterior,String usuarios){
        try{                       
            String query = "UPDATE usuarios SET"
                    + " contrasenia_usuario = '"+contranueva+"' WHERE contrasenia_usuario = '"+contraanterior+"' AND nombre_usuario = '"+usuarios+"'";
             st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//****Tabla Usuarios******
    //Insertar usuario 
    public ResultSet insertUser(String user, String pass, String nombre, String pApellido, String sApellido, String calle, String col, String cp, String numCasa, String telFijo, String telCel, String email){
        try{
            String query = "INSERT INTO Usuarios(nombre_usuario, contrasenia_usuario, Nombre, PrimerApellido, SegundoApellido, Calle, Colonia, CP, NumCasa, TelefonoFijo, TelefonoCelular, Email)"
                    + "VALUES ('"+user+"','"+pass+"','"+nombre+"','"+pApellido+"','"+sApellido+"','"+calle+"','"+col+"','"+cp+"','"+numCasa+"','"+telFijo+"','"+telCel+"','"+email+"');";
            
            Statement st = con.createStatement();
            long id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            return rs;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    //ActualizarUsuarios
    public boolean updateUser(int id, String user, String pass, String nombre, String pApellido, String sApellido, String calle, String col, String cp, String numCasa, String telFijo, String telCel, String email){
        try{
            String query = "UPDATE Usuarios SET "
                    + "nombre_usuario='"+user+"',contrasenia_usuario='"+pass+"',Nombre='"+nombre+"',PrimerApellido='"+pApellido+"',SegundoApellido='"+sApellido+"',Calle='"+calle+"',Colonia='"+col+"',CP='"+cp+"',NumCasa='"+numCasa+"',TelefonoFijo='"+telFijo+"',TelefonoCelular='"+telCel+"',Email='"+email+"'"
                    + " WHERE id_usuario="+id+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Eliminar Usuarios
    public boolean deleteUser(int id){
        try{
            String query = "DELETE FROM Usuarios WHERE id_usuario="+id+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Obtener Lista de usuarios
    public ResultSet getUsers(){
        try {
            String query = "SELECT * FROM usuarios";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getUserByParam(String param){
        try {
            String query = "SELECT * FROM usuarios WHERE nombre_usuario LIKE '%"+param+"%' OR "
                    + "Nombre LIKE '%"+param+"%' OR "
                    + "PrimerApellido LIKE '%"+param+"%' OR "
                    + "SegundoApellido LIKE '%"+param+"%';";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar usuarios por ID
    public ResultSet getUserById(int id){
        try {
            String query = "SELECT * FROM usuarios WHERE id_usuario="+id+";";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar por el ultimo ID insertado
    
    public ResultSet getLastId(){
        
        try {
            String query = "SELECT LAST_INSERT_ID() as id;";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    //******Tabla Productos********
    
    //Insertar productos
     public ResultSet insertarProducto(String nombreP, long codigoB, float PrecioC, float PrecioV, int distId, int cateId){
        try{
            String query = "INSERT INTO productos(nombreProducto,codigoBarrasProducto,precioCompra, precioVenta, DistribuidorID, idCategoria)"
                + "VALUES ('"+nombreP+"',"+codigoB+","+PrecioC+","+PrecioV+","+distId+","+cateId+");";
            
            Statement st = con.createStatement();
            long id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            return rs;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
     //ActualizarProductos
    public boolean actualizarProducto(int idP,String nombreP,long codigoB, double PrecioC, double PrecioV, int distId, int cateId){
        try{
            String query = "UPDATE productos SET "
                    + "nombreProducto='"+nombreP+"',codigoBarrasProducto="+codigoB+",precioCompra="+PrecioC+",precioVenta="+PrecioV+", DistribuidorID="
                    + distId+",idCategoria="+cateId+" WHERE idProducto="+idP+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Eliminar productos
    public boolean eliminarProducto(int id){
        try{
            String query = "DELETE FROM productos WHERE idProducto="+id+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Obtener Lista de productos
    public ResultSet obtenerProductos(){
        try {
            String query = "SELECT * FROM productos";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar producto con parametros distintos
    public ResultSet obtenerProductosP(String param){
        try {
            String query = "SELECT * FROM productos WHERE nombreProducto LIKE '%"+param+"%' OR "
                    + "codigoBarrasProducto LIKE '%"+param+"%' OR "
                    + "precioCompra LIKE '%"+param+"%' OR "
                    + "precioVenta LIKE '%"+param+"%';";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar producto por ID
    public ResultSet obtenerProductoId(int id){
        try {
            String query = "SELECT * FROM productos WHERE idProducto="+id+";";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //*******Tabla Categorías*******
    
      //Insertar productos
     public ResultSet insertarCategoria(String nombreC){
        try{
            String query = "INSERT INTO categorias(nombreCategoria)"
                    + "VALUES ('"+nombreC+"');";
            
            Statement st = con.createStatement();
            long id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            return rs;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
     //ActualizarProductos
    public boolean actualizarCategoria(int idC,String nombreC){
        try{
            String query = "UPDATE categorias SET "
                    + "nombreCategoria='"+nombreC+"'"
                    + " WHERE idCategoria="+idC+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Eliminar productos
    public boolean eliminarCategoria(int id){
        try{
            String query = "DELETE FROM categorias WHERE idCategoria="+id+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Obtener Lista de productos
    public ResultSet obtenerCategorias(){
        try {
            String query = "SELECT * FROM categorias";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar producto con parametros distintos
    public ResultSet obtenerCategoriaP(String param){
        try {
            String query = "SELECT * FROM categorias WHERE nombreCategoria LIKE '%"+param+"%'";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar producto por ID
    public ResultSet obtenerCategoriaId(int id){
        try {
            String query = "SELECT * FROM categorias WHERE idCategoria="+id+";";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
  /*Distribuidores */
    
    //Insertar Distribuidor
    public ResultSet insertarDistribuidores( String Nombre, String RFC, String Calle, String Colonia, String CP, String NumLocal , String Telefono, String Tipo){
        try{
            String query = "INSERT INTO Distribuidores(Nombre, RFC, Calle, Colonia, CP, NumLocal, Telefono, Tipo)"
                    + "VALUES ('"+Nombre+"','"+RFC+"','"+Calle+"','"+Colonia+"','"+CP+"','"+NumLocal+"','"+Telefono+"','"+Tipo+"');";
            
            Statement st = con.createStatement();
            long id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            return rs;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        
    }
        //Actualizar Distribuidor
        public boolean actualizarDistribuidores(int DistribuidorID, String Nombre, String RFC, String Calle, String Colonia, String CP, String NumLocal , String Telefono, String Tipo){
        try{
            String query = "UPDATE Distribuidores SET "
                    + "Nombre='"+Nombre+"',RFC='"+RFC+"',Calle='"+Calle+"',Colonia='"+Colonia+"',CP='"+CP+"',NumLocal='"+NumLocal+"',Telefono='"+Telefono+"',Tipo='"+Tipo+"' "
                    + " WHERE DistribuidorID="+DistribuidorID+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
        
        //Eliminar Distribuidor
    public boolean eliminarDistribuidores(int DistribuidorID){
        try{
            String query = "DELETE FROM Distribuidores WHERE DistribuidorID="+DistribuidorID+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Visuallizar Distribuidor
    public ResultSet obtenerDistribuidores(){
        try {
            String query = "SELECT * FROM Distribuidores";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar producto con parametros distintos
    public ResultSet obtenerDistribuidoresP(String param){
        try {
            String query = "SELECT * FROM distribuidores WHERE Nombre LIKE '%"+param+"%'";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar producto por ID
    public ResultSet obtenerDistribuidoresId(int id){
        try {
            String query = "SELECT * FROM distribuidores WHERE DistribuidorID="+id+";";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //*****Tabla Clientes*****//
      //Insertar Cleintes 
    public ResultSet insertarClientes(String nombreC,String primerA,String segundoA,String calleC,String coloniaC,String CPC,String numeroC,String telF,String telC,String correo){
        try{
            String query = "INSERT INTO clientes(NombreCliente, primeroApellidoCliente, segundoApellidoCliente, calleCliente, coloniaCliente,cPCliente, numeroCasaCliente, telefonoFijoCliente, telefonoCelularCliente,correoElectronicoCliente)"
                    + "VALUES ('"+nombreC+"','"+primerA+"','"+segundoA+"','"+calleC+"','"+coloniaC+"','"+CPC+"','"+numeroC+"','"+telF+"','"+telC+"','"+correo+"');";
            
            Statement st = con.createStatement();
            long id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            return rs;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    //ActualizarUsuarios
    public boolean actualizarClientes(int id,String nombreC,String primerA,String segundoA,String calleC,String coloniaC,String CPC,String numeroC,String telF,String telC,String correo){
        try{
            String query = "UPDATE clientes SET "
                    + "NombreCliente='"+nombreC+"',primeroApellidoCliente='"+primerA+"',segundoApellidoCliente='"+segundoA+"',calleCliente='"+calleC+"',coloniaCliente='"+coloniaC+"',cPCliente='"+CPC+"',numeroCasaCliente='"+numeroC+"',telefonoFijoCliente='"+telF+"',telefonoCelularCliente='"+telC+"',correoElectronicoCliente='"+correo+"'"
                    + " WHERE idCliente="+id+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Eliminar Usuarios
    public boolean eliminarClientes(int id){
        try{
            String query = "DELETE FROM clientes WHERE idCliente="+id+";";
            int rs = st.executeUpdate(query);
            return rs != 0;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    //Obtener Lista de usuarios
    public ResultSet obtenerClientes(){
        try {
            String query = "SELECT * FROM clientes";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet obtenerClientesP(String param){
        try {
            String query = "SELECT * FROM clientes WHERE NombreCliente LIKE '%"+param+"%' OR "
                    + "primerApellidoCliente LIKE '%"+param+"%' OR "
                    + "segundoApellidoCliente LIKE '%"+param+"%' OR "
                    + "telefonoFijoCliente LIKE '%"+param+"%';";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar usuarios por ID
    public ResultSet obtenerClientesId(int id){
        try {
            String query = "SELECT * FROM clientes WHERE idCliente="+id+";";
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}