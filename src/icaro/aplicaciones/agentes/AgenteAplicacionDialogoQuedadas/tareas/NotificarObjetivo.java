package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools.tipoNotif;
import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.informacion.gestionQuedadas.NotificacionObjetivo;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;

/**
 *
 * @author Francisco J Garijo
 */
public class NotificarObjetivo extends TareaComunicacion {

	@Override
	public void ejecutar(Object... params) {

		String identInterlocutor = (String) params[0];
		Notificacion notif = (Notificacion) params[1];
		String Objetivo = (String) params[2];
		
		try {
			NotificacionObjetivo no = null;
			
			if(notif != null){
				no 		  = new NotificacionObjetivo(notif);
				no.agente = Objetivo;
				no.tipoNotificacion = tipoNotif.objetivo;
			}
			else {
				no 		  = new NotificacionObjetivo();
				no.agente = Objetivo;
				no.identNotificador = identInterlocutor;
				no.tipoNotificacion = tipoNotif.objetivo;
			}

			this.informaraOtroAgente(no, VocabularioGestionQuedadas.IdentAgenteIdentificador);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}