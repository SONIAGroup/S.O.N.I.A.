package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;

/**
 * Clase que representa a un grupo.
 * 
 * @author mariano
 *
 */
public class Grupo implements Serializable {


	private static final long serialVersionUID = -5021477443477477720L;
	private String id;
	private int numIntegrantes;
	private Sexo sexo;
	private double edad;
	
	public Grupo() {
		this.id 			= null;
		this.numIntegrantes = 0;
		this.sexo 			= null;
		this.edad 			= 0;
	}
	
	public Grupo(String id, int numIntegrantes, Sexo sexo, double edad) {
		super();
		this.id = id;
		this.numIntegrantes = numIntegrantes;
		this.sexo = sexo;
		this.edad = edad;
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

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "El grupo" + this.id + " esta formado por " + this.numIntegrantes + ", de una edad media de " + this.edad + " de sexo " + this.sexo; 
	}
	
	
	
	

}
