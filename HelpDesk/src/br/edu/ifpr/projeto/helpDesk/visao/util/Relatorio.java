
package br.edu.ifpr.projeto.helpDesk.visao.util;

import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Relatorio {
    

    public static void gerarRelatorio(String caminho, ResultSet rs) {
        try{
           //recebe um ResultSet vindo do banco de dados
            JRResultSetDataSource jrRS =
                    new JRResultSetDataSource(rs);
            //Imprime o relatório
            JasperPrint jasperPrint = 
                    JasperFillManager.fillReport
                    (caminho, new HashMap(), jrRS);
            //Componente para visualizar o relatório
         JasperViewer.viewReport(jasperPrint);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Relatório não foi gerado. " + erro);
        }
    }
    
    

    }
