package polygons;

public class Cylinder extends Polygon {

	private double radius;
	
	/**
	 * Constructor 
	 * 
	 * @param height
	 * @param radius
	 * @param compareType
	 */
	public Cylinder(double height, double radius,  char compareType) { //TODO check order
		super(height, compareType);  //keep, it will error because super doesn't have a constructor
		this.setRadius(radius); 
		// TODO Auto-generated constructor stub
	}
 
	/**
	 * Method to set the radius
	 * @param radius
	 */
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	/**
	 * Method to get the radius 
	 * @return radius
	 */
	public double getRadius(){
		return radius;
	}	
	
	@Override
	public double getBaseArea() {
		return pie * (radius * radius); 
	}

	@Override
	public double getVolume() {
		return 0.33333 * (pie * (radius * radius)) * height;
	}

}
