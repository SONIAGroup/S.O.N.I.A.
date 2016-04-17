package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.drools.lang.DRLExpressions.neg_operator_key_return;

/**
 * Herramienta que abstrae la conversacion con un usuario (grupo de personas)
 * 
 * @author mariano
 *
 */
public class ConversacionGrupo {
	
	private static Random randomGenerator;
	private static HashMap<String,List<String>> conversacion;
	
	static{
		
		conversacion    = new HashMap<String, List<String>>();
		randomGenerator = new Random();
		
	
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
		conversacion.put("pedirInfoOtroGrupo_numPersonas", pedirInfoOtroGrupo_numPersonas);
		conversacion.put("pedirInfoOtroGrupo_edad", pedirInfoOtroGrupo_edad);
		conversacion.put("pedirInfoOtroGrupo_sexo", pedirInfoOtroGrupo_sexo);
		conversacion.put("imperativoPedirInfoOtroGrupo", imperativoPedirInfoOtroGrupo);
		conversacion.put("confirmacionInfoOtroGrupo", confirmacionInfoOtroGrupo);
		conversacion.put("pedirQueHacer", pedirQueHacer);
		conversacion.put("imperativoQueHacer", imperativoQueHacer);
		conversacion.put("confirmacionQueHacer", confirmacionQueHacer);
		conversacion.put("pedirDonde", pedirDonde);
		conversacion.put("imperativoDonde", imperativoDonde);
		conversacion.put("confirmacionDonde", confirmacionDonde);
		conversacion.put("pedirFechayHora", pedirFechayHora);
		conversacion.put("imperativopedirFechayHora", imperativopedirFechayHora);
		conversacion.put("confirmarFechayHora", confirmarFechayHora);
		conversacion.put("confirmarQuedada", confirmarQuedada);
		conversacion.put("imperativoConfirmarQuedada", imperativoConfirmarQuedada);
			
	}
	
	
	public static String msg(String tipo){
		String result = null;
		
		if(conversacion.get(tipo) != null && conversacion.get(tipo).size() > 0){
	        int index   = randomGenerator.nextInt(conversacion.get(tipo).size());
	        String item = conversacion.get(tipo).get(index);		
			return item;
		}
				
		return result;
	}
	
	
	/*
	// Creo que se puede borrar. Lo debieron hacer sobre la marcha
	public static final String obtenerInfoCita1dameDatos = "Facilitame los datos de la cita (una fecha y un m�dico)";
	public static final String obtenerInfoCita2fechaRegistrada = "Fecha registrada, ahora queda el m�dico";
	public static final String obtenerInfoCita3medicoRegistrado = "M�dico registrado, ahora queda la fecha";
	public static final String obtenerInfoCita4todoCompletado = "Estupendo, la cita se ha realizado con �xito!";
	public static final String obtenerInfoCita4cancelado = "Vale, no le hare la cita";
	public static final String mostrarCitasPaciente = "Estas son sus citas: 1- Cita 1 2- Cita 2  3- Cita 3";
	*/
	

}
