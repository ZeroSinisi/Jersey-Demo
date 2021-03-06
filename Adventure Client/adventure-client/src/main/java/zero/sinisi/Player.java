package zero.sinisi;

public class Player {

	private int	id;
	private int	x;
	private int	y;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	String	name;

	public Player() {
		name = "New";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "I'm a player named " + name + " and my ID is " + id;
	}
}
