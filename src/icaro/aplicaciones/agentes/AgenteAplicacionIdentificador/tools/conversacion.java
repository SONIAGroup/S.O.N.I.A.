package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class conversacion {
	
	private static HashMap<String,List<String>> conversacion;
	
	static{
		conversacion = new HashMap<String, List<String>>();
		
		List<String> saludoInicial = new ArrayList<String>();
		saludoInicial.add("Hola! Soy SONIA, una chica bot creada para organizar quedadas entre grupos de amigos que no se conocen.");
		saludoInicial.add("Buenas tardes! Estais preparados para quedar con un magnifico grupo de amigos y pasarlo genial?");
		
		List<String> solicitarNuevamenteIDGrupo = new ArrayList<String>();
		solicitarNuevamenteIDGrupo.add("Ahora si que si necesito vuestro identificador de grupo.");
		solicitarNuevamenteIDGrupo.add("Necesito ahora ya si que me deis vuestro identificador de grupo.");
		solicitarNuevamenteIDGrupo.add("Decidme ahora si que si vuestro identificador de grupo, pleasee.");
		
		
		List<String> saludoInicialNoSaludo = new ArrayList<String>();
		saludoInicialNoSaludo.add("Me gusta que me saluden antes jeje ;)");
		saludoInicialNoSaludo.add("En primer lugar hola. Soy una chica educada, no como tu que ni saludas. Jajja es broma! Soy una maquina pero tengo sentido del humor :)");
		saludoInicialNoSaludo.add("Se te ha olvidado el hola xD");
		saludoInicialNoSaludo.add("Te parece bonito no saludarme tan siquiera? :P");
		
		List<String> solicitarNombre = new ArrayList<String>();
		solicitarNombre.add("Msg SolicitarNombre");
		solicitarNombre.add("Mensaje de SolicitarNombre.");
		
		List<String> solicitarNombreImperativo = new ArrayList<String>();
		solicitarNombreImperativo.add("Para continuar le recuerdo que necesito su nombre");
		solicitarNombreImperativo.add("por favor coopere, digame su nombre");
		solicitarNombreImperativo.add("realmente necesito su nombre, por favor");
	
		List<String> solicitarAccionImperativo = new ArrayList<String>();
		solicitarAccionImperativo.add("Me gustaria saber si me piensa decir que quiere hacer");
		solicitarAccionImperativo.add("Por favor sea concreto, digame que quiere");
		solicitarAccionImperativo.add("Le recuerdo que solo puedo ayudarlo con asuntos de citas medicas");
		
		List<String> prePersistenciaGrupo = new ArrayList<String>();
		prePersistenciaGrupo.add("Perfecto! Dejadme un segundo que apunte vuestros datos y enseguida estoy con vosotros.");
		prePersistenciaGrupo.add("Genial! Ya tengo todo lo que necesito, dadme un segundo para que lo apunte.");
		prePersistenciaGrupo.add("Bien! Voy a apuntar vuestros datos y ahora os sigo contando.");
		
		List<String> persistenciaGrupoCompletada = new ArrayList<String>();
		persistenciaGrupoCompletada.add("Listo! La proxima vez que entreis me acordare de vosotros ;)");
		
		List<String> inactividad = new ArrayList<String>();
		inactividad.add("Que sola estoy! Que sola!! Decidme algo ;(");
		inactividad.add("Contestadme ya pesaos!!");
		inactividad.add("Soy una chica muy ocupada, no puedo estar esperandoos eternamente!!");
		inactividad.add("Como no me contesteis ya mismo os apago el PC! Que a parte de organizar quedadas tambien soy una chica hacker :P");
		
		List<String> solicitarPass = new ArrayList<String>();
		solicitarPass.add("Ya os tengo identificados, pero por seguridad decidme el numero de telefono con el que os registrasteis.");
		solicitarPass.add("Genial! Os tengo por aqui apuntados! Para asegurarme que sois vosotros decidme please el numero de telefono con el que os registrasteis.");
		
		List<String> passIncorrecta = new ArrayList<String>();
		passIncorrecta.add("Lo siento pero no habeis puesto el numero correcto. Volvedme a decir vuestro identificador de grupo. O si no teneis ninguno inventaroslo! No pasa nada!");
		passIncorrecta.add("Ups, el numero que habeis puesto no es el que tengo apuntado. Volvedme a decir de nuevo vuestro identificador de grupo, o si no inventaros uno ahora mismo!");
		
		List<String> passCorrecta = new ArrayList<String>();
		passCorrecta.add("Genial! Ahora si que estoy segura de que vois vosotros!");
		passCorrecta.add("Ya os tengo localizados! Me alegro que hayais vuelto! Aunque no os he echado de menos ;)");
		passCorrecta.add("Me alegro de veros de nuevo! :)");
		
		List<String> grupoNoRegistrado = new ArrayList<String>();
		grupoNoRegistrado.add("Me encanta que entren a utilizarme grupos nuevos! Necesito saber mas sobre vosotros, veamos...");
		grupoNoRegistrado.add("Encantada de conoceros! Al ser la primera vez que hablo con vosotros necesito saber algunas cosas. A ver...");
		grupoNoRegistrado.add("Encantada de conoceros! Tengo que preguntaros algunas cosas, no es que sea cotilla, es que lo necesito para encontraros grupos afines ;)");
		
		List<String> volverASaludar = new ArrayList<String>();
		volverASaludar.add("Jajaja si ya nos hemos saludado antes!");
		volverASaludar.add("Ya nos hemos saludado antes! Recuerda que soy una maquina, me acuerdo de todo jajja :)");
		
		List<String> ultimaPreguntaIdentificacion = new ArrayList<String>();
		ultimaPreguntaIdentificacion.add("Y la ultima pregunta para terminar de identificaros...");
		ultimaPreguntaIdentificacion.add("Vale, solo me queda ya una pregunta por haceros...");
		ultimaPreguntaIdentificacion.add("Bueno pues ya casi he terminado de identificaros. Solo me queda por haceros una pregunta...");
		
		List<String> sincontexto = new ArrayList<String>(); 
		sincontexto.add("Disculpa que sea tan cortita, pero no te estoy entendiendo ;(");
		sincontexto.add("No me estaras vacilando no? Es que no entiendo de que me estas hablando :(");
		sincontexto.add("Lo siento pero no te entiendo, mis creadores solo me han enseñado a organizar quedadas entre grupos ;(");
		sincontexto.add("Sabes que mi nombre viene de Sistema Organizador de eNcuentros basado en Inteligencia Artificial?? Te digo esto porque no te estoy entendiendo, asi que por decir yo algo jeje.");
		
		List<String> distribucion = new ArrayList<String>(); 
		distribucion.add("Listo, dime en que puedo ayudarte");
		distribucion.add("En que puedo ayudarte?");
		distribucion.add("Que te gustaria hacer hoy?");
		distribucion.add("Estoy a tus ordenes");
		
		List<String> objetivoLogrado = new ArrayList<String>(); 
		objetivoLogrado.add("Para que mas soy bueno?");
		objetivoLogrado.add("En que mas puedo ayudarte?");
		objetivoLogrado.add("En que mas puedo complacerte?");
		objetivoLogrado.add("Estoy a tus ordenes para cualquier otra cosa");
		
		List<String> despedida = new ArrayList<String>(); 
		despedida.add("Espero que volvais pronto. Chaooo :3");
		despedida.add("Hasta pronto!!");
		despedida.add("Adios!! Espero que os hayais llevado una buena impresion de mi :)");
		despedida.add("Hasta la proxima!! :)");
		
		List<String> peticionIDGrupo = new ArrayList<String>(); 
		peticionIDGrupo.add("Lo primero que necesito es vuestro identificador de grupo. Si no teneis ninguno no os preocupeis, inventaroslo ahora mismo!. Importante, tiene que empezar por @");
		peticionIDGrupo.add("Cual es vuestro identificador de grupo? Si no sabeis de que hablo inventaros un @nick que os identifique como grupo!");
		peticionIDGrupo.add("Decidme, please, vuestro identificador de grupo. Si no teneis ninguno es buen momento para pensar uno. Tiene que empezar por @ y luego el nombre que tu quieras!!. Por ejemplo, el mio es @soniabot");
		
		List<String> peticionEdad = new ArrayList<String>(); 
		peticionEdad.add("Cual es la edad media aproximada de vuestro grupo?");
		peticionEdad.add("Me podeis decir cual es vuestra edad media aproximada?");
		peticionEdad.add("Aproximadamente cual es la edad media que teneis?");
		
		List<String> peticionNumIntegrantes = new ArrayList<String>(); 
		peticionNumIntegrantes.add("De cuantas personas esta constituido vuestro grupo?");
		peticionNumIntegrantes.add("Cuantos sois en el grupo?");
		peticionNumIntegrantes.add("Cuantas personas sois en vuestro grupo?");
		
		List<String> peticionSexo = new ArrayList<String>(); 
		peticionSexo.add("Vuestro grupo es de hombres, de mujeres o mixto?");
		peticionSexo.add("Que sois en vuestro grupo, hombres, mujeres, o sois un grupo mixto?");
		peticionSexo.add("Sois todos hombres, mujeres, o vuestro grupo es mixto?");
		
		List<String> peticionTelefono = new ArrayList<String>(); 
		peticionTelefono.add("Podeis darme un numero de movil? Solo lo usare para que el grupo con el que quedeis pueda ponerse en contacto con vosotros, siempre con vuestra confirmacion.");
		peticionTelefono.add("Me decis un numero de movil? Tranquilos que no lo dare sin vuestro permiso, es para poneros en contacto con el grupo con el que quedeis.");
		peticionTelefono.add("Me dais un numero de movil? Lo necesito para que un grupo afin pueda ponerse en contacto con vosotros, pero no os preocupeis que no lo dare a nadie sin vuestro permiso.");
		
		List<String> peticionIDGrupoImperativo = new ArrayList<String>(); 
		peticionIDGrupoImperativo.add("Si no me decis vuestro identificador de grupo no puedo seguir :(");
		peticionIDGrupoImperativo.add("Vengaaa, dadme vuestro identificador de grupo o inventaros uno!");
		peticionIDGrupoImperativo.add("Que pesaos!! Quereis darme ya vuestro identificador de grupo?");
		
		List<String> peticionEdadImperativo = new ArrayList<String>(); 
		peticionEdadImperativo.add("Si no me decis la edad media de vuestro grupo no puedo seguir :(");
		peticionEdadImperativo.add("Vengaaaaaaa, decidme vuestra edad media!");
		peticionEdadImperativo.add("Que pesaos sois!! Quereis decirme ya cual es la edad media de vuestro grupo?");
		
		List<String> peticionNumIntegrantesImperativo = new ArrayList<String>(); 
		peticionNumIntegrantesImperativo.add("Decidme cuantos sois en el grupo ya! Que sois unos pesaos!");
		peticionNumIntegrantesImperativo.add("En serio, necesito saber cuantos sois en el grupo.");
		peticionNumIntegrantesImperativo.add("No os vayais por las ramas, decidme cuantos sois en el grupo ya!");
		
		List<String> peticionSexoImperativo = new ArrayList<String>(); 
		peticionSexoImperativo.add("Quereis decirme ya si sois hombres, mujeres o si sois un grupo mixto?");
		peticionSexoImperativo.add("Dejaos de tonterias y decirme si sois hombres, mujeres o un grupo mixto.");
		
		List<String> peticionTelefonoImperativo = new ArrayList<String>(); 
		peticionTelefonoImperativo.add("En serio, necesito un numero de movil!");
		peticionTelefonoImperativo.add("Si no me dais un numero de movil no puedo seguir :(");
		
		List<String> fechaAnterior = new ArrayList<String>(); 
		fechaAnterior.add("Disculpe, la fecha en la que quiere la cita es anterior a la fecha actual, introduzca una fecha válida");
		fechaAnterior.add("Parece que ya ha pasado el día deseado para la cita");
		fechaAnterior.add("Introduzca una fecha futura");
		
		List<String> semanticoErroneo = new ArrayList<String>(); 
		semanticoErroneo.add("y que quieres que haga con eso?");
		semanticoErroneo.add("me gustaria que me diga realmente lo que le pido");
		semanticoErroneo.add("mmmmm... no me interesa, hablemos de algo mas interesanto");
		
		List<String> solicitarAccion = new ArrayList<String>(); 
		solicitarAccion.add("Le sugiero que me diga que le gustaria hacer");
		solicitarAccion.add("Podria sugerirle, que me diga algo relacionado con pedir citas");
		solicitarAccion.add("Podria sugerirle, que me diga algo relacionado con consultar citas");
		
		conversacion.put("solicitarAccion", solicitarAccion);
		conversacion.put("saludoInicial", saludoInicial);
		conversacion.put("saludoInicialNoSaludo", saludoInicialNoSaludo);
		conversacion.put("solicitarNombre", solicitarNombre);
		conversacion.put("prePersistenciaGrupo", prePersistenciaGrupo);
		conversacion.put("persistenciaGrupoCompletada", persistenciaGrupoCompletada);
		conversacion.put("inactividad", inactividad);
		conversacion.put("solicitarPass", solicitarPass);
		conversacion.put("passIncorrecta", passIncorrecta);
		conversacion.put("passCorrecta", passCorrecta);
		conversacion.put("grupoNoRegistrado", grupoNoRegistrado);
		conversacion.put("volverASaludar", volverASaludar);
		conversacion.put("ultimaPreguntaIdentificacion", ultimaPreguntaIdentificacion);
		conversacion.put("sincontexto", sincontexto);
		conversacion.put("distribucion", distribucion);
		conversacion.put("objetivoLogrado", objetivoLogrado);
		conversacion.put("despedida", despedida);
		conversacion.put("peticionIDGrupo", peticionIDGrupo);
		conversacion.put("peticionEdad", peticionEdad);
		conversacion.put("peticionNumIntegrantes", peticionNumIntegrantes);
		conversacion.put("peticionSexo", peticionSexo);
		conversacion.put("peticionTelefono", peticionTelefono);
		conversacion.put("solicitarNombreImperativo", solicitarNombreImperativo);
		conversacion.put("peticionIDGrupoImperativo", peticionIDGrupoImperativo);
		conversacion.put("peticionEdadImperativo", peticionEdadImperativo);
		conversacion.put("peticionNumIntegrantesImperativo", peticionNumIntegrantesImperativo);
		conversacion.put("peticionSexoImperativo", peticionSexoImperativo);
		conversacion.put("peticionTelefonoImperativo", peticionTelefonoImperativo);
		conversacion.put("solicitarAccionImperativo", solicitarAccionImperativo);
		conversacion.put("semanticoErroneo", semanticoErroneo);
		conversacion.put("fechaAnterior", fechaAnterior);
		conversacion.put("solicitarNuevamenteIDGrupo", solicitarNuevamenteIDGrupo);		
	}
	
	
	public static String msg(String tipo){
		/*String result = null;
		randomGenerator = new Random(new Date().getTime());
		if(conversacion.get(tipo) != null && conversacion.get(tipo).size() > 0){
	        int index = randomGenerator.nextInt(conversacion.get(tipo).size());
	        String item = conversacion.get(tipo).get(index);		
			return item;
		}
				
		return result;*/
		String msg = null;
		if(conversacion.get(tipo) != null && conversacion.get(tipo).size() > 0){
			int index = (int)(System.currentTimeMillis() % conversacion.get(tipo).size());
			msg = conversacion.get(tipo).get(index);
		}
		return msg;
	}
	

}
