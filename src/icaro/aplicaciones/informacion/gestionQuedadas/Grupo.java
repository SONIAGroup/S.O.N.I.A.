package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;

/**
 *  Clase que modela a un grupo
 *  
 * @author Mariano Hern�ndez Garc�a
 *
 */
public class Grupo implements Serializable {


	private static final long serialVersionUID = -7723600137719912487L;
	public String grupo;
	private String id;
	private int numIntegrantes;
	private int edad;
	private Sexo sexo;
	private String telefono;
	private long tiempo;
	
	public Grupo() {
		this.grupo 			= null;
		this.id 			= null;
		this.numIntegrantes = 0;
		this.sexo 			= null;
		this.edad 			= 0;
		this.telefono		= null;
		tiempo = System.currentTimeMillis();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumIntegrantes() {
		return numIntegrantes;
	}

	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void actividad() {
		tiempo = System.currentTimeMillis();
	}
	
	public boolean inactividad(int i) {
		long tim = ((System.currentTimeMillis() - tiempo) / 1000) / 60;
		return tim >= i;
	}

	@Override
	public String toString() {
		return "El grupo " + this.id + " esta formado por " + this.numIntegrantes + ", de una edad media de " + this.edad + " de sexo " + this.sexo; 
	}
	
	
	
	

}
