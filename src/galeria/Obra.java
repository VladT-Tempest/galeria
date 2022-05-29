package galeria;


public class Obra {
	private long CodigoObra;
	private String 	titulo;
	private String fecha;
	private float precioRef;
	private String dimensiones;
	private boolean estado;
	private long codigoArtista;
	
	public Obra(long codigoObra, String titulo, String fecha, float precioRef, String dimensiones, boolean estado, long codigoArtista) {
		this.CodigoObra = codigoObra;
		this.titulo = titulo;
		this.fecha = fecha;
		this.precioRef = precioRef;
		this.dimensiones = dimensiones;
		this.estado = estado;
		this.codigoArtista = codigoArtista;
	}
	public long getCodigoArtista() {
		return codigoArtista;
	}
	public void setCodigoArtista(long codigoArtista) {
		this.codigoArtista = codigoArtista;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
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
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimesiones) {
		this.dimensiones = dimesiones;
	}
	
	

}
