package fr.car;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

@ManagedBean
@ViewScoped
public class GestCar {
	
	//http://localhost:8080/SR03_WEB/car/index.xhtml
	
	private List<CarTemplate> carTemplate;
	
	@PostConstruct
	public void init()
	{		
		this.carTemplate = new ArrayList<CarTemplate>();
		
		
		Client client = ClientBuilder.newClient();
		
		this.carTemplate = client.target("http://localhost:8080/projet/req/couleurs")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<CarTemplate>>() {});
		
	}

	public List<CarTemplate> getCarTemplate() {
		return carTemplate;
	}

	public void setEdtTemplate(List<CarTemplate> carTemplate) {
		this.carTemplate = carTemplate;
	}

	

}
