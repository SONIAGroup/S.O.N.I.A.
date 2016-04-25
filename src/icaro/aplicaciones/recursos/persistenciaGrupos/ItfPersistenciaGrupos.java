package icaro.aplicaciones.recursos.persistenciaGrupos;

import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfPersistenciaGrupos extends ItfUsoRecursoSimple {

	void insertarGrupo(String idgrupo, Grupo gr)
			throws Exception;

	Grupo obtenerGrupo(String idgrupo) throws Exception;
	
	//Grupo obtenerGrupoById(String id) throws Exception;

}
