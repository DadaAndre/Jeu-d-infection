package game;

public class Duplicate extends Action{

	public Duplicate(int x, int y, int dir){
		super(x, y, dir);
	}

	@Override
	public void apply(State state, int[] coord){
	}

	@Override
	public boolean isMovePossible(){
		return true;
	}

	// // on fait l'action de la duplication
	// public void actionDuplicate(){
	// 	char selectedPawn = selectPawn();
	// 	int choosedDirection = direction();
	//
	// 	if(choosedDirection == 1 && saisieY > 1){
	// 		grid[saisieX][saisieY-2] = selectedPawn;
	// 	}
	// 	else if(choosedDirection == 2 && saisieY < TAILLEMAXGRILLEHEIGTH-1){
	// 		grid[saisieX][saisieY+2] = selectedPawn;
	// 	}
	// 	else if(choosedDirection == 3 && saisieX > 1){
	// 		grid[saisieX-2][saisieY] = selectedPawn;
	// 	}
	// 	else if(choosedDirection == 4 && saisieX < TAILLEMAXGRILLEWIDTH-1){
	// 		grid[saisieX][saisieY+2] = selectedPawn;
	// 	}
	// 	else{
	// 		System.out.println("Déplacement impossible");
	// 		//trouver comment faire en sorte que ca recommance
	// 	}
	// }


}
