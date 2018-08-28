package objects;

public class Cart {

	
	private String cart_uuid ; 
	private String productBundleUUid; 

	public String getCart_uuid() {
		return cart_uuid;
	}
	public void setCart_uuid(String cart_uuid) {
		this.cart_uuid = cart_uuid;
	}
	public String getProductBundleUUid() {
		return productBundleUUid;
	}
	public void setProductBundleUUid(String productBundleUUid) {
		this.productBundleUUid = productBundleUUid;
	}
	
	public void setAllParametersWithValidData(){
		setCart_uuid("e23c9e70-af1a-4a1c-8593-80133214b93b");
		setProductBundleUUid("CamPackage_2018_06");

	}
	
}
