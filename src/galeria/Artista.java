package galeria;

import java.util.Calendar;

public class Artista {
	
	private long codigoArtita;
	private long cedula;
	private String nombre;
	private String apellidos;
	private Calendar fechaNacimiento;
	private long telefono;
	public long getCodigoArtita() {
		return codigoArtita;
	}
	public void setCodigoArtita(long codigoArtita) {
		this.codigoArtita = codigoArtita;
	}
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Artista(long codigoArtita, long cedula, String nombre, String apellidos, Calendar fechaNacimiento,
			long telefono) {
		super();
		this.codigoArtita = codigoArtita;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
	}
	
	
	
	
	
	
	

}
