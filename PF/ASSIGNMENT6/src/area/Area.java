package area;
public class Area {
    
    /**
     * @param height
     * @param width
     * function returning area of triangle 
     */
    public double triangle (double height, double width) {
    	double area = (0.5) * height * width ;
    	return area;
    }
    
    /**
     * @param height
     * @param width
     * function returning area of rectangle
     */
    public double rectangle (double height, double width) {
    	double area = height * width ;
    	return area;
    }
    
    /**
     * @param side
     * function returning side of square
     */
    public  double square ( double side ) {
    	double area = side * side;
    	return area;
    }
    
    /**
     * @param radius
     * function returning area of circle
     */
    public  double circle( double radius ) {
    	double pi = 3.14;
    	double area = pi * radius * radius;
        return area;
    }
}
