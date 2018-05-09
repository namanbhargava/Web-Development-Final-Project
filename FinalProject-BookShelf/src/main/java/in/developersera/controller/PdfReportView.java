package in.developersera.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.developersera.pojo.Cart;
import in.developersera.pojo.UserPojo;


public class PdfReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//model was added to the scope by the Controller
		//User user = (User) model.get("user");
		//pdfdoc.add(new Paragraph("Student Name: " + user.getFname() + " " + user.getLname()));
		
		pdfdoc.add(new Paragraph("Order Receipt", FontFactory.getFont(FontFactory.HELVETICA, 20)));
		pdfdoc.add(Chunk.NEWLINE);
		UserPojo user = (UserPojo) model.get("user");
		String address =(String)model.get("address");
		String city =(String)model.get("city");
		String state =(String)model.get("state");
		String phoneNumber =(String)model.get("pnumber");
		String email =(String)model.get("email");
		List<Cart> listCart = (List<Cart>)model.get("listcart");
		
		pdfdoc.add(new Paragraph("Customer Details", FontFactory.getFont(FontFactory.HELVETICA, 16)));
		pdfdoc.add(Chunk.NEWLINE);
		pdfdoc.add(new Paragraph("Customer Name: " + user.getFname() + " " + user.getLname(), FontFactory.getFont(FontFactory.HELVETICA, 14)));
		pdfdoc.add(new Paragraph("Address: "+ address, FontFactory.getFont(FontFactory.HELVETICA, 14)));
		pdfdoc.add(new Paragraph("City: "+ city, FontFactory.getFont(FontFactory.HELVETICA, 14)));
		pdfdoc.add(new Paragraph("State: "+ state, FontFactory.getFont(FontFactory.HELVETICA, 14)));
		pdfdoc.add(new Paragraph("Phone Number: "+ phoneNumber, FontFactory.getFont(FontFactory.HELVETICA, 14)));
		pdfdoc.add(new Paragraph("Email: "+ email, FontFactory.getFont(FontFactory.HELVETICA, 14)));
		
		pdfdoc.add(Chunk.NEWLINE);
		
		pdfdoc.add(new Paragraph("Products Ordered", FontFactory.getFont(FontFactory.HELVETICA, 16)));
		
		pdfdoc.add(Chunk.NEWLINE);
		PdfPTable table = new PdfPTable(5);
		
		table.addCell("Product ID");
		table.addCell("Name");
		table.addCell("Quantity");
		table.addCell("Price");
		table.addCell("Total");
		
		for(Cart lc : listCart)
		{
			table.addCell(String.valueOf(lc.getProductpojo().getProductId()));
			table.addCell(lc.getProductpojo().getProductName());
			table.addCell(String.valueOf(lc.getQuantity()));
			table.addCell(String.valueOf(lc.getProductpojo().getProductPrice()));
			table.addCell(String.valueOf(lc.getQuantity()*lc.getProductpojo().getProductPrice()));
		}
		
		pdfdoc.add(table);
						
	}

}
