package galeria;
import java.util.Calendar;

public class Artista {
	
	private long codigoArtista;
	private long cedula;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private long telefono;
	public long getCodigoArtista() {
		return codigoArtista;
	}
	public void setCodigoArtista(long codigoArtista) {
		this.codigoArtista = codigoArtista;
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Artista(long codigoArtista, long cedula, String nombre, String apellidos, String fechaNacimiento,
			long telefono) {
		this.codigoArtista = codigoArtista;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
	}

}
