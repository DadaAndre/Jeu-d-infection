package game;

public class Move extends Action{

	protected boolean isMovePossible = true;

	public Move(int x, int y, int dir){
		super(x, y, dir);
	}

	@Override
	public void apply(State state, int[] coord){

		char playerPawn = state.getGridCell(coord[0],coord[1]);
		//System.out.println("iciiiiii:"+joueur);

		if(dir == Action.DIRECTION_UP && y != 0 && y != 1){
			state.setGridCell(x,y-2,playerPawn);
			state.setGridCell(x,y,'.');
			this.isMovePossible = true;
		}

		else if(dir == Action.DIRECTION_DOWN  && (y != state.getGridHeigth() && y != state.getGridHeigth() -1)){
			state.setGridCell(x,y+2,playerPawn);
			state.setGridCell(x,y,'.');
			this.isMovePossible = true;
		}

		else if(dir == Action.DIRECTION_LEFT && (x != 0 && x != 1)){
			state.setGridCell(x-2,y,playerPawn);
			state.setGridCell(x,y,'.');
			this.isMovePossible = true;
		}

		else if(dir == Action.DIRECTION_RIGHT && (x != state.getGridWidth() && x != state.getGridHeigth() -1)){
			state.setGridCell(x+2,y,playerPawn);
			state.setGridCell(x,y,'.');
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
