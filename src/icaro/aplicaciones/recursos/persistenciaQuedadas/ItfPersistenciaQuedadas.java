package icaro.aplicaciones.recursos.persistenciaQuedadas;

import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfPersistenciaQuedadas extends ItfUsoRecursoSimple {

	void insertarQuedada(Quedada que) throws Exception;
	Quedada obtenerQuedadaDeGrupoEmisor(String idGrupo) throws Exception;
	Quedada obtenerQuedadaDeGrupoQueAcepta(String idGrupo) throws Exception;
	Quedada obtenerQuedadaDeGrupo(String idGrupo) throws Exception;

}
