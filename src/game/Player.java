package game;

import java.util.Scanner;

public class Player {

	protected int saisie = 0;
	protected int saisieX = -1;
	protected int saisieY = -1;

	protected int[] selectedCoord = {-1,1};

	Scanner input = new Scanner(System.in);

	public Player(){

	}

	public Action actionToDo(boolean player, char[][] grid){
		int[] pawnChoosed = this.selectPawn(player, grid);
		int dirrection = this.direction();
		Action move = this.moveChoice(pawnChoosed[0], pawnChoosed[1], dirrection);

		return move;
	}

	public Action moveChoice(int x, int y, int dirr){
		//on choisi si le mouvement est un déplacement ou une duplication
		do{
			System.out.println("Quel mouvement voulez-vous faire?");
			System.out.println("1- Dupliquer \n2- Déplacer");
			this.saisie = input.nextInt();
			if(this.saisie == 1){
				return new Duplicate(x, y, dirr);
			}else if(this.saisie == 2){
				return new Move(x, y, dirr);
			}else{
				System.out.println("resaississez");
			}
		}while(this.saisie != 1 || this.saisie != 2);

		return null;
	}

	//à definir les conditions ou les mouvelents sont impossibles
	public boolean availableMove(){
		return false;
	}

	// on sélectionne un pion et on vérifie si le pion duquel on part pour faire l'action est bien valide (si il est bien a nous et si il est bien à la case choisie)
	public int[] selectPawn(boolean player1, char[][] grid){
		int[] coord= new int[2];
		do{
			System.out.println("Quel pion voulez-vous selectionner?");
			System.out.println("Saisissez la coordonné x du pion");
			this.saisieX = input.nextInt();
			coord[0] = saisieX;
			System.out.println("Saisissez la coordonnée y du pion");
			this.saisieY = input.nextInt();
			coord[1] = saisieY;
		} while ((player1 == true && grid[saisieX][saisieY] != 'W') ||  (player1 == false && grid[saisieX][saisieY] != 'B'));

		this.selectedCoord = coord;

		return coord;
	}

	// on demande au joueur dans quel direction on veut deplacer le pion
	public int direction(){
		System.out.println("Quel direction voulez vous aller?");
		System.out.println("1- Haut \n 2-Bas \n 3- Gauche \n 4- Droite");
		this.saisie = 0;
		this.saisie = input.nextInt();
		do{
			if(this.saisie == Action.DIRECTION_UP){
				return Action.DIRECTION_UP;
			}
			else if(this.saisie == Action.DIRECTION_DOWN){
				return Action.DIRECTION_DOWN;
			}
			else if(this.saisie == Action.DIRECTION_LEFT){
				return Action.DIRECTION_LEFT;
			}
			else if(this.saisie == Action.DIRECTION_RIGHT){
				return Action.DIRECTION_RIGHT;
			}else{
				System.out.println("resaississez");
			}
		}while(this.saisie >= 1 && this.saisie <= 4);

		return 0;
	}

	public int[] getSelectedCoord(){
		return this.selectedCoord;
	}

}
