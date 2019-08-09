public class Bowller {
	
	private int id;
	static int counter = 1;
	private int numberOfBalls;
	
	public Bowller(int numberOfBalls) {
		this.id = counter++;
		this.numberOfBalls = numberOfBalls;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getNumberOfBalls() {
		return this.numberOfBalls;
	}
	
	public void setNumberOfBalls(int balls) {
		this.numberOfBalls = balls;
	}
}
