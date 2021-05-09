package ar.edu.unq.po2.tp6refactorizado;

import java.util.ArrayList;

import ar.edu.unq.po2.tp6.Correo;

public class ClienteEmail2 {

	IServidorCorreo servidor;
	String nombreUsuario;
	String passusuario;
	ArrayList<Correo> inbox;
	private ArrayList<Correo> borrados;

	public ClienteEmail2(IServidorCorreo servidor, String nombreUsuario, String pass) {
		this.servidor=servidor;
		this.nombreUsuario=nombreUsuario;
		this.passusuario=pass;
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
		this.conectar();
	}
	
	public void conectar(){
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}
	
	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo);
		this.borrados.remove(correo);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void recibirNuevos(){
		this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
	}
	
	public void enviarCorreo(Correo correo){
		this.servidor.enviar(correo);
	}

}
