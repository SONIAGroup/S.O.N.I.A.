package icaro.aplicaciones.recursos.persistenciaGrupos;

import java.rmi.RemoteException;

import icaro.aplicaciones.informacion.gestionCitas.UsuarioContexto;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.aplicaciones.recursos.persistenciaGrupos.ItfPersistenciaGrupos;
import icaro.aplicaciones.recursos.persistenciaGrupos.imp.PersistenciaGruposImp;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;

public class ClaseGeneradoraPersistenciaGrupos extends ImplRecursoSimple implements ItfPersistenciaGrupos {

	private static final long serialVersionUID = 6249741041405080757L;

	public ClaseGeneradoraPersistenciaGrupos(String idRecurso) throws RemoteException {
		super(idRecurso);
		System.out.println("SE CREA EL RECURSO QUE QUERIAMOS");
	}

	@Override
	public void insertarGrupo(String idgrupo, Grupo gr) throws Exception {
		PersistenciaGruposImp.insertarGrupo(idgrupo, gr);
	}

	@Override
	public Grupo obtenerGrupo(String idgrupo) throws Exception {
		return PersistenciaGruposImp.obtenerGrupo(idgrupo);
	}

	/*@Override
	public Grupo obtenerGrupoById(String id) throws Exception {
		return PersistenciaGruposImp.obtenerGrupoById(id);
	}*/
}
