package polygons;

public class SquarePrism extends Polygon {

	private double sideLength;
	
	/**
	 * Constructor 
	 * 
	 * @param height
	 * @param sideLength
	 * @param compareType
	 */
	public SquarePrism(double height, double sideLength, char compareType) {
		super(height, compareType);
		this.setSideLength(sideLength);
	}
	
	/**
	 * Method to set the side length
	 * @return sideLength
	 */
	public double getSideLength(){
		return sideLength;
	}

	/**
	 * Method to set the side length
	 * @param sideLength
	 */
	public void setSideLength(double sideLength){
		this.sideLength = sideLength;
	}
	
	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return sideLength * sideLength;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return height * (sideLength * sideLength);
	}

}
