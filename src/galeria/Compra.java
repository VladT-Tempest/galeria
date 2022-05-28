package galeria;

import java.util.Calendar;

public class Compra {
	private long codigoCompra;
	private Calendar fecha;
	private boolean pagado;
	public Compra(long codigoCompra, Calendar fecha, boolean pagado) {

		this.codigoCompra = codigoCompra;
		this.fecha = fecha;
		this.pagado = pagado;
	}
	public long getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(long codigoCompra) {
		this.codigoCompra = codigoCompra;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	

}
