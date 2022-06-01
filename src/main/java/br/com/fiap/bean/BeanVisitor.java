package br.com.fiap.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.dao.VisitorDao;
import br.com.fiap.model.Visitor;

@Named
@RequestScoped
public class BeanVisitor {

	private Visitor Visitor = new Visitor();
	private List<Visitor> list;
	private UploadedFile image;
	
	public BeanVisitor() {
		list = this.list();
	}
	
	public String save() throws IOException {		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		
		String path = servletContext.getRealPath("/"); 
		
		FileOutputStream out = new FileOutputStream(path + "\\images\\" + image.getFileName());
		out.write(image.getContent());
		out.close();
		
		Visitor.setImagePath("\\images\\" + image.getFileName());
		
		new VisitorDao().create(Visitor);
		
		showMessage();

		
		return "home?faces-redirect=true";
	}

	private void showMessage() {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Visitante criado com sucesso"));
	}
	
	public List<Visitor> list(){
		return new VisitorDao().listAll();
	}
	
	public String remove(Visitor Visitor) {
		new VisitorDao().delete(Visitor);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Visitante deletado com sucesso"));
		
		return "home?faces-redirect=true";

	}
	
	public List<Visitor> getList() {
		return list;
	}

	public void setList(List<Visitor> list) {
		this.list = list;
	}

	public Visitor getVisitor() {
		return Visitor;
	}

	public void setVisitor(Visitor Visitor) {
		this.Visitor = Visitor;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
