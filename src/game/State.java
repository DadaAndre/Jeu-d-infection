package game;

public class State{

	protected boolean player1; //le joueur1 -> true / joueur2 -> false
	protected char[][] gameGrid;
	public State(int tailleX, int tailleY){
		initialState(tailleX, tailleY);
	}

	public void initialState(int tailleX, int tailleY){
		//Création de la grille de jeu
		createGrid(tailleX, tailleY);

		//positionnement du pion blanc en bas à droite
		this.gameGrid[getGridWidth()][getGridHeigth()] = 'W';

		//positionnement du pion noir en haut à gauche
		this.gameGrid[0][0] = 'B';


		//Affichage de la grille de jeu
		renderGameGrid();
	}

	public void createGrid(int tailleX, int tailleY){

		this.gameGrid = new char[tailleX][tailleY];
		for(int i = 0 ; i < this.gameGrid.length ; i++){
			for(int j = 0 ; j < gameGrid[i].length; j++){
				this.gameGrid[i][j] = '.';
			}
			System.out.println();
		}
	}

	public void renderGameGrid(){

		for(int i = 0 ; i < this.gameGrid.length ; i++){
			for(int j = 0 ; j < this.gameGrid[i].length; j++){
				System.out.print(this.gameGrid[i][j]);
			}
			System.out.println();
		}
	}

	public int getGridWidth(){
		return gameGrid.length-1;
	}

	public int getGridHeigth(){
		return this.gameGrid[0].length-1;
	}

	public int getNumberOfPawn(char colorPawn){
		int count = 0;
		for(int i = 0 ; i < this.gameGrid.length ; i++){
			for(int j = 0 ; j < this.gameGrid[i].length; j++){
				if(this.gameGrid[i][j] == colorPawn){
					count+= 1;
				}
			}
		}
		return count;
	}

	public void nextPlayer(){
		if(this.player1 == false){
			this.player1 = true;
		}else{
			this.player1 = false;
		}
	}

	public void currentPlayer(){
		if(this.player1 == false){
			System.out.println("c'est le tour du joueur 1");
		}else{
			System.out.println("c'est le tour du joueur 2");
		}
	}

	public boolean isFinished(){
		return false;
	}
}
