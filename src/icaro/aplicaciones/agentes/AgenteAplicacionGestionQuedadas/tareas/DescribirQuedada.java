/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionGestionQuedadas.tareas;

import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 * 
 * @author SONIAGroup
 *
 */
public class DescribirQuedada extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea 	= this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		String identInterlocutor 	= (String) params[0];
		Quedada quedada 			= (Quedada) params[1];
		Grupo grupo					= (Grupo) params[2];
		try {
			
			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
			
			if (recComunicacionChat != null) {
				recComunicacionChat.comenzar(identAgenteOrdenante);
				String idOtroGrupo = null;
				String msgConfirmada = null;
				if (quedada.getGrupoQueAcepta() != null){
					if (quedada.getGrupoQueAcepta().getId().equals(grupo.getId())) {
						idOtroGrupo = quedada.getGrupoEmisor().getId();
						if (quedada.getConfirmada())
							msgConfirmada = "El grupo " + idOtroGrupo + " ya ha confirmado que asistira!";
						else
							msgConfirmada = "El grupo " + idOtroGrupo + " aun no ha confirmado la quedada, pero no os preocupeis que en cuanto sepa algo os lo digo";
					}
					else {
						idOtroGrupo = quedada.getGrupoQueAcepta().getId();
						msgConfirmada = "Ya avise al grupo " + idOtroGrupo + " confirmandoles que vais a asistir!";
					}
				}
				
				String mensajeAenviar = null;
				if (idOtroGrupo == null)
					mensajeAenviar = "Teneis creada una quedada para " + quedada.toString() + ", pero todavia no he encontrado ningun grupo interesado :(";
				else
					mensajeAenviar = "Recordad que habeis quedado con el grupo " + idOtroGrupo + " para " + quedada.toString() + ". " + msgConfirmada;
				recComunicacionChat.enviarMensagePrivado(identInterlocutor, mensajeAenviar);
				
			} 
			else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(
						identDeEstaTarea,
						contextoEjecucionTarea,
						identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionQuedadas.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
		} catch (Exception e) {
			this.generarInformeConCausaTerminacion(
					identDeEstaTarea,
					contextoEjecucionTarea,
					identAgenteOrdenante,
					"Error-Acceso:Interfaz:"
							+ VocabularioGestionQuedadas.IdentRecursoComunicacionChat,
					CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}

}
