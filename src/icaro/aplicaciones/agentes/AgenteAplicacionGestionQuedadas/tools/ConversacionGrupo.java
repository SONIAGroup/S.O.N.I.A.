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
		
		List<String> infoSolicitar = new ArrayList<String>();
		infoSolicitar.add("Al grupo {param} le gusta la quedada que habeis propuesto y les encantaria quedar con vosotros. Aceptais quedar con ellos?");
		
		List<String> infoConfirmar = new ArrayList<String>();
		infoConfirmar.add("El grupo {param} ha aceptado quedar con vosotros! Con esto la quedada esta ya confirmada, sed puntuales por favor! ;)");
		
		List<String> infoDenegar = new ArrayList<String>();
		infoDenegar.add("El grupo {param} ha denegado vuestra propuesta de quedar con ellos, no saben lo que se pierden ;) Volved a crear una quedada que seguro que encontrais a un grupo mejor.");
		
		List<String> infoCancelar = new ArrayList<String>();
		infoCancelar.add("El grupo con el que ibais a quedar, {param}, ha cancelado la quedada. Espero que no os haya fastidiado mucho :(");
		
		List<String> respuestaDenegar = new ArrayList<String>();
		respuestaDenegar.add("rellenar");
		
		List<String> respuestaConfirmar = new ArrayList<String>();
		respuestaConfirmar.add("rellenar");
		
		conversacionGrupo.put("cancelarQuedada", cancelarQuedada);
		conversacionGrupo.put("decirOk", decirOk);
		conversacionGrupo.put("infoSolicitar", infoSolicitar);
		conversacionGrupo.put("infoConfirmar", infoConfirmar);
		conversacionGrupo.put("infoDenegar", infoDenegar);
		conversacionGrupo.put("infoCancelar", infoCancelar);
		conversacionGrupo.put("respuestaDenegar", respuestaDenegar);
		conversacionGrupo.put("respuestaConfirmar", respuestaConfirmar);
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
