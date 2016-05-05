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
		
		conversacionGrupo = new HashMap<String, List<String>>();
		
		/* Sin contexto */
		List<String> pedirInfoOtroGrupo = new ArrayList<String>();
		pedirInfoOtroGrupo.add("Necesito saber con cuantas personas quereis quedar, su edad media y si quereis quedar con hombres, mujeres o con un grupo mixto");
		pedirInfoOtroGrupo.add("Describidme el grupo con el que os apeteceria quedar.");
		pedirInfoOtroGrupo.add("Con que clase de grupo os apeteceria quedar? Describidmelo!");
		
	/* Sin contexto */
		List<String> sinContexto = new ArrayList<String>();
		sinContexto.add("Eing?? No entiendo lo que me estas diciendo. Repitemelo, anda.");
		sinContexto.add("No estoy muy segura de estar entendiendote. Podrias repetirmelo?");
		sinContexto.add("Hablamos el mismo idioma xD?. Repitemelo con otras palabras");
	/*///////////////////// */
	
	/* Obtener informacion del grupo con el que se quiere quedar*/
		List<String> pedirInfoOtroGrupo_numIntegrantes = new ArrayList<String>();
		pedirInfoOtroGrupo_numIntegrantes.add("Necesito saber con cuantas personas quereis quedar");
		pedirInfoOtroGrupo_numIntegrantes.add("Con cuantas personas os gustaria quedar?");
		pedirInfoOtroGrupo_numIntegrantes.add("Quereis quedar con un numero aproximado de personas u os da igual?");
		
		List<String> imperativoInfoOtroGrupo_numIntegrantes = new ArrayList<String>();
		imperativoInfoOtroGrupo_numIntegrantes.add("Vamos mas lentos que los caracoles :( Dime el numero de integrantes del otro grupo!! U os da igual??");
		
		List<String> errorInfoOtroGrupo_numIntegrantes = new ArrayList<String>();
		errorInfoOtroGrupo_numIntegrantes.add("Asi que quereis quedar con un grupo de 0 personas...pues ya esta la quedada!! Venga, en serio, decidme con cuantas personas queresis quedar");
	
		List<String> pedirInfoOtroGrupo_edad = new ArrayList<String>();
		pedirInfoOtroGrupo_edad.add("Que edad media te gustaria que tuvieran?");
		pedirInfoOtroGrupo_edad.add("Que edad, mas o menos, quieres que tengan?");
		
		List<String> imperativoInfoOtroGrupo_edad = new ArrayList<String>();
		imperativoInfoOtroGrupo_edad.add("Como os gusta bacilarme...Que edad media os gustaria que tuvieran?");
		
		List<String> errorInfoOtroGrupo_edad = new ArrayList<String>();
		errorInfoOtroGrupo_edad.add("Perdona, pero solo podeis quedar con gente mayor de edad...Decidme una edad aproximada,  por favor.");
		
		List<String> pedirInfoOtroGrupo_sexo = new ArrayList<String>();
		pedirInfoOtroGrupo_sexo.add("Quereis quedar con chicos, chicas u os da igual?");
		pedirInfoOtroGrupo_sexo.add("Quereis que sean hombres, mujeres u os da igual?");
		
		List<String> confirmacionInfoOtroGrupo_sexo = new ArrayList<String>();
		confirmacionInfoOtroGrupo_sexo.add("Okay, ya sabemos el sexo del otro grupo");
		
		List<String> imperativoInfoOtroGrupo_sexo = new ArrayList<String>();
		imperativoInfoOtroGrupo_sexo.add("Venga...necesito saber el sexo del otro grupo. Si os das igual, decidmelo");
		
		
		List<String> imperativoPedirInfoOtroGrupo = new ArrayList<String>();
		imperativoPedirInfoOtroGrupo.add("Por favor, necesito que me digas los datos de la gente con la que quieres quedar");
		imperativoPedirInfoOtroGrupo.add("Si no me dices con quien te gustaria quedar, no podre ayudarte :(");
		
		List<String> confirmacionInfoOtroGrupo = new ArrayList<String>();
		confirmacionInfoOtroGrupo.add("Muchas gracias!! Ya tengo la informacion sobre el otro grupo");
		confirmacionInfoOtroGrupo.add("Genial, pasemos ahora a determinar los datos de la quedada ;)");
		confirmacionInfoOtroGrupo.add("Esto va sobre la marcha. Vamos a hablar de la quedada");
	/*///////////////////// */
		
	/* Obtener que se quiere hacer*/
		List<String> pedirQueHacer = new ArrayList<String>();
		pedirQueHacer.add("Que os apetece hacer?");
		pedirQueHacer.add("Que os gustaria hacer?");
		pedirQueHacer.add("Cual es el plan que se os ha ocurrido?");
		pedirQueHacer.add("Sabeis el plan que quereis hacer u os da igual?");
		
		List<String> imperativoQueHacer = new ArrayList<String>();
		imperativoQueHacer.add("Necesito saber que quereis hacer...Si no lo sabeis u os da igual, podeis decirme 'me da igual'");
		imperativoQueHacer.add("No seas rollo. Que te apetece hacer?");
		
		List<String> confirmacionQueHacer = new ArrayList<String>();
		confirmacionQueHacer.add("Bien!! Ya sabemos el plan");
		confirmacionQueHacer.add("Suena interesante...Seguro que lo pasais genial :)");
		confirmacionQueHacer.add("Que divertido! Pasemos a lo siguiente");
	/*///////////////////// */
		
	/* Obtener donde se quiere hacer*/
		List<String> pedirDonde = new ArrayList<String>();
		pedirDonde.add("Ahora necesito saber el sitio. Algunas opciones son Sol, Atocha, principe pio...");
		pedirDonde.add("Donde quereis quedar?. Lo mejor es que me digais un lugar bien conocido.");
		pedirDonde.add("Ahora teneis que decirme el sitio. Procurad que sea conocido para encontraros a otro grupo cuanto antes :)");
		
		List<String> imperativoDonde = new ArrayList<String>();
		imperativoDonde.add("Sois unos cansinos..decidme donde quereis quedar!");
		imperativoDonde.add("No tengo todo el dia, sabeis el lugar u os da igual?");
		
		List<String> confirmacionDonde = new ArrayList<String>();
		confirmacionDonde.add("Vale, ya tenemos el lugar para quedar");
		confirmacionDonde.add("Ese lugar me suena ;)");
	/*///////////////////// */
		
	/* Obtener fecha y hora */	
		List<String> pedirFechayHora = new ArrayList<String>();
		pedirFechayHora.add("Cuando quereis quedar con el otro grupo?");
		pedirFechayHora.add("Cuando os gustaria quedar con el otro grupo?");
		pedirFechayHora.add("Cuando quereis hacer la quedada con el otro grupo?");
		
		List<String> imperativopedirFechayHora = new ArrayList<String>();
		imperativopedirFechayHora.add("No podre encontrar a otro grupo para quedar a menos que me digais cuando quereis quedar..");
		imperativopedirFechayHora.add("Por favor, necesito saber cuando quereis quedar");
		imperativopedirFechayHora.add("Yo tambien tengo vida...dime cuando quereis quedar, anda");
		
		List<String> confirmarFechayHora = new ArrayList<String>();
		confirmarFechayHora.add("Perfecto!! Ya tenemos la fecha y la hora ;)");
		confirmarFechayHora.add("Vale, esa fecha es valida");
		
		List<String> pedirFecha = new ArrayList<String>();
		pedirFecha.add("Que dia exacto quereis quedar?");
		
		List<String> fechaAnterior = new ArrayList<String>();
		fechaAnterior.add("Jajaja estais locos, no podeis quedar en un dia que ya ha pasado! Decidme un dia a partir de hoy.");
		fechaAnterior.add("A pesar de que estais hablando con un bot, la tecnologia no ha avanzado suficiente como para viajar en el tiempo jajaja. Decidme un dia a partir de hoy.");
		
		List<String> pedirHora = new ArrayList<String>();
		pedirHora.add("A que hora exacta os gustaria quedar?");
	/*///////////////////// */
				
	/* Confirmar quedada*/	
		List<String> confirmarQuedada = new ArrayList<String>();
		confirmarQuedada.add("Voy a buscaros un grupo. Dadme un momen, please!!");
		confirmarQuedada.add("Comenzare a buscaros al otro grupo para que quedeis ;)");
		
		List<String> imperativoConfirmarQuedada = new ArrayList<String>();
		imperativoConfirmarQuedada.add("Ya estamos acabando. Dime, confirmas esta quedada?");
		imperativoConfirmarQuedada.add("animo, esto ya es lo ultimo...me confirmas la quedada?");
	/*///////////////////// */
		
	/* Confirmar quedada*/	
		List<String> rechazarQuedada = new ArrayList<String>();
		rechazarQuedada.add("Siento no haber podido ayudarte ;(. Espero que volvamos a hablar pronto. Chaoo");
		rechazarQuedada.add("Me he saturado. Volvamos a empezar de cero ;)");
	
		List<String> imperativorechazarQuedada = new ArrayList<String>();
		imperativorechazarQuedada.add("Ya estamos acabando. Dime, confirmas esta quedada?");
		imperativorechazarQuedada.add("animo, esto ya es lo ultimo...me confirmas la quedada?");
	/*///////////////////// */
		
		
		
	/* Agregamos los dialogos a la conversacion global */
		conversacionGrupo.put("sinContexto", sinContexto);
		conversacionGrupo.put("pedirInfoOtroGrupo", pedirInfoOtroGrupo);
		conversacionGrupo.put("confirmacionInfoOtroGrupo", confirmacionInfoOtroGrupo);
		
		conversacionGrupo.put("pedirInfoOtroGrupo_numIntegrantes", pedirInfoOtroGrupo_numIntegrantes);
		conversacionGrupo.put("errorInfoOtroGrupo_numIntegrantes", errorInfoOtroGrupo_numIntegrantes);
		conversacionGrupo.put("imperativoInfoOtroGrupo_numIntegrantes", imperativoInfoOtroGrupo_numIntegrantes);
		
		conversacionGrupo.put("pedirInfoOtroGrupo_edad", pedirInfoOtroGrupo_edad);
		conversacionGrupo.put("imperativoInfoOtroGrupo_edad", imperativoInfoOtroGrupo_edad);
		conversacionGrupo.put("errorInfoOtroGrupo_edad", errorInfoOtroGrupo_edad);
		
		conversacionGrupo.put("pedirInfoOtroGrupo_sexo", pedirInfoOtroGrupo_sexo);
		conversacionGrupo.put("confirmacionInfoOtroGrupo_sexo", confirmacionInfoOtroGrupo_sexo);
		conversacionGrupo.put("imperativoInfoOtroGrupo_sexo", imperativoInfoOtroGrupo_sexo);
		
		conversacionGrupo.put("imperativoPedirInfoOtroGrupo", imperativoPedirInfoOtroGrupo);
		
		conversacionGrupo.put("pedirQueHacer", pedirQueHacer);
		conversacionGrupo.put("imperativoQueHacer", imperativoQueHacer);
		conversacionGrupo.put("confirmacionQueHacer", confirmacionQueHacer);
		conversacionGrupo.put("pedirDonde", pedirDonde);
		conversacionGrupo.put("imperativoDonde", imperativoDonde);
		conversacionGrupo.put("confirmacionDonde", confirmacionDonde);
		conversacionGrupo.put("pedirFechayHora", pedirFechayHora);
		conversacionGrupo.put("pedirHora", pedirHora);
		conversacionGrupo.put("pedirFecha", pedirFecha);
		conversacionGrupo.put("fechaAnterior", fechaAnterior);
		conversacionGrupo.put("imperativopedirFechayHora", imperativopedirFechayHora);
		conversacionGrupo.put("confirmarFechayHora", confirmarFechayHora);
		conversacionGrupo.put("confirmarQuedada", confirmarQuedada);
		conversacionGrupo.put("rechazarQuedada", rechazarQuedada);
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
