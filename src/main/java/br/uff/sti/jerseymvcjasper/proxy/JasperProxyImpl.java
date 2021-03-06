/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.sti.jerseymvcjasper.proxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author marcos
 */
public class JasperProxyImpl implements JasperProxy {

    @Override
    public JasperReport loadReport(InputStream is) throws JRException {
        return (JasperReport)JRLoader.loadObject(is);
    }
    
    @Override
    public JasperReport compileReport(InputStream inputStream) throws JRException {
        return JasperCompileManager.compileReport(inputStream);
    }

    @Override
    public JasperPrint fillReport(JasperReport jasperReport, Map mapParamerters, List listObjs) throws JRException {
        JRBeanCollectionDataSource beanColDataSource
                = new JRBeanCollectionDataSource(listObjs);
        return JasperFillManager.fillReport(jasperReport, mapParamerters, beanColDataSource);
    }

    @Override
    public void exportReportToPDFStream(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
