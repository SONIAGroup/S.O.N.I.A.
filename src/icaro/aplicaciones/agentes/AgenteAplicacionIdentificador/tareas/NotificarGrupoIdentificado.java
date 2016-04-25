package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.informacion.gestionQuedadas.NotificacionIdentificado;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;

/**
 *
 * @author SONIAGroup
 */
public class NotificarGrupoIdentificado extends TareaComunicacion {

	@Override
	public void ejecutar(Object... params) {

		this.getIdentTarea();
		this.getIdentAgente();
		Grupo gr = (Grupo) params[0];
		try {

			
			
			NotificacionIdentificado ngri = new NotificacionIdentificado(gr);
			ngri.setTipoNotificacion("identificado");
			
			this.informaraOtroAgente(ngri, VocabularioGestionQuedadas.IdentAgenteIdentificador);
			this.informaraOtroAgente(ngri, VocabularioGestionQuedadas.IdentAgenteAplicacionDialogoQuedadas);
			//this.informaraOtroAgente(ngri, VocabularioGestionQuedadas.IdentAgenteAplicacionDialogoPaciente);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
