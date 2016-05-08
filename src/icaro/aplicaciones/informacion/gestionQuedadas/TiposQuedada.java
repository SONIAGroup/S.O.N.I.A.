package icaro.aplicaciones.informacion.gestionQuedadas;

/**
 * 
 * @author Mariano Hernández García
 *
 */
public enum TiposQuedada {
	
	beber, da_igual;
	
	public String toString() {
		switch (this) {
			case beber: return "ir a tomar algo";
			case da_igual: return "hacer cualquier plan";
		}
		return null;
	}

}