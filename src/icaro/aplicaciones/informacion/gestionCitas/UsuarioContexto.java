package icaro.aplicaciones.informacion.gestionCitas;

import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;

import java.io.Serializable;

public class UsuarioContexto implements Serializable {

	public String usuario;
	public String nombre;
	public String idGrupo;
	public boolean medico;
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

	public boolean isMedico() {
		return medico;
	}

	public void setMedico(boolean medico) {
		this.medico = medico;
	}

	public boolean inactividad(int i) {
		long tim = ((System.currentTimeMillis() - tiempo) / 1000) / 60;
		return tim >= i;
	}

}
