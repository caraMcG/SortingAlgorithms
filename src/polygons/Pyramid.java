package polygons;

public class Pyramid extends Polygon {

	private double sideLength;
	
	/**
	 * Constructor 
	 * 
	 * @param height
	 * @param sideLength
	 * @param compareType
	 */
	public Pyramid(double height, double sideLength, char compareType) {
		super(height, compareType);
		this.setSideLength(sideLength);
	}
	
	/**
	 * Method to set the side length
	 * @param sideLength
	 */
	public void setSideLength(double sideLength){
		this.sideLength = sideLength; 
	}
	
	/**
	 * Method to get the side length
	 * @return sideLength
	 */
	public double getSideLength(){
		return sideLength;
	}

	@Override
	public double getBaseArea() { 
		// TODO Auto-generated method stub
		return sideLength * sideLength;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 1/3 * this.getBaseArea() * height;
	}

}
