package cardms;

public class Car {
	
	private String id;
	private String name;
	private String colour;
	private int price;
	
	static int count=101;
	
	Car( String name, String colour, int price ){
		this.id= "C"+ count;
		this.name=name;
		this.colour=colour;
		this.price=price;
		count++;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getColer() {
		return colour;
	}



	public void setColer(String colour) {
		this.colour = colour;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", colour=" + colour + ", price=" + price ;
	}



	
	
	
	

}
