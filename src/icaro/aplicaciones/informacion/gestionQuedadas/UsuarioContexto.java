package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;

public class UsuarioContexto implements Serializable {

	private static final long serialVersionUID = -6456659822827961492L;
	public String usuario;
	public String nombre;
	public String idGrupo;
	public long tiempo;

	public UsuarioContexto() {
		tiempo = System.currentTimeMillis();
	}

	public String getUsuario() {
		return usuario;
	}

	public void actividad() {
		tiempo = System.currentTimeMillis();
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String id) {
		idGrupo = id;
	}

	public boolean inactividad(int i) {
		long tim = ((System.currentTimeMillis() - tiempo) / 1000) / 60;
		return tim >= i;
	}

}
