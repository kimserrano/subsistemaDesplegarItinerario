/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vistaItinerario;

import ObjNegocio.Dias;
import ObjNegocio.Itinerario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reporte.ItinerarioDataSource;

/**
 *
 * @author eruma
 */
public class caliz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Itinerario> reporte= new ArrayList<Itinerario>();
        Itinerario itiner = new Itinerario();
        itiner.setLongitud(11.3f);
        itiner.setMaxVisitantes(10);
        itiner.setNombre("yorch");
        List<Dias> dias=new ArrayList<Dias>();
        dias.add(Dias.MIERCOLES);
        dias.add(Dias.LUNES);
        itiner.setDias(dias);
        itiner.setHoraInicio(new Date());
        itiner.setHoraFin(new Date());
        
        reporte.add(itiner);
        ItinerarioDataSource reporteJasper=new ItinerarioDataSource(reporte);
        
        
           try {
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("src\\main\\java\\reporte\\Itinerario.jasper");
            JasperPrint jPrint = JasperFillManager.fillReport(report, null, reporteJasper.getDataSource());
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            ex.getMessage();
        }
        
    }
    
}
