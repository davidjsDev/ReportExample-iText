package com.davidjsdev.solutions;

import com.itextpdf.kernel.colors.CalRgb;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.renderer.TableRenderer;

import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.io.File;

import static java.awt.Color.*;


public class TwoReport {
    private static final String fileName = "Reporte";
    private static  final String DEST = "/home/davidj.devel/" + fileName + ".pdf";

    public static void Print() throws Exception{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        PdfWriter writer = new PdfWriter( file );
        PdfDocument pdfDoc = new PdfDocument( writer );
        Document doc = new Document(pdfDoc, PageSize.A4);
        doc.setMargins(10 ,20,10,20 );

        Table outerTable = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();
        outerTable.addCell( Head());
        outerTable.addCell( HeadInfoClient() );
        outerTable.addCell( HeadInfoReport() );
        outerTable.addCell( ColumnHeadDetail());
        outerTable.addCell( ColumnFooter() );


        doc.add(outerTable);
        doc.close();
    }


    private static Cell Head(){
        Table innerTable = new Table(UnitValue.createPercentArray(new float[]{40 , 30})).useAllAvailableWidth();
        Paragraph paragraph;
        Cell cell;

        String [][] data = {
                {"COMPANY INFOR"},
        };


        paragraph = new Paragraph("COMPANY INFO");
        paragraph.setFontSize( 30F );
        cell = new Cell().add(paragraph);
        cell.setBorder( Border.NO_BORDER );
        innerTable.addCell( cell );

        paragraph = new Paragraph("ORDEN"+ "\n" +"Nro: 0000001");
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setBorder( Border.NO_BORDER );
        cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        cell.setVerticalAlignment( VerticalAlignment.MIDDLE );
        innerTable.addCell(cell);

        //innerTable.setNextRenderer( new TableBorderRenderer( innerTable ) );
        cell = new Cell().add(innerTable);
        cell.setBorder(new SolidBorder( ColorConstants.RED,2 ));
        cell.setBorder( Border.NO_BORDER )  ;

        return cell;
    }

    private static Cell HeadInfoClient(){
        Table outerTable = new Table(UnitValue.createPercentArray(new float[]{8 , 60})).useAllAvailableWidth();
        outerTable.setWidth(UnitValue.createPercentValue(100));

        Table innerTable = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();
        Cell cell;

        cell = new Cell().add(new Paragraph("Mr(s):"));
        cell.setFontSize( 8f );
        cell.setBorder(Border.NO_BORDER);
        innerTable.addCell(cell);


        cell = new Cell().add(new Paragraph("Address:"));
        cell.setFontSize( 8f );
        cell.setBorder(Border.NO_BORDER);
        innerTable.addCell(cell);

        String reportType = "DNI";

  /*      if(client.getDocumentType() == "R U C"){
            reportType = "R U C";
        }*/

        cell = new Cell().add(new Paragraph(reportType + ":").setFontSize( 8F ));
        cell.setBorder(Border.NO_BORDER);
        innerTable.addCell(cell);
        //innerTable.setNextRenderer( new TableBorderRenderer( innerTable ) );


        cell = new Cell().add(innerTable);
        cell.setBorder( Border.NO_BORDER );

        outerTable.addCell(cell);

        innerTable = new Table( UnitValue.createPercentArray(1)).useAllAvailableWidth();
        cell = new Cell().add(new Paragraph( "MACEDO CORDOVA , NICK ANGEL"));
        cell.setFontSize( 8f );
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        cell = new Cell().add(new Paragraph("PUERTO MALDONADO - PERU"));
        cell.setFontSize( 8f );
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        cell = new Cell().add(new Paragraph("321654987"));
        cell.setFontSize( 8f );
        cell.setBorder(Border.NO_BORDER);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        //  innerTable.setNextRenderer( new TableBorderRenderer( innerTable ) );

        cell = new Cell().add(innerTable);
        cell.setBorder( Border.NO_BORDER );
        cell.setBorderLeft( new SolidBorder( ColorConstants.BLACK,1 ));

        outerTable.addCell(cell);
        outerTable.setNextRenderer( new TableBorderRenderer( outerTable ) );
        cell = new Cell().add(outerTable);
        cell.setBorder( Border.NO_BORDER );
        //cell.setNextRenderer(new RoundedBorderCellRenderer(cell));

        return cell;
    }


    private static Cell HeadInfoReport(){
        Table innerTable = new Table( UnitValue.createPercentArray(new float[]{10,14,13,13})).useAllAvailableWidth();
        Paragraph paragraph;
        Cell cell;

        paragraph = new  Paragraph("CONDICION DE PAGO");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        cell.setBorderTop( Border.NO_BORDER );
        cell.setBorderLeft( Border.NO_BORDER );
        cell.setBackgroundColor( ColorConstants.LIGHT_GRAY );
        innerTable.addCell(cell);

        paragraph = new  Paragraph("ASESOR");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        cell.setBackgroundColor( ColorConstants.LIGHT_GRAY );
        innerTable.addCell(cell);

        paragraph = new  Paragraph("FECHA ACTUAL");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        cell.setBackgroundColor( ColorConstants.LIGHT_GRAY );
        innerTable.addCell(cell);

        paragraph = new  Paragraph("FECHA DE ENTREGA");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setBold();
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        cell.setBorderTop( Border.NO_BORDER );
        cell.setBorderRight( Border.NO_BORDER );
        cell.setBackgroundColor( ColorConstants.LIGHT_GRAY );
        innerTable.addCell(cell);

        paragraph = new  Paragraph("EFECTIVO");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        cell.setBorderBottom( Border.NO_BORDER );
        cell.setBorderLeft( Border.NO_BORDER );
        innerTable.addCell(cell);

        paragraph = new  Paragraph("DAVID HUARICANCHA - TELF. 87965321");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("25/11/2020");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        innerTable.addCell(cell);

        paragraph = new  Paragraph("28/11/2020");
        paragraph.setFontSize( 6F );
        paragraph.setTextAlignment( TextAlignment.CENTER );
        cell = new Cell().add(paragraph);
        cell.setPaddingLeft(2);
        cell.setBorderBottom( Border.NO_BORDER );
        cell.setBorderRight( Border.NO_BORDER );
        innerTable.addCell(cell);
        innerTable.setNextRenderer( new TableBorderRenderer( innerTable ) );

        cell = new Cell().add(innerTable);
        cell.setBorderRight( Border.NO_BORDER );
        //cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        cell.setPadding(1);
        cell.setBorder( Border.NO_BORDER );

        return cell;
    }

    private static Cell ColumnHeadDetail(){
        /*
         * list servicesActives(id client, id computer)
         * list template-product()
         * list accesories (id client)
         * list computerActives(id client)
         * */

        Table innertable = new Table(UnitValue.createPercentArray(new float[]{3.5F,30,4}));
        innertable.useAllAvailableWidth();
        innertable.setWidth(UnitValue.createPercentValue(100));
        Paragraph paragraph;
        Cell cell;

        paragraph = new Paragraph("RESUMEN");
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setFontSize( 8F );
        paragraph.setBold();

        cell = new Cell(1,3).add(paragraph);
        cell.setBorder(Border.NO_BORDER);
        cell.setBackgroundColor( ColorConstants.LIGHT_GRAY );


        //cell.setBackgroundColor( Color. )
        innertable.addCell(cell);


        // int x listComputers().getsize;

        int num = 5;

        do {
            paragraph = new Paragraph("NOMBRE PC");
            paragraph.setTextAlignment( TextAlignment.CENTER );
            paragraph.setFontSize( 8F );
            paragraph.setBold();
            paragraph.setFontColor( ColorConstants.WHITE );
            cell = new Cell(1,2).add(paragraph);
            cell.setBackgroundColor( ColorConstants.DARK_GRAY);
            innertable.addCell(cell);

            paragraph = new Paragraph("-");

            if(num == 5){
                paragraph = new Paragraph("PRECIO");
            }

            paragraph.setTextAlignment( TextAlignment.CENTER );
            paragraph.setFontSize( 8F );
            paragraph.setBold();
            cell = new Cell().add(paragraph);
            cell.setBackgroundColor( ColorConstants.LIGHT_GRAY );
            innertable.addCell(cell);

            /*
             * int x = listServices.getSize();
             * int y = listTemplateProduct.getSize();
             * */

            int x = 4;

            paragraph = new Paragraph("SERVICIO");
            paragraph.setTextAlignment( TextAlignment.CENTER );
            paragraph.setFontSize( 8F );
            paragraph.setBold();
            cell = new Cell(x,1).add(paragraph);
            cell.setVerticalAlignment( VerticalAlignment.MIDDLE );
            innertable.addCell(cell);

            //Change to for each
            for (int i =0 ; i < x; i++ ) {
                paragraph = new Paragraph("CAMBIO DE PANTALLA");
                paragraph.setTextAlignment( TextAlignment.LEFT);
                paragraph.setFontSize( 8F );
                //paragraph.setBold();
                cell = new Cell().add(paragraph);
                innertable.addCell(cell);

                paragraph = new Paragraph("S/"+"50");
                paragraph.setTextAlignment( TextAlignment.LEFT);
                paragraph.setFontSize( 8F );
                //paragraph.setBold();
                cell = new Cell().add(paragraph);
                innertable.addCell(cell);
            }

            x = 7;

            paragraph = new Paragraph("PRODUCTO");
            paragraph.setTextAlignment( TextAlignment.CENTER );
            paragraph.setFontSize( 8F );
            paragraph.setBold();
            cell = new Cell(x,1).add(paragraph);
            cell.setVerticalAlignment( VerticalAlignment.MIDDLE );
            innertable.addCell(cell);

            //Change to for each
            for (int i =0 ; i < x; i++ ) {
                paragraph = new Paragraph("PANTALLA LENOVO");
                paragraph.setTextAlignment( TextAlignment.LEFT);
                paragraph.setFontSize( 8F );
                //paragraph.setBold();
                cell = new Cell().add(paragraph);
                innertable.addCell(cell);

                paragraph = new Paragraph("S/"+"50");
                paragraph.setTextAlignment( TextAlignment.LEFT);
                paragraph.setFontSize( 8F );
                //paragraph.setBold();
                cell = new Cell().add(paragraph);
                innertable.addCell(cell);
            }

            num-=1;
        } while (num >= 0);

        innertable.addCell(createCell("Totals", 0, 2, TextAlignment.RIGHT).setBorder( Border.NO_BORDER ));
        innertable.addCell(createCell("$1,552.00", 0, 1, TextAlignment.RIGHT).setBorder( Border.NO_BORDER ));

        innertable.setNextRenderer( new TableBorderRenderer( innertable ) );
        cell = new Cell().add(innertable);


        //cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        cell.setBorder(Border.NO_BORDER);
        cell.setPadding( 1.5F );

        return cell;
    }

    private static Cell ColumnFooter(){
        /*
         * list accesories (id client)
         * int x = listAccesories().getSize;
         * */

        int x = 2;

        Table innertable = new Table(UnitValue.createPercentArray(new float[]{30,15}));
        innertable.useAllAvailableWidth();
        innertable.setWidth(UnitValue.createPercentValue(100));
        Paragraph paragraph;
        Cell cell;

        paragraph = new Paragraph("GRACIAS POR SU PREFERENCIA");
        paragraph.setTextAlignment( TextAlignment.CENTER );
        paragraph.setFontSize( 8F );
        paragraph.setBold();
        cell = new Cell(x,1).add(paragraph);
        cell.setVerticalAlignment( VerticalAlignment.MIDDLE );
        cell.setBorder( Border.NO_BORDER );
        innertable.addCell(cell);

        for (int i = 0 ; i <x; i++ ) {
            paragraph = new Paragraph("PANTALLA LENOVO");
            paragraph.setTextAlignment( TextAlignment.LEFT);
            paragraph.setFontSize( 8F );
            paragraph.setBold();
            cell = new Cell().add(paragraph);
            cell.setBorderTop( Border.NO_BORDER );
            cell.setBorderBottom( Border.NO_BORDER  );
            cell.setBorderRight( Border.NO_BORDER );
            innertable.addCell(cell);
        }


        cell = new Cell().add(innertable);
        cell.setBorder( Border.NO_BORDER );
        cell.setNextRenderer(new RoundedBorderCellRenderer(cell));
        //cell.setPadding( 1 );

        return cell;
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

    public static class TableBorderRenderer extends TableRenderer {

        public TableBorderRenderer(Table modelElement) {
            super(modelElement);
        }

        @Override
        public IRenderer getNextRenderer() {
            return new TableBorderRenderer((Table) modelElement);
        }

        @Override
        protected void drawBorders(DrawContext drawContext) {
            com.itextpdf.kernel.geom.Rectangle rect = getOccupiedAreaBBox();
            PdfPage currentPage = drawContext.getDocument().getPage(getOccupiedArea().getPageNumber());
            PdfCanvas aboveCanvas = new PdfCanvas(currentPage.newContentStreamAfter(), currentPage.getResources(), drawContext.getDocument());

            float lineWidth = 0.5f;
            rect.applyMargins(lineWidth, lineWidth, lineWidth, lineWidth, false);

            aboveCanvas.saveState().setLineWidth(lineWidth).setStrokeColor(new DeviceRgb(255,255,255)).rectangle(rect).stroke().restoreState();
            aboveCanvas.saveState().setLineWidth(lineWidth).setStrokeColor(new DeviceRgb(0,0,0)).roundRectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight(), 5).stroke().restoreState();

            super.drawBorders(drawContext);
        }

        @Override
        public void drawChildren(DrawContext drawContext) {
            Rectangle rect = getOccupiedAreaBBox();
            float lineWidth = 0.5f;
            rect.applyMargins(lineWidth, lineWidth, lineWidth, lineWidth, false);

            PdfCanvas canvas = drawContext.getCanvas();
            canvas.saveState();
            canvas.roundRectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight(), 5);
            canvas.clip().endPath();
            super.drawChildren(drawContext);
            canvas.restoreState();
        }
    }
}
