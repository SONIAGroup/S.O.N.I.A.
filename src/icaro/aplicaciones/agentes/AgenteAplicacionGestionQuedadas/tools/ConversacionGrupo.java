package icaro.aplicaciones.agentes.AgenteAplicacionGestionQuedadas.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Herramienta que abstrae la conversacion con un usuario (grupo de personas)
 * 
 * @author SONIAGroup
 *
 */
public class ConversacionGrupo {
	
	private static HashMap<String,List<String>> conversacionGrupo;
	
	static{
		
		conversacionGrupo = new HashMap<String, List<String>>();
		
		List<String> cancelarQuedada = new ArrayList<String>();
		cancelarQuedada.add("Quereis cancelar la quedada?");
		
		List<String> decirOk = new ArrayList<String>();
		decirOk.add("Perfecto! Cualquier cosa que me entere acerca de la quedada os la comunicare! Asi que os recomendaria que no cerrarais el chat o vengais a verme de vez en cuando, por si os tengo que decir alguna novedad ;)");
		
		conversacionGrupo.put("cancelarQuedada", cancelarQuedada);
		conversacionGrupo.put("decirOk", decirOk);
	}
	
	
	public static String msg(String tipo){
		
		String msg = null;
		if(conversacionGrupo.get(tipo) != null && conversacionGrupo.get(tipo).size() > 0){
			int index = (int)(System.currentTimeMillis() % conversacionGrupo.get(tipo).size());
			msg = conversacionGrupo.get(tipo).get(index);
		}
		return msg;
	}
	
}
