package game;

public class Duplicate extends Action{

	protected int versHaut = y-1;
	protected int versBas = y+1;
	protected int versGauche = x-1;
	protected int versDroite = x+1;

	protected boolean isMovePossible = true;

	protected State state;

	public Duplicate(int x, int y, int dir){
		super(x, y, dir);
	}

	@Override
	public void apply(State state, int[] coord){

		//char playerPawn = state.getGridCell(coord[0],coord[1]);
		//System.out.println("iciiiiii:"+joueur);

		this.state = state;

		if(dir == Action.DIRECTION_UP && y != 0){
			addPawn(this.x,this.versHaut,state.playerPawn());
			y = versHaut;
			arroundPawn(x, y);
		}

		else if(dir == Action.DIRECTION_DOWN  && y != state.getGridHeigth()){
			addPawn(this.x,this.versBas,state.playerPawn());
			y = versBas;
			arroundPawn(x,y);
		}

		else if(dir == Action.DIRECTION_LEFT && x != 0){
			addPawn(this.versGauche,this.y,state.playerPawn());
			x = versGauche;
			arroundPawn(x,y);
		}

		else if(dir == Action.DIRECTION_RIGHT && x != state.getGridWidth()){
			addPawn(this.versDroite,this.y,state.playerPawn());
			x = versDroite;
			arroundPawn(x,y);
		}

		else{
			System.out.println("déplacement impossible");
			this.isMovePossible = false;
		}
	}

	public void addPawn(int directionX, int directionY, char playerPawn){
		state.setGridCell(directionX,directionY,playerPawn);
		this.isMovePossible = true;
	}

	@Override
	public boolean isMovePossible(){
		return isMovePossible;
	}

	public void arroundPawn(int x, int y){

		//char playerPawn = state.getGridCell(coord[0],coord[1]);

		if(state.getGridCell(x, versHaut) == state.ennemyPawn()){
			state.setGridCell(x, versHaut, state.playerPawn());
		}
		else if (state.getGridCell(x, versBas) == state.ennemyPawn()){
			state.setGridCell(x, versBas, state.playerPawn());
		}
		else if (state.getGridCell(versDroite, y) == state.ennemyPawn()){
			state.setGridCell(x, versDroite, state.playerPawn());
		}
		else if (state.getGridCell(versGauche,y) == state.ennemyPawn()){
			state.setGridCell(x, versGauche, state.playerPawn());
		}
	}

}
