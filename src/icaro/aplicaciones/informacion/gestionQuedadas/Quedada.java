package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import icaro.aplicaciones.recursos.recursoCalendario.DateUtil;

/**
 *  Clase que modela una quedada
 *  
 * @author Mariano Hernández García Y Jorge Casas Hernan
 *
 */
public class Quedada implements Serializable {


	private static final long serialVersionUID = -2159848484753598994L;
	public String idChat;			
	private Grupo grupoEmisor;
	private Grupo grupoQueAcepta;
	private int numIntegrantes;
	private Sexo sexo;
	private int edad;
	private String queHacer;
	private String lugar;
	private Calendar fecha;


	private long tiempo;
	
	public Quedada(String idChat, Grupo grupoEmisor) {
		this.idChat 		= idChat;
		this.grupoEmisor	= grupoEmisor;
		this.grupoQueAcepta	= null;
		this.numIntegrantes = 0;
		this.sexo 			= null;
		this.edad 			= 0;
		this.tiempo 		= System.currentTimeMillis();
		this.queHacer 		= "";
		this.lugar 			= "";
		this.fecha			= null;
	}

	public void setGrupoEmisor(Grupo grupoEmisor) {
		this.grupoEmisor = grupoEmisor;
	}
	
	public Grupo getGrupoEmisor() {
		return grupoEmisor;
	}
	
	public void setGrupoQueAcepta(Grupo grupoQueAcepta) {
		this.grupoQueAcepta = grupoQueAcepta;
	}
	
	public Grupo getGrupoQueAcepta() {
		return grupoQueAcepta;
	}

	public int getNumIntegrantes() {
		return numIntegrantes;
	}

	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}

	public String getSexo() {
		// Se puede utilizar sexo.toString() directamente
		String sexo_str = null;
		if (sexo == Sexo.masculino)
			sexo_str = "hombres";
		else if (sexo == Sexo.masculino)
			sexo_str = "mujeres";
		else if (sexo == Sexo.masculino)
			sexo_str = "mixto";
		return sexo_str;
	}

	public void setSexo(String sexo) {
		if(sexo.indexOf("hombre") >= 0)
			this.sexo = Sexo.masculino;
		else if(sexo.indexOf("mujer") >= 0)
			this.sexo = Sexo.femenino;
		else if(sexo.indexOf("mixto") >= 0)
			this.sexo = Sexo.mixto;
		else if(sexo.indexOf("sin_especificar") >= 0) {
			this.sexo = Sexo.sin_especificar;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void actividad() {
		tiempo = System.currentTimeMillis();
	}
	
	public boolean inactividad(int i) {
		long tim = ((System.currentTimeMillis() - tiempo) / 1000) / 60;
		return tim >= i;
	}
	
	
	public String getQueHacer() {
		return queHacer;
	}

	public void setQueHacer(String queHacer) {
		this.queHacer = queHacer;
	}
	
	public void setLugar(String dondeHacer) {
		this.lugar = dondeHacer;
	}

	public String getLugar() {
		return lugar;
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		if (this.fecha == null)
			this.fecha = DateUtil.toCalendar(new Date());
		
		String[] parts = fecha.split("/");
		this.fecha.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parts[0]));
		this.fecha.set(Calendar.MONTH, Integer.parseInt(parts[1]));
		this.fecha.set(Calendar.YEAR, Integer.parseInt(parts[2]));
	}
	
	public void setHora(String hora) {
		if (this.fecha == null)
			this.fecha = DateUtil.toCalendar(new Date());
		
		String[] parts;
		if(hora.indexOf(":") >= 0)
			parts = hora.split(":");
		else if(hora.indexOf(".") >= 0)
			parts = hora.split("\\.");
		else
			parts = hora.split(" ");
		
		this.fecha.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
		this.fecha.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
	}
	
	private String getFechaFormateada() {
		String min = "" + fecha.get(Calendar.MINUTE);
		
		if ( fecha.get(Calendar.MINUTE) < 10 )	
			min = "0" + min;
		
		return "" + fecha.get(Calendar.DAY_OF_MONTH) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR) + " a las " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + min;
	}

	@Override
	public String toString() {
		return "" + this.queHacer + " en " + this.lugar + " en la fecha " + this.getFechaFormateada() + ", con un grupo de " + this.numIntegrantes + " personas, de una edad media de " + this.edad + " anios y de sexo " + this.sexo; 
	}
	
	
	

}
