
package core.util;

public class TimeMeasurer {
	private long startTime;

	public TimeMeasurer() {
		init();				
	}
	
	public void init() {
		startTime =	System.currentTimeMillis();
	}
	
	public long measure() {
		return System.currentTimeMillis() - startTime;			
	}
	
	public void printMeasure() {
		long measure = measure();
		System.out.println("Measured time: " + measure + " ms.");	
	}
}