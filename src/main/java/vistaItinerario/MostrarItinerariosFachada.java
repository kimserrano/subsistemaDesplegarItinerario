/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaItinerario;

import ObjNegocio.Itinerario;
import java.util.ArrayList;
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
 * @author JORGE
 */
public class MostrarItinerariosFachada implements IMostrarItinerario {

    private MostrarItinerario mostrar;
    
    @Override
    public void reporteItinerario(Itinerario itinerario) {
        this.mostrar.reporteItinerario(itinerario);
    }
    
    protected class MostrarItinerario{
           
        public void reporteItinerario(Itinerario itinerario){
            List<Itinerario> reporte = new ArrayList<Itinerario>();
            reporte.add(itinerario);
            ItinerarioDataSource reporteJasper = new ItinerarioDataSource(reporte);
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
    
}
