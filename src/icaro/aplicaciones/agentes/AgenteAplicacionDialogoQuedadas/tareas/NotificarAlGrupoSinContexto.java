package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools.conversacion;
import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;			// Cambiarlo por el VocabularioGestionQuedadas, añadiendo lo que necesites!!
import icaro.aplicaciones.informacion.gestionQuedadas.FocoGrupo;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 *
 * @author Jorge Casas Hernán
 */
public class NotificarAlGrupoSinContexto extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;
	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		FocoGrupo foGrupo = (FocoGrupo) params[0];
		String mensajeAenviar = "";
		try {
			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionCitas.IdentRecursoComunicacionChat);
			
			if(foGrupo.intentos < 1){
				mensajeAenviar = conversacion.msg("sincontexto");
				foGrupo.intentos = foGrupo.intentos+1;
			}else{
				if(foGrupo.getFoco().getgoalId().equals("ObtenerIDGrupo")){
					mensajeAenviar = conversacion.msg("peticionIDGrupoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerEdad")){
					mensajeAenviar = conversacion.msg("peticionEdadImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerNumIntegrantes")){
					mensajeAenviar = conversacion.msg("peticionNumIntegrantesImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerSexo")){
					mensajeAenviar = conversacion.msg("peticionSexoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("DistribuirMensaje")){
					mensajeAenviar = conversacion.msg("solicitarAccionImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco() == null){
					mensajeAenviar = conversacion.msg("");
					foGrupo.intentos = 0;
				}
				
			}
			
			if (recComunicacionChat != null) {
			
				recComunicacionChat.comenzar(identAgenteOrdenante);
				recComunicacionChat.enviarMensagePrivado(foGrupo.getGrupo(),
						mensajeAenviar);
			} else {
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
			e.printStackTrace();
		}
	}
}
