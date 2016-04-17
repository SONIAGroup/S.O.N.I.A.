package icaro.aplicaciones.informacion.gestionQuedadas;

public enum Sexo { masculino, femenino, indefinido;
	
	public String toString() {
		switch (this) {
			case masculino: return "masculino";
			case femenino: return "femenino";
			case indefinido: return "sin especificar";
		}
		return null;
	}

}
