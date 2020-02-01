package game;

public class Move extends Action{

	protected boolean isMovePossible = true;

	protected int versHaut = y-2;
	protected int versBas = y+2;
	protected int versGauche = x-2;
	protected int versDroite = x+2;

	public Move(int x, int y, int dir){
		super(x, y, dir);
	}

	@Override
	public void apply(State state, int[] coord){

		char playerPawn = state.getGridCell(coord[0],coord[1]);
		//System.out.println("iciiiiii:"+joueur);

		if(dir == Action.DIRECTION_UP && y != 0 && y != 1){
			state.setGridCell(this.x,this.versHaut,playerPawn);
			state.setGridCell(this.x,this.y,'.');
			this.isMovePossible = true;
		}

		else if(dir == Action.DIRECTION_DOWN  && (y != state.getGridHeigth() && y != state.getGridHeigth() -1)){
			state.setGridCell(this.x,this.versBas,playerPawn);
			state.setGridCell(this.x,this.y,'.');
			this.isMovePossible = true;
		}

		else if(dir == Action.DIRECTION_LEFT && (x != 0 && x != 1)){
			state.setGridCell(this.versGauche,this.y,playerPawn);
			state.setGridCell(this.x,this.y,'.');
			this.isMovePossible = true;
		}

		else if(dir == Action.DIRECTION_RIGHT && (x != state.getGridWidth() && x != state.getGridHeigth() -1)){
			state.setGridCell(this.versDroite,this.y,playerPawn);
			state.setGridCell(this.x,this.y,'.');
			this.isMovePossible = true;
		}

		else{
			System.out.println("déplacement impossible");
			this.isMovePossible = false;
		}
	}

	public boolean isMovePossible(){
		return this.isMovePossible;
	}
}
