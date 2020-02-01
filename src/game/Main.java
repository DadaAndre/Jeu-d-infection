package game;

public class Main{

	public static void main(String[] args){
		//
		// State state = new State(15,15);
		//
		// while(!state.isFinished()){
		// 	state.renderGameGrid();
		// 	Action coup = playerChoice.moveChoice();
		// 	coup.apply();
		// 	state.nextPlayer();
		// }

		Player playerChoice = new Player();
		State state = new State(15,15);
		while(true){
			System.out.println("player1(white): "+ state.isPlayer1());


			Action choix = playerChoice.actionToDo(state.isPlayer1(), state.getGrid());
			choix.apply(state, playerChoice.getSelectedCoord());
			System.out.println("--------------");
			state.renderGameGrid();

			if(choix.isMovePossible()){
				state.nextPlayer();
				//System.out.println("Beh on change de joueur");
			}
		}
	}
}
