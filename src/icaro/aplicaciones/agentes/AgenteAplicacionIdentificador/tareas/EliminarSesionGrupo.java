/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools.tipoNotif;
import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.informacion.gestionCitas.NotificacionMedico;
import icaro.aplicaciones.informacion.gestionCitas.NotificacionPaciente;
import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.informacion.gestionQuedadas.FocoGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

/**
 *
 * @author SONIAGroup
 */
public class EliminarSesionGrupo extends TareaComunicacion{

	@Override
	public void ejecutar(Object... params) {
		String grupo = (String) params[0];
		try {

			for (Object g : this.getEnvioHechos().getItfMotorDeReglas()
					.getStatefulKnowledgeSession().getObjects()) {

				if (g instanceof Objetivo) {
					Objetivo ob = (Objetivo) g;
					if (ob.getobjectReferenceId().equals(grupo)) {
						this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
					}
				}

				if(g instanceof FocoGrupo ){
					FocoGrupo fc = (FocoGrupo) g;
					if(fc.getGrupo().equals(grupo)){
						this.getEnvioHechos().eliminarHechoWithoutFireRules(fc);
					}
				}
				
				if(g instanceof Grupo ){
					Grupo gr = (Grupo) g;
					if(gr.grupo.equals(grupo)){
						this.getEnvioHechos().eliminarHechoWithoutFireRules(gr);
					}
				}
			
			}
			/*
			Notificacion notif = new Notificacion(grupo);
			notif.tipoNotificacion = tipoNotif.session;

			this.informaraOtroAgente(new NotificacionMedico(notif),
					VocabularioGestionCitas.IdentAgenteAplicacionDialogoMedico);

			this.informaraOtroAgente(new NotificacionPaciente(notif),
					VocabularioGestionCitas.IdentAgenteAplicacionDialogoPaciente);
			*/
			
			// this.getEnvioHechos().insertarHecho(new MemUsuario());
			// this.getEnvioHechos().insertarHechoWithoutFireRules(new Focus());
			// this.getEnvioHechos().insertarHecho(new
			// ObtenerInformacionUsuario());

		} catch (Exception e) {
			e.printStackTrace();
			trazas.aceptaNuevaTraza(new InfoTraza(this.getIdentAgente(),
					"Error al ejecutar la tarea : " + this.getIdentTarea() + e,
					InfoTraza.NivelTraza.error));
		}
	}

}
