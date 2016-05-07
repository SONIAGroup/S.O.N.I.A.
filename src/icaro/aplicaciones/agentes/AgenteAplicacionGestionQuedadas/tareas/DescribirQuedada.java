/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionGestionQuedadas.tareas;

import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.aplicaciones.informacion.gestionQuedadas.NotificacionIdentificado;
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
				if (quedada.getGrupoQueAcepta() != null){
					if (quedada.getGrupoQueAcepta().getId().equals(grupo))
						idOtroGrupo = quedada.getGrupoEmisor().getId();
					else
						idOtroGrupo = quedada.getGrupoQueAcepta().getId();
				}
				
				String mensajeAenviar = null;
				if (idOtroGrupo == null)
					mensajeAenviar = "Teneis creada una quedada para " + quedada.toString() + ", pero todavia no he encontrado ningun grupo interesado :(. Quereis cancelar la quedada?";
				else
					mensajeAenviar = "El grupo " + idOtroGrupo + " ha quedado con vosotros para " + quedada.toString() + ". Quereis cancelar la quedada?";
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

}
