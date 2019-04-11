package beans;

import org.springframework.beans.factory.annotation.Required;

import customAnnotation.MycustomAnnotation;

public class PaymentGateway {
	
	private String client;
    
    private Order order;
     
    @MycustomAnnotation
    public void setOrder(Order ord){
        this.order = ord;
    }
     
    public String getClient() {
        return client;
    }
 
    public void setClient(String client) {
        this.client = client;
    }
 
    public Order getOrder() {
        return order;
    }
 
    public void processOrder(){
        System.out.println("Processing order: "+order.getName());
    }

	@Override
	public String toString() {
		return "PaymentGateway [client=" + client + ", order=" + order + "]";
	}
	
	

}
