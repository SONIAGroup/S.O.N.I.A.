package icaro.aplicaciones.recursos.comunicacionChat;

import icaro.aplicaciones.agentes.AgenteAplicacionDialogoPaciente.tools.tipoNotifPaciente;
import icaro.aplicaciones.informacion.gestionQuedadas.tipoNotif;
import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.recursos.recursoCalendario.DateUtil;
import icaro.aplicaciones.recursos.recursoCalendario.imp.RecursoCalendarioImp;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class ParserFecha {

	private static final int DIA = 1;
	private static final int SEMANA = 7;
	private static final int MES = 30;
	private static final int ANO = 365;

	/**
	 * Los valores de estas claves se sumar�n/restar�n a la fecha actual
	 */
	private static final Map<String, Integer> MAPEO_FECHAS = new HashMap<String, Integer>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 685284131402410709L;

		{
			put("hoy", 0);
			put("pasado mañana", 2 * DIA);
			put("mañana", DIA);
			put("maniana", DIA);
			put("manana", DIA);
			put("ayer", -DIA);
			put("semana que viene", SEMANA);
			put("semana pr�xima", SEMANA);
			put("semana proxima", SEMANA);
			put("semana siguiente", SEMANA);
			put("siguiente semana", SEMANA);
			put("siguiente semana", SEMANA);
			put("mes que viene", MES);
			put("mes siguiente", MES);
			put("a�o siguiente", ANO);
			put("a�o pr�ximo", ANO);
			put("a�o proximo", ANO);
			put("pr�ximo a�o", ANO);
			put("mes pr�ximo", MES);
			put("mes proximo", MES);
			put("proximo a�o", ANO);
			put("proximo mes", MES);
			put("pr�ximo mes", MES);
			put("pr�xima semana", SEMANA);
			put("proxima semana", SEMANA);
			put("pr�ximo d�a", DIA);
			put("proximo d�a", DIA);
			put("proximo dia", DIA);
		}
	};

	/**
	 * Los valores de estas claves ser�n usados para obtener la fecha
	 * correspondiente al d�a de la semana
	 */
	private static final Map<String, Integer> MAPEO_DIAS_SEMANA = new HashMap<String, Integer>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2170365284292450115L;

		{
			put("lunes", Calendar.MONDAY);
			put("martes", Calendar.TUESDAY);
			put("mi�rcoles", Calendar.WEDNESDAY);
			put("miercoles", Calendar.WEDNESDAY);
			put("jueves", Calendar.THURSDAY);
			put("viernes", Calendar.FRIDAY);
			put("s�bado", Calendar.SATURDAY);
			put("sabado", Calendar.SATURDAY);
			put("domingo", Calendar.SUNDAY);
		}
	};

	/**
	 * Los valores de estas claves ser�n usados para obtener la fecha
	 * correspondiente al d�a del mes
	 */
	private static final Map<String, Integer> MAPEO_DIAS_MES = new HashMap<String, Integer>() {

		/**
			 * 
			 */
		private static final long serialVersionUID = -4299206735179032010L;
		{
			put("primero", 1);
			put("primer", 1);
		}
	};

	private ParserFecha() {
	}

	/**
	 * Dada una notificaci�n con una anotaci�n de tipo "fecha" del tipo
	 * "ma�ana, pasado, ayer, el viernes, etc." la convierte a un mensaje de
	 * tipo "dd/MM/yyyy"
	 * 
	 * @param notif
	 * @return
	 */
	public static final Notificacion parseaFecha(Notificacion notif) {

		String msg = notif.getMensajeNotificacion();

		Integer dias = MAPEO_FECHAS.get(msg);

		if (dias != null) {
			Date date = new Date();
			Date nuevaFecha = DateUtil.addDays(date, dias);
			if (nuevaFecha.before(date)) {
				// enviar notificacion a usuario de que la fecha es anterior a
				// la actual.
				// poner anotacion de fecha anterior a la actual y que el agente
				// espere esta
				// notificacion para enviar mensaje al usuario.
				notif.setTipoNotificacion(tipoNotif.fechaAnterior);
			} else {
				msg = RecursoCalendarioImp.slashFormatter.format(nuevaFecha);
				notif.setMensajeNotificacion(msg);
			}
		} else {

			Integer diaSemana = MAPEO_DIAS_SEMANA.get(msg);
			if (diaSemana != null) {
				Calendar calendar = Calendar.getInstance();
				Date date = new Date();
				calendar.setTime(date);
				calendar.set(Calendar.DAY_OF_WEEK, diaSemana);

				Date msgDate = calendar.getTime();
				
				if (msgDate.before(date)) {
					date = DateUtil.addDays(date, SEMANA);
					calendar.setTime(date);
					calendar.set(Calendar.DAY_OF_WEEK, diaSemana);
					msgDate = calendar.getTime();
				}
				
				msg = RecursoCalendarioImp.slashFormatter.format(msgDate);
				notif.setMensajeNotificacion(msg);
			}
		}

		return notif;
	}

	public static Object parseaFechaNumero(Notificacion notif) {
		notif.setTipoNotificacion(tipoNotifPaciente.fecha);
		String stringNumero;
		int numero=0;
		String msg = notif.getMensajeNotificacion();
		// este mensaje tiene una estructura "el" + <numero>
		String[] divisiones = msg.split(" ");
		stringNumero = divisiones[divisiones.length - 1];
		try {
			numero = Integer.valueOf(stringNumero);
		} catch (NumberFormatException exc) {
			exc.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, numero);
		
		Date msgDate = calendar.getTime();
		if (msgDate.before(date)) {
			// enviar notificacion a usuario de que la fecha es anterior
			// a la actual.
			// poner anotacion de fecha anterior a la actual y que el
			// agente espere esta
			// notificacion para enviar mensaje al usuario.
			//notif.setTipoNotificacion(tipoNotif.fechaAnterior);
			calendar.set(calendar.get(Calendar.YEAR),(calendar.get(Calendar.MONTH))+1,numero);
			msgDate = calendar.getTime();
		} 
		msg = RecursoCalendarioImp.slashFormatter.format(msgDate);
		notif.setMensajeNotificacion(msg);
		return notif;
	}
}
