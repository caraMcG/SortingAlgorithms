package polygons;

public class TriangularPrism extends Polygon {

	private double sideLength;
	
	/**
	 * Constructor
	 * 
	 * @param height
	 * @param sideLength
	 * @param compareType
	 */
	public TriangularPrism(double height, double sideLength,  char compareType) {
		super(height, compareType);
		this.setSideLength(sideLength);
	}
	
	/**
	 * Method to get the sideLength 
	 * 
	 * @return sideLength
	 */
	public double getSideLength(){
		return sideLength;
	}

	/**
	 * Method to set the sideLength
	 * 
	 * @param sideLength
	 */
	public void setSideLength(double sideLength){
		this.sideLength = sideLength; 
	}
	
	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return ((sideLength * sideLength) * Math.sqrt(3)) / 4; 
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return this.getBaseArea() * height; 
	}
	
	

}
