package game;

public class State{

	protected boolean player1; //le joueur1 -> true//blanc / joueur2//noir -> false
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
		}
	}

	public void renderGameGrid(){

		for(int j = 0 ; j < this.gameGrid[0].length; j++){
			for(int i = 0 ; i < this.gameGrid.length ; i++){
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
		this.player1 = !this.player1;
	}

	public boolean isPlayer1(){
		if(this.player1){
			return true;
		}else{
			return false;
		}
	}

	public void setGridCell(int x, int y, char value){
		if(x >= 0 && x <= this.getGridWidth() && y >= 0 &&  y <= this.getGridHeigth()) {
			gameGrid[x][y] = value;
		}
	}

	public char getGridCell(int x, int y) {
		if(x >= 0 && x <= this.getGridWidth() && y >= 0 && y <= this.getGridHeigth()) {
			 return this.gameGrid[x][y];
		}
		else{
			return ' ';
		}
	}

	public char[][] getGrid(){
		return this.gameGrid;
	}

	public boolean isFinished(){
		return false;
	}
}
