package icaro.aplicaciones.recursos.comuSONIAChat;


import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;

import icaro.aplicaciones.recursos.comuSONIAChat.*;
import icaro.aplicaciones.recursos.comuSONIAChat.imp.InterpreteMsgsSONIA;
import icaro.aplicaciones.recursos.comuSONIAChat.imp.util.ConexionSONIA;
import icaro.aplicaciones.recursos.comuSONIAChat.imp.util.IrcException;
import icaro.aplicaciones.recursos.comuSONIAChat.imp.util.NickAlreadyInUseException;
import icaro.aplicaciones.recursos.extractorSemantico.ItfUsoExtractorSemantico;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ClaseGeneradoraComuSONIAChat extends ImplRecursoSimple implements
		ItfUsoComuSONIAChat {

	private static final long serialVersionUID = 1L;
//	private ItfUsoRecursoTrazas trazas;
//	private ConsultaBBDD consulta;
//        private ComuGarvisChatImp conexChat;
  private ConexionSONIA conexChat ;
 // private GarvisUserChat garvisUCInterface;
  private InterpreteMsgsSONIA interpreteMsgSONIA;
  private String identExtractorSem;
//  private String url = null;
//  private String nickname = null;
//  private String chanel="#kiwiirc-garvis";
  private String identInterlocutorPruebas = "pacopa";
  private Boolean conectado = false;
        

	public ClaseGeneradoraComuSONIAChat(String idInstanciaRecurso) throws Exception {
		
		super(idInstanciaRecurso);
// obtenemos las propiedades del recurso que deben estar definidas en las propiedades del recurso
//                ItfUsoConfiguracion config = (ItfUsoConfiguracion) repoIntfaces.obtenerInterfaz(NombresPredefinidos.ITF_USO+NombresPredefinidos.CONFIGURACION);
//			DescInstanciaRecursoAplicacion descRecurso = config.getDescInstanciaRecursoAplicacion(idInstanciaRecurso);
//			nombreBD = descRecurso.getValorPropiedad("MYSQL_NAME_BD");

//                url=ConfigInfoComuGarvisChat.urlFeeNode;
//                nickname=ConfigInfoComuGarvisChat.nicknameConexionAgte;
//                identAgenteAReportar = VocabularioGeneralGarvis.IdentAgenteAplicacionDialogoCitas;
                identExtractorSem = VocabularioGestionCitas.IdentRecursoExtractorSemantico;
		try {
//                        conexChat = new ComuGarvisChatImp(idInstanciaRecurso,url,nickname);
                    
    conexChat = new ConexionSONIA();
    //garvisUCInterface = new GarvisUserChat();
    interpreteMsgSONIA = new InterpreteMsgsSONIA(conexChat);
    conexChat.setInterpreteMsgs(interpreteMsgSONIA);
    trazas.aceptaNuevaTraza(new InfoTraza(this.getId(),
      "Creando el recurso "+idInstanciaRecurso,
        InfoTraza.NivelTraza.debug));

 
         
        
        } catch (Exception e) {
                        e.printStackTrace();
                        this.trazas.aceptaNuevaTraza(new InfoTraza(id,
  				"Se ha producido un error al crear el extractor semantico  "+e.getMessage()+
                                ": Verificar los parametros de creacion "
                                + "rutas y otros",
  				InfoTraza.NivelTraza.error));
			this.itfAutomata.transita("error");
			throw e;
		}
}
private void generarErrorCreacionComponente(String textoMensaje){
    this.trazas.aceptaNuevaTraza(new InfoTraza(id,
  				"Se ha producido un error al crear el extractor semantico  "+textoMensaje+
                                ": Verificar los parametros de creacion ",
  				InfoTraza.NivelTraza.error));
			this.itfAutomata.transita("error");
                        
}


  //@Override
  public void setIdentAgenteAReportar(String identAgte ){
      identAgenteAReportar = identAgte;
      InterfazUsoAgente itfAgteControlador = null;
      try {
          itfAgteControlador = (InterfazUsoAgente) this.repoIntfaces.obtenerInterfazUso(identAgenteAReportar);
      } catch (Exception ex) {
          Logger.getLogger(ClaseGeneradoraComuSONIAChat.class.getName()).log(Level.SEVERE, null, ex);
      }
     if (itfAgteControlador == null) this.generarErrorCreacionComponente("itfAgteAreportar es null");
     else interpreteMsgSONIA.setItfusoAgenteGestorDialogo(itfAgteControlador);
  }
  //@Override
  public void termina() {
//    trazas.aceptaNuevaTraza(new InfoTraza(this.getId(),
//          "Terminando recurso",
//          InfoTraza.NivelTraza.debug));
  //  AccesoBBDD.desconectar();
      
    try {
      super.termina();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void enviarMensagePrivado( String mensaje)throws Exception{
      conexChat.sendMessage(mensaje);
  }
  //@Override
  public void desconectar( )throws Exception{
      conexChat.disconnect();
  }

      //@Override
  public void comenzar ( String identAgteControlador)throws Exception{
    if (!conectado){
      InterfazUsoAgente itfAgteControlador;
          try {
              itfAgteControlador = (InterfazUsoAgente) this.repoIntfaces.obtenerInterfazUso(identAgteControlador);
         if (itfAgteControlador == null){
             this.generarErrorCreacionComponente("itfAgteControlador es null");
         }else interpreteMsgSONIA.setItfusoAgenteGestorDialogo(itfAgteControlador);
         ItfUsoExtractorSemantico itfExtractorSem=(ItfUsoExtractorSemantico) this.repoIntfaces.obtenerInterfazUso(identExtractorSem);
         if (itfExtractorSem == null){
             this.generarErrorCreacionComponente("itfExtractorSemantico es null");
         }else interpreteMsgSONIA.setItfusoRecExtractorSemantico(itfExtractorSem);
         if (itfExtractorSem == null ||itfAgteControlador == null )throw new Exception();
         else{
             interpreteMsgSONIA.setIdentAgenteGestorDialogo(VocabularioGestionCitas.IdentAgenteAplicacionDialogoCitas);
             interpreteMsgSONIA.setIdentConexion(VocabularioGestionCitas.IdentConexionAgte);
             //conexChat.setVerbose(true);
             //conectar( url, chanel, nickname);
         }
         } catch (Exception ex) {
              Logger.getLogger(ClaseGeneradoraComuSONIAChat.class.getName()).log(Level.SEVERE, null, ex);
          }
         
         
            conexChat.connect();
//            conexChat.setVerbose(true); //Debugging -> false
            conectado=true;//conexChat.isConnected();

    }
  }


} 
