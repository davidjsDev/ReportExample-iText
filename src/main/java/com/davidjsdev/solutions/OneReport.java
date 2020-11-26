package com.davidjsdev.solutions;

import com.davidjsdev.model.Client;
import com.davidjsdev.model.InfoReport;
import com.davidjsdev.model.ItemSale;
import com.davidjsdev.model.User;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;

import javax.print.DocFlavor;
import java.io.File;
import java.util.List;

public class OneReport {
    public static final String fileName = "Reporte";
    public static final String DEST = System.getProperty("user.dir") + "/src/main/resources/Reports/" + fileName + ".pdf";

    public static void Print(String dest, InfoReport infoReport, Client client,List<ItemSale> itemSaleList , User user) throws Exception{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
        Document doc = new Document(pdfDoc, PageSize.A5.rotate() );
        Table outerTable = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();
        outerTable.addCell(Head(infoReport));
        outerTable.addCell(HeadInfoClient(client,infoReport));
        outerTable.addCell( HeadInfoReport(user));
        outerTable.addCell( ColumnHeadDetail(itemSaleList));

        doc.add(outerTable);
        doc.close();
    }

    private static Cell Head(InfoReport infoReport){
        Table innerTable = new Table(UnitValue.createPercentArray(new float[]{40 , 30})).useAllAvailableWidth();
        Paragraph paragraph;
        Cell cell;

        paragraph = new Paragraph("COMPANY INFO");
        paragraph.setFontSize( 30F );
        cell = new Cell().add(paragraph);
        cell.setBorder( Border.NO_BORDER );
        innerTable.addCell( cell );

        paragraph = new Paragraph("R U C:" + infoReport.getNumberRuc() + "\n" + infoReport.getReportType()+ "\n" + "Nro. " +  infoReport.getNumberReport());
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setBorder( Border.NO_BORDER );
        cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        innerTable.addCell(cell);

        cell = new Cell().add(innerTable);
        cell.setBorder( Border.NO_BORDER )  ;

        return cell;
    }

    private static Cell HeadInfoClient(Client client, InfoReport infoReport){
        Table outerTable = new Table(UnitValue.createPercentArray(new float[]{8 , 60})).useAllAvailableWidth();
        outerTable.setWidth(UnitValue.createPercentValue(100));

        Table innerTable = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();
        Cell cell;

        cell = new Cell().add(new Paragraph("Mr(s):"));
        cell.setBorder(Border.NO_BORDER);
        innerTable.addCell(cell);


        cell = new Cell().add(new Paragraph("Address:"));
        cell.setBorder(Border.NO_BORDER);
        innerTable.addCell(cell);

        String reportType = "";

        if(infoReport.getReportType() == "R U C"){
            reportType = "R U C";
        }

        reportType = "DNI";
        cell = new Cell().add(new Paragraph(reportType + ":"));
        cell.setBorder(Border.NO_BORDER);
        innerTable.addCell(cell);

        outerTable.addCell(innerTable);

        innerTable = new Table( UnitValue.createPercentArray(1)).useAllAvailableWidth();
        cell = new Cell().add(new Paragraph(client.getLastName() + "," + client.getFirstName()));
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        cell = new Cell().add(new Paragraph(client.getAddress()));
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        cell = new Cell().add(new Paragraph(client.getDocumentNum()));
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        outerTable.addCell(innerTable);
        cell = new Cell().add(outerTable);
        cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        cell.setPadding(2);
        cell.setBorder( Border.NO_BORDER );

        return cell;
    }

    private static Cell HeadInfoReport(User user){
        Table innerTable = new Table( UnitValue.createPercentArray(new float[]{10,10,10,10,10})).useAllAvailableWidth();
        Paragraph paragraph;
        Cell cell;

        paragraph = new  Paragraph("ORDEN DE COMPRA");
        paragraph.setFontSize( 9F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("NUMERO DE GUIA");
        paragraph.setFontSize( 9F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("CONDICION DE PAGO");
        paragraph.setFontSize( 9F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("VENDEDOR");
        paragraph.setFontSize( 9F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("FECHA");
        paragraph.setFontSize( 9F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("-");
        paragraph.setFontSize( 9F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("EFECTIVO");
        paragraph.setFontSize( 9F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph(user.getLastName() + "," + user.getFirstName());
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("-");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("-");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);


        cell = new Cell().add(innerTable);
        cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        cell.setPadding(2);
        cell.setBorder( Border.NO_BORDER );
        return cell;
    }

    private static Cell ColumnHeadDetail(List<ItemSale> itemSaleList){
        Table innertable = new Table(UnitValue.createPercentArray(new float[]{4, 18, 4.5F, 4.5F}));
        innertable.useAllAvailableWidth();
        innertable.setWidth(UnitValue.createPercentValue(100));
        Paragraph paragraph;
        Cell cell;

        paragraph = new Paragraph("CANTIDAD");
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setFontSize( 8F );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        innertable.addCell(cell);


        paragraph = new Paragraph("DESCRIPCION");
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setFontSize( 8F );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        innertable.addCell(cell);


        paragraph = new Paragraph("PRICE UNIT");
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setFontSize( 8F );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        innertable.addCell(cell);

        paragraph = new Paragraph("PRICE VENTA");
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setFontSize( 8F );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        innertable.addCell(cell);

        for (ItemSale itemSale : itemSaleList ) {

            paragraph = new Paragraph(String.valueOf(itemSale.getQuantity()));
            cell = new Cell().add(paragraph);
            cell.setBorderBottom(Border.NO_BORDER);
            cell.setBorderTop( Border.NO_BORDER );
            innertable.addCell(cell);

            paragraph = new Paragraph(itemSale.getDescription());
            cell = new Cell().add( paragraph );
            cell.setBorderBottom(Border.NO_BORDER);
            cell.setBorderTop( Border.NO_BORDER );
            innertable.addCell(cell);

            paragraph = new Paragraph(String.valueOf(itemSale.getPriceUnit()));
            cell = new Cell().add( paragraph );
            cell.setBorderBottom(Border.NO_BORDER);
            cell.setBorderTop( Border.NO_BORDER );
            innertable.addCell(cell);

            paragraph = new Paragraph(String.valueOf(itemSale.getAmount()));
            cell = new Cell().add( paragraph );
            cell.setBorderBottom(Border.NO_BORDER);
            cell.setBorderTop( Border.NO_BORDER );
            innertable.addCell(cell);

        }

        //innertable.addCell(ColumnFooter());

        innertable.addCell(createCell("Totals", 0, 2, TextAlignment.LEFT));
        innertable.addCell(createCell("$1,552.00", 0, 1, TextAlignment.RIGHT));
        innertable.addCell(createCell("$1,552.00", 0, 1, TextAlignment.RIGHT));

        cell = new Cell().add(innertable);
        cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        cell.setBorder(Border.NO_BORDER);
        cell.setPadding( 1 );

        return cell;
    }

    private static Table ColumnFooter(){
        return null;
    }

    private static Cell PageFooter(){
        return null;
    }

    private static Cell Summary(){
        return null;
    }

    //Methods of repository https://github.com/itext/i7js-examples
    private static class RoundedBorderCellRenderer extends CellRenderer {
        public RoundedBorderCellRenderer(Cell modelElement) {
            super(modelElement);
        }

        // If renderer overflows on the next area, iText uses getNextRender() method to create a renderer for the overflow part.
        // If getNextRenderer isn't overriden, the default method will be used and thus a default rather than custom
        // renderer will be created
        @Override
        public IRenderer getNextRenderer() {
            return new RoundedBorderCellRenderer((Cell) modelElement);
        }

        @Override
        public void draw(DrawContext drawContext) {
            drawContext.getCanvas().roundRectangle(getOccupiedAreaBBox().getX() + 1.5f, getOccupiedAreaBBox().getY() + 1.5f,
                    getOccupiedAreaBBox().getWidth() - 3, getOccupiedAreaBBox().getHeight() - 3, 4);
            drawContext.getCanvas().stroke();
            super.draw(drawContext);
        }
    }

    private static Cell createCell(String content, float borderWidth, int colspan, TextAlignment alignment) {
        Cell cell = new Cell(1, colspan).add(new Paragraph(content));
        cell.setTextAlignment(alignment);
        cell.setBorder(new SolidBorder(borderWidth));
        return cell;
    }

}
