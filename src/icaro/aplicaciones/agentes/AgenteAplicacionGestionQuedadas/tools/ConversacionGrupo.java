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
		cancelarQuedada.add("¿Queréis cancelar la quedada?");
		
		List<String> decirOk = new ArrayList<String>();
		decirOk.add("¡Perfecto! ¡Cualquier cosa que me entere acerca de la quedada os la comunicaré! Así que os recomendaría que no cerrárais el chat o vengais a verme de vez en cuando, por si os tengo que decir alguna novedad ;)");
		
		List<String> infoSolicitar = new ArrayList<String>();
		infoSolicitar.add("Al grupo -param- les gusta la quedada que habéis propuesto y les encantaría quedar con vosotros. ¿Aceptáis quedar con ellos?");
		
		List<String> infoConfirmar = new ArrayList<String>();
		infoConfirmar.add("¡El grupo -param- ha aceptado quedar con vosotros! Con esto la quedada está ya confirmada. ¡Sed puntuales por favor! ;)");
		
		List<String> infoDenegar = new ArrayList<String>();
		infoDenegar.add("El grupo -param- ha denegado vuestra propuesta de quedar con ellos, no saben lo que se pierden ;) Volved a crear una quedada que seguro que encontráis a un grupo mejor.");
		
		List<String> infoCancelar = new ArrayList<String>();
		infoCancelar.add("El grupo con el que íbais a quedar, -param-, ha cancelado la quedada. Espero que no os haya fastidiado mucho :(");
		
		List<String> respuestaDenegar = new ArrayList<String>();
		respuestaDenegar.add("Ooo siento que no queráis quedar con ellos. Os avisaré cuando haya otro grupo interesado en vuestra quedada.");
		
		List<String> respuestaConfirmar = new ArrayList<String>();
		respuestaConfirmar.add("¡Genial! Ya he avisado al otro grupo de vuestra confirmación y les he pedido que sean puntuales, ¡serlo vosotros también!");
		
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
