package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;

/**
 *  Clase que modela a un grupo
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
	private long tiempo;
	
	public Quedada(String idChat, Grupo grupoEmisor) {
		this.idChat = idChat;
		this.grupoEmisor	= grupoEmisor;
		this.grupoQueAcepta	= null;
		this.numIntegrantes = 0;
		this.sexo 			= null;
		this.edad 			= 0;
		tiempo = System.currentTimeMillis();
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
	
	
	
	

}
