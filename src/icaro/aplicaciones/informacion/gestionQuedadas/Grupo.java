package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;

/**
 *  Clase que modela a un grupo
 *  
 * @author Mariano Hernández García
 *
 */
public class Grupo implements Serializable {


	private static final long serialVersionUID = -7723600137719912487L;
	public String grupo;
	private String id;
	private int numIntegrantes;
	private Sexo sexo;
	private double edad;
	private long tiempo;
	
	public Grupo() {
		this.grupo 			= null;
		this.id 			= null;
		this.numIntegrantes = 0;
		this.sexo 			= null;
		this.edad 			= 0;
		tiempo = System.currentTimeMillis();
	}
	
	public Grupo(String id, int numIntegrantes, Sexo sexo, double edad) {
		super();
		this.id = id;
		this.numIntegrantes = numIntegrantes;
		this.sexo = sexo;
		this.edad = edad;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEdad() {
		return "" + edad;
	}

	public void setEdad(String edad) {
		this.edad = Float.parseFloat(edad);
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
		return "El grupo" + this.id + " esta formado por " + this.numIntegrantes + ", de una edad media de " + this.edad + " de sexo " + this.sexo; 
	}
	
	
	
	

}
