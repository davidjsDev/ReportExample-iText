package com.davidjsdev.model;

public class InfoReport {
    private String numberRuc;
    private String reportType;
    private String numberReport;

    public InfoReport(){
        this.reportType = "FACTURA ELECTRONICA";
        this.numberReport = "F012-009745";
        this.numberRuc = "20518679121";
    }

    public InfoReport(String numberRuc, String reportType, String numberReport) {
        this.numberRuc = numberRuc;
        this.reportType = reportType;
        this.numberReport = numberReport;
    }

    public String getNumberRuc() {
        return numberRuc;
    }

    public void setNumberRuc(String numberRuc) {
        this.numberRuc = numberRuc;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getNumberReport() {
        return numberReport;
    }

    public void setNumberReport(String numberReport) {
        this.numberReport = numberReport;
    }

    @Override
    public String toString() {
        return "Report{" +
                "numberRuc='" + numberRuc + '\'' +
                ", reportType='" + reportType + '\'' +
                ", numberReport='" + numberReport + '\'' +
                '}';
    }
}
