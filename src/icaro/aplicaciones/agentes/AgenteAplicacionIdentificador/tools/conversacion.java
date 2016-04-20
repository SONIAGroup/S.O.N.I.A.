package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class conversacion {
	
	private static Random randomGenerator;
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
		
		List<String> confirmarSexo = new ArrayList<String>();
		confirmarSexo.add("ok sexo");
		
		List<String> inactividad = new ArrayList<String>();
		inactividad.add("Que sola estoy! Que sola!! Decidme algo ;(");
		inactividad.add("Contestadme ya pesaos!!");
		inactividad.add("Soy una chica muy ocupada, no puedo estar esperandoos eternamente!!");
		inactividad.add("Como no me contesteis ya mismo os apago el PC! Que a parte de organizar quedadas tambien soy una chica hacker :P");
		
		List<String> grupoRegistrado = new ArrayList<String>();
		grupoRegistrado.add("Andaaa pero si ya os tenia registrados, tengo memoria pez disculpadme :(");
		grupoRegistrado.add("Ya os tengo localizados! Me alegro que hayais vuelto! Aunque no os he echado de menos ;)");
		grupoRegistrado.add("Anda que bien! Si ya os tengo registrados de otra vez. Me alegro de veros!");
		
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
		sincontexto.add("Lo siento pero no te entiendo, mis creadores solo me han ense�ado a organizar quedadas entre grupos ;(");
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
		peticionIDGrupo.add("Lo primero que necesito es vuestro identificador de grupo. Si no teneis ninguno no os preocupeis, inventaroslo ahora mismo!");
		peticionIDGrupo.add("Cual es vuestro identificador de grupo? Si no sabeis de que hablo inventaros un nick que os identifique como grupo!");
		peticionIDGrupo.add("Decidme please vuestro identificador de grupo. Si no teneis ninguno es buen momento para pensar uno ;)");
		
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
		
		List<String> peticionIDGrupoImperativo = new ArrayList<String>(); 
		peticionIDGrupoImperativo.add("Si no me decis vuestro identificador de grupo no puedo seguir :(");
		peticionIDGrupoImperativo.add("Vengaaa, dadme vuestro identificador de grupo o inventaros uno!");
		peticionIDGrupoImperativo.add("Que pesaos!! Quereis darme ya vuestro identificador de grupo?");
		
		List<String> peticionEdadImperativo = new ArrayList<String>(); 
		peticionEdadImperativo.add("Si no me decis la edad media de vuestro grupo no puedo seguir :(");
		peticionEdadImperativo.add("Vengaaaaaaa, decidme vuestra edad media!");
		peticionEdadImperativo.add("Que pesaos sois!! Quereis decirme ya cual es la edad media de vuestro grupo?");
		
		List<String> peticionNumIntegrantesImperativo = new ArrayList<String>(); 
		peticionNumIntegrantesImperativo.add("dame tu num integ ya!!");
		
		List<String> peticionSexoImperativo = new ArrayList<String>(); 
		peticionSexoImperativo.add("dame tu sex ya!!");
		
		List<String> fechaAnterior = new ArrayList<String>(); 
		fechaAnterior.add("Disculpe, la fecha en la que quiere la cita es anterior a la fecha actual, introduzca una fecha v�lida");
		fechaAnterior.add("Parece que ya ha pasado el d�a deseado para la cita");
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
		conversacion.put("confirmarSexo", confirmarSexo);
		conversacion.put("inactividad", inactividad);
		conversacion.put("grupoRegistrado", grupoRegistrado);
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
		conversacion.put("solicitarNombreImperativo", solicitarNombreImperativo);
		conversacion.put("peticionIDGrupoImperativo", peticionIDGrupoImperativo);
		conversacion.put("peticionEdadImperativo", peticionEdadImperativo);
		conversacion.put("peticionNumIntegrantesImperativo", peticionNumIntegrantesImperativo);
		conversacion.put("peticionSexoImperativo", peticionSexoImperativo);
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
