package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.informacion.gestionQuedadas.NotificacionQuedada;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;

/**
 *
 * @author SONIAGroup
 */
public class Distribuir extends TareaComunicacion {

	@Override
	public void ejecutar(Object... params) {

		this.getIdentTarea();
		this.getIdentAgente();
		Notificacion notif = (Notificacion) params[0];
		String idAgente = (String) params[1];
		try {
			if (idAgente.equals(VocabularioGestionQuedadas.IdentAgenteAplicacionDialogoQuedadas)) {
				this.informaraOtroAgente(new NotificacionQuedada(notif), idAgente);
			}// else if (idAgente.equals(VocabularioGestionQuedadas.IdentAgenteAplicacionDialogoPaciente)) {
			//	this.informaraOtroAgente(new NotificacionPaciente(notif), idAgente);
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
