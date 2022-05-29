package galeria;

import java.util.Calendar;

public class Obra {
	private long CodigoObra;
	private String 	titulo;
	private String fecha;
	private float precioRef;
	private String dimesiones;
	
	public Obra(long codigoObra, String titulo, String fecha, float precioRef, String dimesiones) {
		this.CodigoObra = codigoObra;
		this.titulo = titulo;
		this.fecha = fecha;
		this.precioRef = precioRef;
		this.dimesiones = dimesiones;
	}
	public long getCodigoObra() {
		return CodigoObra;
	}
	public void setCodigoObra(long codigoObra) {
		CodigoObra = codigoObra;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getPrecioRef() {
		return precioRef;
	}
	public void setPrecioRef(float precioRef) {
		this.precioRef = precioRef;
	}
	public String getDimesiones() {
		return dimesiones;
	}
	public void setDimesiones(String dimesiones) {
		this.dimesiones = dimesiones;
	}
	
	

}
