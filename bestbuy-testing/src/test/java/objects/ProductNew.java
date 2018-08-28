package objects;

/*
 * POST product: 
{
  "name": "string",
  "type": "string",
  "price": 0,
  "shipping": 0,
  "upc": "string",
  "description": "string",
  "manufacturer": "string",
  "model": "string",
  "url": "string",
  "image": "string"
}
 */
public class ProductNew {

	String name ;
	String type;
	String upc;
	String description ;
	String manufacturer; 
	String url;
	String image;
    String model ;
	
	double price; //better use BigDecimal
	double shipping;
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public void setAllParametersWithValidData(){
		setDescription("decription test");
		setImage("image test");
		setManufacturer("manufacturer test");
		setName("inessa test product");
		setModel("model test");
		setPrice(200.00);
		setShipping(100.00);
		setType("product type test");
		setUpc("upc type");
		setUrl("product url");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getShipping() {
		return shipping;
	}
	public void setShipping(double shipping) {
		this.shipping = shipping;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	


}
