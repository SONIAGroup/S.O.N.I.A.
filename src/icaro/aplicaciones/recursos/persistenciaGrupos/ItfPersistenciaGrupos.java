package icaro.aplicaciones.recursos.persistenciaGrupos;

import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfPersistenciaGrupos extends ItfUsoRecursoSimple {

	void insertarGrupo(String chatName, Grupo gr)
			throws Exception;

	Grupo obtenerGrupoByChatName(String chatName) throws Exception;
	
	Grupo obtenerGrupoById(String id) throws Exception;

}
