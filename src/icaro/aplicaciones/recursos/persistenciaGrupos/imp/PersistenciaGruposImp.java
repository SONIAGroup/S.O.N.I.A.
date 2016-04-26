package icaro.aplicaciones.recursos.persistenciaGrupos.imp;

import icaro.aplicaciones.informacion.IOUtils;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PersistenciaGruposImp implements Serializable {

	private static final String GRUPOS_PATH = "grupos";
	private static Map<String, Grupo> tablaChatNombre = IOUtils.read(GRUPOS_PATH);

	/**
	 *
	 */
	private static final long serialVersionUID = 3791013440695899189L;

	public static void insertarGrupo(String chatName, Grupo grupo) {
		tablaChatNombre.put(chatName, grupo);
		IOUtils.write(GRUPOS_PATH, tablaChatNombre);
	}

	public static Grupo obtenerGrupoByChatName(String chatName) {
		return tablaChatNombre.get(chatName);

	}
	
	public static Grupo obtenerGrupoById(String id) {
		for(Grupo valores : tablaChatNombre.values()){
			if(valores.getId().equals(id)){
				return valores;
			}
		}
		return null;

	}
	
	/*public static String getUsuarioPersistenciaUsuarios(String nombre){
		Boolean found = false;
		Iterator<Entry<String, UsuarioContexto>> it = tablaChatNombre.entrySet().iterator();
		UsuarioContexto usuarioContexto;
		String usuario = "";
		
	    while (it.hasNext() && !found) {
	    	
	    	usuarioContexto = it.next().getValue();
	    	
	    	if(usuarioContexto.getNombre().equals(nombre)){
	    		found = true;
	    		usuario = usuarioContexto.getUsuario();
	    	}
	    }
	    
	    return usuario;
	}
	
	public static String getNombrePersistenciaUsuarios(String usuario){
		Boolean found = false;
		Iterator<Entry<String, UsuarioContexto>> it = tablaChatNombre.entrySet().iterator();
		UsuarioContexto usuarioContexto;
		String nombre = "";
		
	    while (it.hasNext() && !found) {
	    	
	    	usuarioContexto = it.next().getValue();
	    	
	    	if(usuarioContexto.getUsuario().equals(usuario)){
	    		found = true;
	    		nombre = usuarioContexto.getNombre();
	    	}
	    }
	    
	    return nombre;
	}*/

}
