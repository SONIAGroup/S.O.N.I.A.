package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools.conversacion;
import icaro.aplicaciones.informacion.gestionQuedadas.FocoGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 *
 * @author Francisco J Garijo
 */
public class NotificarAlContextoIncorrecto extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;
	
	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		FocoGrupo foGrupo = (FocoGrupo) params[0];
		String mensajeAenviar = "";
		try {
			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
			
				mensajeAenviar 		= conversacion.msg("semanticoErroneo");
				foGrupo.intentos 	= foGrupo.intentos+1;
		
			if (recComunicacionChat != null) {
				recComunicacionChat.comenzar(identAgenteOrdenante);
				recComunicacionChat.enviarMensagePrivado(foGrupo.getGrupo(), mensajeAenviar);
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
			e.printStackTrace();
		}
	}
}
