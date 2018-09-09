package planes;

public class Plane {
	protected String type;
	protected int speed;

	public Plane() {
		this.type = "ATR-72";
		this.speed = 518;
	}

	public String getType() {
		return type;
	}

	public int getSpeed() {
		return speed;
	}
}