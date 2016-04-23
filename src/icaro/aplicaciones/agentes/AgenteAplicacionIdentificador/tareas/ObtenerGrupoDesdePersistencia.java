/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.ObtenerEdad;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.ObtenerNumIntegrantes;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.ObtenerSexo;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools.conversacion;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.aplicaciones.recursos.persistenciaGrupos.ItfPersistenciaGrupos;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 *  Esta clase se encarga de...
 *  
 * @author Jorge
 *
 */
public class ObtenerGrupoDesdePersistencia extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea     = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		String identInterlocutor    = (String) params[0];
		Grupo gr 					= (Grupo) params[1];
		
		try {

			// Se busca la interfaz del recurso en el repositorio de interfaces

			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
			ItfPersistenciaGrupos persistencia = (ItfPersistenciaGrupos) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoPersistenciaGrupos);
			Grupo ngr = persistencia.obtenerGrupoById(gr.getId());
			
			if (ngr != null) {
				//cu.setNombre(ncu.getNombre());
				//Objetivo f = new ObtenerNombre();
				//f.setSolved();
				gr.setNumIntegrantes(ngr.getNumIntegrantes());
				Objetivo objetivoNumIntegrantes = new ObtenerNumIntegrantes();
				objetivoNumIntegrantes.setSolved();
				objetivoNumIntegrantes.setobjectReferenceId(gr.getId());
				this.getEnvioHechos().insertarHechoWithoutFireRules(objetivoNumIntegrantes);
				
				gr.setEdad(ngr.getEdad());
				Objetivo objetivoEdad = new ObtenerEdad();
				objetivoEdad.setSolved();
				objetivoEdad.setobjectReferenceId(gr.getId());
				this.getEnvioHechos().insertarHechoWithoutFireRules(objetivoEdad);
				
				gr.setSexo(ngr.getSexo());
				Objetivo objetivoSexo = new ObtenerSexo();
				objetivoSexo.setSolved();
				objetivoSexo.setobjectReferenceId(gr.getId());
				this.getEnvioHechos().insertarHechoWithoutFireRules(objetivoSexo);
				
				this.getEnvioHechos().actualizarHecho(gr);

				if (recComunicacionChat != null) {
					recComunicacionChat.comenzar(identAgenteOrdenante);
					String mensajeAenviar = conversacion.msg("grupoRegistrado");
					recComunicacionChat.enviarMensagePrivado(identInterlocutor, mensajeAenviar);
				}

			} 
			else {

				if (recComunicacionChat != null) {
					recComunicacionChat.comenzar(identAgenteOrdenante);
					String mensajeAenviar = conversacion.msg("grupoNoRegistrado");
					recComunicacionChat.enviarMensagePrivado(identInterlocutor, mensajeAenviar);
				}

			}

		} catch (Exception e) {
			this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, 
					"Error-Acceso:Interfaz:" + VocabularioGestionQuedadas.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}

}
