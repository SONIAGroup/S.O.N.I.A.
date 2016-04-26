package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Herramienta que abstrae la conversacion con un usuario (grupo de personas)
 * 
 * @author mariano
 *
 */
public class ConversacionGrupo {
	
	private static HashMap<String,List<String>> conversacionGrupo;
	
	static{
		
		conversacionGrupo    = new HashMap<String, List<String>>();
		
		/* Sin contexto */
		List<String> pedirInfoOtroGrupo = new ArrayList<String>();
		pedirInfoOtroGrupo.add("Bueno, y con quien os apetece quedar?");
		pedirInfoOtroGrupo.add("Describidme el grupo con el que os apeteceria quedar.");
		pedirInfoOtroGrupo.add("Con que clase de grupo os apeteceria quedar? Describidmelo!");
		
	/* Sin contexto */
		List<String> sinContexto = new ArrayList<String>();
		sinContexto.add("Eing?? No entiendo lo que me estas diciendo. Rep�temelo, anda.");
		sinContexto.add("No estoy muy segura de estar entendiendote. �Podr�as repetirmelo?");
		sinContexto.add("�Hablamos el mismo idioma xD?. Rep�temelo con otras palabras");
	/*///////////////////// */
	
	/* Obtener informacion del grupo con el que se quiere quedar*/
		List<String> pedirInfoOtroGrupo_numPersonas = new ArrayList<String>();
		pedirInfoOtroGrupo_numPersonas.add("Necesito saber con cu�ntas personas quieres quedar");
		pedirInfoOtroGrupo_numPersonas.add("�Con cu�ntas personas te gustar�a quedar?");
		pedirInfoOtroGrupo_numPersonas.add("�Quieres quedar con un n�mero aproximado de personas o te da igual?");
	
		List<String> pedirInfoOtroGrupo_edad = new ArrayList<String>();
		pedirInfoOtroGrupo_edad.add("�Qu� edad media te gustar�a que tuvieran?");
		pedirInfoOtroGrupo_edad.add("�Qu� edad, m�s o menos, quieren que tengan?");
		
		List<String> pedirInfoOtroGrupo_sexo = new ArrayList<String>();
		pedirInfoOtroGrupo_sexo.add("�Quieres quedar con chicos, chicas o te da igual?");
		
		List<String> imperativoPedirInfoOtroGrupo = new ArrayList<String>();
		imperativoPedirInfoOtroGrupo.add("Por favor, necesito que me digas los datos de la gente con la que quieres quedar");
		imperativoPedirInfoOtroGrupo.add("Si no me dices con qui�n te gustar�a quedar, no podr� ayudarte :(");
		
		List<String> confirmacionInfoOtroGrupo = new ArrayList<String>();
		confirmacionInfoOtroGrupo.add("Muchas gracias!! Ya tengo la informaci�n sobre el otro grupo");
		confirmacionInfoOtroGrupo.add("Genial, pasemos ahora a determinar los datos de la quedada ;)");
		confirmacionInfoOtroGrupo.add("Esto va sobre la marcha. Vamos a hablar de la quedada");
	/*///////////////////// */
		
	/* Obtener que se quiere hacer*/
		List<String> pedirQueHacer = new ArrayList<String>();
		pedirQueHacer.add("�Qu� te apetece hacer?");
		pedirQueHacer.add("�Qu� te gustar�a hacer?");
		pedirQueHacer.add("�Cu�l es el plan que se te ha ocurrido?");
		pedirQueHacer.add("�Sabes el plan que quieres hacer o te da igual?");
		
		List<String> imperativoQueHacer = new ArrayList<String>();
		imperativoQueHacer.add("Necesito saber qu� quieres hacer...Si no lo sabes o te da igual, puedes decirme 'me da igual'");
		imperativoQueHacer.add("No seas rollo. �Qu� te apetece hacer?");
		
		List<String> confirmacionQueHacer = new ArrayList<String>();
		confirmacionQueHacer.add("Bien!! Ya sabemos el plan");
		confirmacionQueHacer.add("Suena interesante...�Me puedo apuntar xD?");
		confirmacionQueHacer.add("�Qu� divertido! Pasemos a lo siguiente");
	/*///////////////////// */
		
	/* Obtener donde se quiere hacer*/
		List<String> pedirDonde = new ArrayList<String>();
		pedirDonde.add("�D�nde quieres hacer ese plan?");
		pedirDonde.add("�D�nde quieres quedar?");
		pedirDonde.add("Ahora tienes que decirme el sitio");
		
		List<String> imperativoDonde = new ArrayList<String>();
		imperativoDonde.add("Eres muy cansino..dime, �d�nde quieres quedar?");
		imperativoDonde.add("No tengo todo el d�a, �sabes el lugar o te da igual?");
		
		List<String> confirmacionDonde = new ArrayList<String>();
		confirmacionDonde.add("Vale, ya tengo el lugar");
		confirmacionDonde.add("Ese lugar me suena ;)");
	/*///////////////////// */
		
	/* Obtener fecha y hora */	
		List<String> pedirFechayHora = new ArrayList<String>();
		pedirFechayHora.add("Ahora necesito saber el d�a y la hora a la que quieres quedar");
		pedirFechayHora.add("Ya casi acabamos! �Qu� d�a y a qu� hora quieres quedar?");
		pedirFechayHora.add("Por �ltimo s�lo necesito saber la fecha (d�a y hora) a la que quieres quedar");
		
		List<String> imperativopedirFechayHora = new ArrayList<String>();
		imperativopedirFechayHora.add("No podr� encontrar a otro grupo para quedar a menos que me digas la fecha y hora a la que desea quedar..");
		imperativopedirFechayHora.add("Por favor, necesito saber la fecha y la hora a la que quieres quedar");
		imperativopedirFechayHora.add("Yo tambi�n tengo vida...dime la fecha y la hora de la quedada, anda");
		
		List<String> confirmarFechayHora = new ArrayList<String>();
		confirmarFechayHora.add("Perfecto!! Ya tenemos la fecha y la hora ;)");
		confirmarFechayHora.add("Vale, esa fecha es v�lida");
	/*///////////////////// */
				
	/* Confirmar quedada*/	
		List<String> confirmarQuedada = new ArrayList<String>();
		confirmarQuedada.add("Ya tengo todo!! S�lo falta que me confirmes la cita");
		confirmarQuedada.add("Si me das el okay comenzar� a buscarte al otro grupo para que qued�is");
		
		List<String> imperativoConfirmarQuedada = new ArrayList<String>();
		imperativoConfirmarQuedada.add("Ya estamos acabando. Dime, �confirmas esta quedada?");
		imperativoConfirmarQuedada.add("�nimo, esto ya es lo �ltimo...�me confirmas la quedada?");
	/*///////////////////// */	
		
		
	/* Agregamos los dialogos a la conversacion global */
		conversacionGrupo.put("sinContexto", sinContexto);
		conversacionGrupo.put("pedirInfoOtroGrupo_numPersonas", pedirInfoOtroGrupo_numPersonas);
		conversacionGrupo.put("pedirInfoOtroGrupo", pedirInfoOtroGrupo);
		conversacionGrupo.put("pedirInfoOtroGrupo_edad", pedirInfoOtroGrupo_edad);
		conversacionGrupo.put("pedirInfoOtroGrupo_sexo", pedirInfoOtroGrupo_sexo);
		conversacionGrupo.put("imperativoPedirInfoOtroGrupo", imperativoPedirInfoOtroGrupo);
		conversacionGrupo.put("confirmacionInfoOtroGrupo", confirmacionInfoOtroGrupo);
		conversacionGrupo.put("pedirQueHacer", pedirQueHacer);
		conversacionGrupo.put("imperativoQueHacer", imperativoQueHacer);
		conversacionGrupo.put("confirmacionQueHacer", confirmacionQueHacer);
		conversacionGrupo.put("pedirDonde", pedirDonde);
		conversacionGrupo.put("imperativoDonde", imperativoDonde);
		conversacionGrupo.put("confirmacionDonde", confirmacionDonde);
		conversacionGrupo.put("pedirFechayHora", pedirFechayHora);
		conversacionGrupo.put("imperativopedirFechayHora", imperativopedirFechayHora);
		conversacionGrupo.put("confirmarFechayHora", confirmarFechayHora);
		conversacionGrupo.put("confirmarQuedada", confirmarQuedada);
		conversacionGrupo.put("imperativoConfirmarQuedada", imperativoConfirmarQuedada);
			
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
