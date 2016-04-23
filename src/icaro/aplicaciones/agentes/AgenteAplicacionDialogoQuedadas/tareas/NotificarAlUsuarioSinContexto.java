package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tools.ConversacionGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.FocoUsuario;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 * 
 * @author Mariano Hernández García
 *
 */
public class NotificarAlUsuarioSinContexto extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;
	
	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea 	= this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		FocoUsuario foUsuario 		= (FocoUsuario) params[0];
		String mensajeAenviar 		= "";
		
		try {
			
			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
			
			if( foUsuario.intentos < 3 ) {
				mensajeAenviar = ConversacionGrupo.msg("sinContexto");
				foUsuario.intentos = foUsuario.intentos + 1;
			}
			else {
				
				Objetivo obj = foUsuario.getFoco();
				
				if ( obj == null ) {
					mensajeAenviar = ConversacionGrupo.msg("");
					foUsuario.intentos = 0;
				}
				else {
					String objId = obj.getgoalId();
					
					switch (objId) {
						
						case "ObtenerNumIntegrantesOtroGrupo":
							mensajeAenviar = ConversacionGrupo.msg("pedirInfoOtroGrupo_numPersonas");
						break;
						
						case "ObtenerEdadOtroGrupo":
							mensajeAenviar = ConversacionGrupo.msg("pedirInfoOtroGrupo_edad");
						break;
						
						case "ObtenerSexoOtroGrupo":
							mensajeAenviar = ConversacionGrupo.msg("pedirInfoOtroGrupo_sexo");
						break;
						
						case "ObtenerQueHacer":
							mensajeAenviar = ConversacionGrupo.msg("imperativoQueHacer");
						break;
						
						case "ObtenerDonde":
							mensajeAenviar = ConversacionGrupo.msg("imperativoDonde");
						break;
						
						case "ObtenerCuando":
							mensajeAenviar = ConversacionGrupo.msg("imperativopedirFechayHora");
						break;
	
						default:
							mensajeAenviar = ConversacionGrupo.msg("");
						break;
					}
					
					foUsuario.intentos = 0;
				}
		
				
			}
			
			if (recComunicacionChat != null) {
			
				recComunicacionChat.comenzar(identAgenteOrdenante);
				recComunicacionChat.enviarMensagePrivado(foUsuario.getUsuario(), mensajeAenviar);
			} else {
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
