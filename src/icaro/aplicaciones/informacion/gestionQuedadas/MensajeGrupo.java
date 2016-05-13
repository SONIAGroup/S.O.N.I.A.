package icaro.aplicaciones.informacion.gestionQuedadas;

public class MensajeGrupo {
	
	static public final int CANCELAR = 0;
	static public final int CONFIRMAR = 1;
	static public final int DENEGAR = 2;
	static public final int SOLICITAR = 3;
	
	public String idGrupoEmisor;
	public String idGrupoDestinatario;
	public int mensaje;

	public MensajeGrupo(String idGrupoEmisor, String idGrupoDestinatario, int mensaje) {
		this.idGrupoEmisor = idGrupoEmisor;
		this.idGrupoDestinatario = idGrupoDestinatario;
		this.mensaje = mensaje;
	}

	public String getIdGrupoEmisor() {
		return idGrupoEmisor;
	}
	
	public String getIdGrupoDestinatario() {
		return idGrupoDestinatario;
	}
	
	public int getMensaje() {
		return mensaje;
	}
}