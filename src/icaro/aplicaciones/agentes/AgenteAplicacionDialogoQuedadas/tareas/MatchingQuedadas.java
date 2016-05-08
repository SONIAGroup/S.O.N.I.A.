/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;

import java.util.ArrayList;
import java.util.Calendar;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import icaro.aplicaciones.informacion.gestionQuedadas.TiposQuedada;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.aplicaciones.recursos.persistenciaQuedadas.ItfPersistenciaQuedadas;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 * 
 * @author Mariano Hernández García
 *
 */
public class MatchingQuedadas extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea 	= this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		String identInterlocutor 	= (String) params[0];
		Quedada quedada 			= (Quedada) params[1];
		
		try {
			
			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
			
			ItfPersistenciaQuedadas persistencia = (ItfPersistenciaQuedadas) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoPersistenciaQuedadas);
			
			if ( recComunicacionChat != null && persistencia != null ) {
				recComunicacionChat.comenzar(identAgenteOrdenante);
				
				String mensajeAenviar = null;
				
				//ArrayList<Quedada> candidatas = persistencia.obtenerQuedadasSinGrupo();
				
				/// PRUEBAS
				
				ArrayList<Quedada> candidatas = new ArrayList<Quedada>();
				
				Grupo g1 = new Grupo();
				g1.setId("idPrueba");
				g1.setEdad(20);
				g1.setNumIntegrantes(4);
				g1.setSexo("hombres");
				
				Quedada q1 = new Quedada("idChat", g1);
				q1.setEdad(25);
				q1.setNumIntegrantes(2);
				q1.setSexo("mujeres");
				q1.setQueHacer(TiposQuedada.beber);
				q1.setDecripcionQueHacer("ir a tomar una cerve");
				q1.setDecripcionQueHacer("sol");
				q1.setFecha("09/05/2016");
				
				candidatas.add(q1);
							
				int a = 0;
				int m = -1;
				for( Quedada q : candidatas ) {
					a = afinidad(q, quedada);
					if ( a > m ) {
						System.out.println("Afinidad: " + a);
						m = a;
					}
				}
				
				// No ha encontrado una quedada..
				if ( m == -1 ) {
					mensajeAenviar = "He encontrado una quedada!!";
				}
				else {
					mensajeAenviar = "No hay quedadas disponibles";
				}
		
				recComunicacionChat.enviarMensagePrivado(identInterlocutor, mensajeAenviar);

			} 
			else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(
						identDeEstaTarea,
						contextoEjecucionTarea,
						identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionCitas.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
		} catch (Exception e) {
			this.generarInformeConCausaTerminacion(
					identDeEstaTarea,
					contextoEjecucionTarea,
					identAgenteOrdenante,
					"Error-Acceso:Interfaz:"
							+ VocabularioGestionCitas.IdentRecursoComunicacionChat,
					CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
	
	private int afinidad(Quedada q1, Quedada q2) {
		int a = 0;
		
		// Si las fechas no coinciden, la afinidad es la menor
		if ( (q1.getFecha().get(Calendar.DAY_OF_MONTH) != q2.getFecha().get(Calendar.DAY_OF_MONTH)) ||
			 (q1.getFecha().get(Calendar.MONTH) != q2.getFecha().get(Calendar.MONTH)) ||
			 (q1.getFecha().get(Calendar.YEAR) != q2.getFecha().get(Calendar.YEAR)) ) {
			
			return -1;
		}
		
		// Si lo que se quiere hacer en ambos planes coincide...
		if ( q1.getQueHacer().equals(q2.getQueHacer()) ) {
			a += 20;
		}
		// Si da igual alguno de lo que se quiere hacer...
		else if ( q1.getQueHacer().equals(TiposQuedada.da_igual) || q2.getQueHacer().equals(TiposQuedada.da_igual) ) {
			a += 10;
		}
		
		if ( q1.getLugar().equals(q2.getLugar()) ) {
			a += 20;
		}
		else if ( q1.getLugar() == null || q2.getLugar() == null ) {
			a += 10;
		}
		
		// Faltan integrantes, edades y sexo...
		
		return a;
	}
	

}
