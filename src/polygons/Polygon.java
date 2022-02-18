package polygons;

public abstract class Polygon implements Comparable<Polygon> {

	public static final double pie = 3.14016;  //yes pie. Pie is better than pi. 
	private char compareType;

	double height; 
	
	/**
	 * Constructor 
	 * @param height
	 * @param compareType
	 */
	public Polygon(double height, char compareType ){
		
		this.height = height;
		this.compareType = compareType; 
	}

	/**
	 * Method to get the height
	 * @return height
	 */
	public double getHeight(){
		return height; 
	}
	
	/**
	 * Abstract method to calculate the base area of polygon
	 * @return baseArea
	 */
	public abstract double getBaseArea();
	
	/**
	 * Abstract method to calculate the volume of polygon
	 * @return
	 */
	public abstract double getVolume();
	
	/**
	 * Method to compare polygons
	 * 
	 * @param polygon
	 * @return 0, positive or negative number when compared. 
	 * 
	 */
	public int compareTo(Polygon polygon){

		if(compareType == 'H' || compareType == 'h')
		{
			if(this.getHeight() > polygon.getHeight())
				return 5; //my favourite number, reminds me it can be any number at all
			else if (this.getHeight() < polygon.getHeight())
				return -5;
			else
				return 0; 
		}
		else if(compareType == 'V' || compareType == 'v')
		{
			if(this.getVolume() > polygon.getVolume())
				return 5;
			else if (this.getVolume() < polygon.getVolume())
				return -5; 
			else
				return 0; 
		} 
		else if(compareType == 'A' || compareType == 'a')
		{
			if(this.getBaseArea() > polygon.getBaseArea())
				return 5; 
			else if (this.getBaseArea() < polygon.getBaseArea())
				return -5; 
		
			else 
				return 0; 
		}
		else
				return 0; 
	}

	@Override
	public String toString() {
		
		
		if(compareType == 'v') {
			return String.format("Polygon Volume %.2f", getVolume());
		}
		else if(compareType == 'h'){ 
			return String.format("Polygon Height %.2f", getHeight());
		}
		else //(compareType == 'a'){
			return String.format("Polygon Base Area %.2f", getBaseArea());
		}
			
			
	}
	
