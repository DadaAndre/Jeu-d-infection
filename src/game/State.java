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
		int renderNumberLeft = 0;
		//affichage de la grille
		char newTab[][] = new char[this.gameGrid.length +1][this.gameGrid.length +1];

		for(int y = 0 ; y < newTab[0].length ; y++){ //y
			if(y == 0){
				int renderNumberTop = -2;
				while(renderNumberTop < this.gameGrid.length){
					if(renderNumberTop == -2){
						System.out.print(" ");
						renderNumberTop+=1;
					}else if(renderNumberTop > 10){
						System.out.print("| "+ renderNumberTop);
					}else{
						System.out.print(" | "+ renderNumberTop);
					}

					renderNumberTop +=1;
				}
				System.out.println();
				y++;
			}
			for(int x = 0 ; x < newTab.length ; x++){ //x
				if(x == 0){
					if(renderNumberLeft < 10 ){
						System.out.print(renderNumberLeft + " ");
					}else{
						System.out.print(renderNumberLeft);
					}

					renderNumberLeft+=1;
				}else{
					System.out.print("| " + this.gameGrid[x-1][y-1] + " " );
				}

			}
			System.out.println();
		}
	}
		// for(int j = 0 ; j < this.gameGrid[0].length ; j++){ //y
		// 	for(int i = 0 ; i < this.gameGrid.length ; i++){ //x
		// 		System.out.print(this.gameGrid[i][j]);
		// 	}
		// 	System.out.println();
		// }


	//retourne la coordonnée max en x
	public int getGridWidth(){
		return gameGrid.length-1;
	}

	//retourne la coordonnée max en y
	public int getGridHeigth(){
		return this.gameGrid[0].length-1;
	}

	//retourne le nombre de pions d'un joueur
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

	//change le joueur actiuel pour passer au suivant
	public void nextPlayer(){
		this.player1 = !this.player1;
	}

	//retourne le joueur actuel (s'il s'agit du joueur 1 ou non)
	public boolean isPlayer1(){
		if(this.player1){
			return true;
		}else{
			return false;
		}
	}

	public char playerPawn(){
		if(this.player1){
			return('W');
		}else{
			return('B');
		}
	}

	public char ennemyPawn(){
		if(this.player1){
			return('B');
		}else{
			return('W');
		}
	}

	//modifie la coordonnée de la grille
	public void setGridCell(int x, int y, char value){
		if(x >= 0 && x <= this.getGridWidth() && y >= 0 &&  y <= this.getGridHeigth()) {
			gameGrid[x][y] = value;
		}
	}

	//renvoie la coordonnée de la grille
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
