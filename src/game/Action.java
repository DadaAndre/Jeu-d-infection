package game;

public abstract class Action{

	protected int x = -1;
	protected int y = -1;
	protected int dir = -1;

	public static final int DIRECTION_UP = 1;
	public static final int DIRECTION_DOWN = 2;
	public static final int DIRECTION_LEFT = 3;
	public static final int DIRECTION_RIGHT = 4;

	public Action(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public abstract void apply(State state, int[] coord);

	public abstract boolean isMovePossible();
}
