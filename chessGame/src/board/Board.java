package board;
import java.util.ArrayList;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import utils.Helpers;
/**
 * public class for board, assembling a 9x9 board using an array list. Placing each piece in it's appropriate place
 */
public class Board {
	String chessBoard[][] = new String[9][9]; 
	ArrayList<Piece> pieces = new ArrayList<>(); 
	
	/** 
	 * return all pieces in board class
	 * @return {@code ArrayList<>} containing the pieces on the board.
	 */
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	/**
	 * Default constructor for new board. Populating board with pieces at their initial positions
	 * Sets each piece color and coordianates accord to piece class
	 */
	public String[][] getChessBoard() {
		return chessBoard;
	}
	public Board() {
		int counter= 8;
		char charCounter = 'A';
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {

				switch (j) {
				case 0:
					if(i==0) {
						chessBoard[i][j] = " ";
					}else {
					chessBoard[i][j]=Integer.toString(counter);
					counter--;
					}
					break;
				default:
					chessBoard[i][j]= "";
				}
					switch(i) {
					case 0:
						if(j==0) {
							chessBoard[i][j] = " ";
						}else {
									chessBoard[i][j]+=charCounter;
									charCounter++;																	
					
				}
						break;
					case 1:
						if(j>0 && j<=8) {
						switch(j) {
						case 1:
							Rook rook = new Rook();
							rook.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rook.setColor("b");
							rook.setCoordinates(i,j);
							pieces.add(rook);
							chessBoard[i][j]+=rook.getColor()+rook.getTitle();
							 
							
							break;
						case 2:
							Knight knight = new Knight();
							knight.setColor("b");
							knight.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight.getColor()+knight.getTitle();
							knight.setCoordinates(i, j);
							pieces.add(knight);
							break;
						case 3:
							Bishop bishop = new Bishop();
							bishop.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishop.setColor("b");
							bishop.setCoordinates(i, j);
							pieces.add(bishop);
							chessBoard[i][j]+=bishop.getColor()+bishop.getTitle();
							break;
						case 4:
							Queen queen = new Queen();
							queen.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							queen.setColor("b");
							queen.setCoordinates(i, j);
							pieces.add(queen);
							chessBoard[i][j]+=queen.getColor()+queen.getTitle();
							break;
						case 5:
							King king = new King();
							king.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							king.setColor("b");
							king.setCoordinates(i, j);
							pieces.add(king);
							chessBoard[i][j]+=king.getColor()+king.getTitle();
							break;
						case 6:
							Bishop bishop1 = new Bishop();
							bishop1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishop1.setColor("b");
							bishop1.setCoordinates(i, j);
							pieces.add(bishop1);
							chessBoard[i][j]+=bishop1.getColor()+bishop1.getTitle();
							break;
						case 7:
							Knight knight1 = new Knight();
							knight1.setColor("b");
							knight1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight1.getColor()+knight1.getTitle();
							knight1.setCoordinates(i, j);
							pieces.add(knight1);
							break;
						case 8:
							Rook rook1 = new Rook();
							rook1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rook1.setColor("b");
							rook1.setCoordinates(i, j);
							pieces.add(rook1);
							chessBoard[i][j]+=rook1.getColor()+rook1.getTitle();
							break;
						}
						break;
						}
					case 2:
						if(j>0 && j<=8) {
							Pawn pawn = new Pawn();
							pawn.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							pawn.setColor("b");
							pawn.setCoordinates(i, j);
							pieces.add(pawn);
							chessBoard[i][j]+=pawn.getColor()+pawn.getTitle();
						}
						break;
					case 3:
						if(j>0 && j<=8) {
							if(j%2!=0) {
								chessBoard[i][j]="  ";
							}else {
								chessBoard[i][j]="##";
							}
						}
						break;
					case 4:
						if(j>0 && j<=8) {
							if(j%2==0) {
								chessBoard[i][j]="  ";
							}else {
								chessBoard[i][j]="##";
							}
						}
						break;
					case 5:
						if(j>0 && j<=8) {
							if(j%2!=0) {
								chessBoard[i][j]="  ";
							}else {
								chessBoard[i][j]="##";
							}
						}
						break;
					case 6:
						if(j>0 && j<=8) {
							if(j%2==0) {
								chessBoard[i][j]="  ";
							}else {
								chessBoard[i][j]="##";
							}
						}
						break;
					case 7:
						if(j>0 && j<=8) {
							Pawn pawn = new Pawn();
							pawn.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							pawn.setColor("w");
							pawn.setCoordinates(i, j);
							pieces.add(pawn);
							chessBoard[i][j]+=pawn.getColor()+pawn.getTitle();
						}
						break;
					case 8:
						if(j>0 && j<=8) {
						switch(j) {
						case 1:
							Rook rook = new Rook();
							rook.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rook.setColor("w");
							rook.setCoordinates(i, j);
							pieces.add(rook);
							chessBoard[i][j]+=rook.getColor()+rook.getTitle();
							break;
						case 2:
							Knight knight = new Knight();
							knight.setColor("w");
							knight.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight.getColor()+knight.getTitle();
							knight.setCoordinates(i, j);
							pieces.add(knight);
							break;
						case 3:
							Bishop bishop = new Bishop();
							bishop.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishop.setColor("w");
							bishop.setCoordinates(i, j);
							pieces.add(bishop);
							chessBoard[i][j]+=bishop.getColor()+bishop.getTitle();
							break;
						case 4:
							Queen queen = new Queen();
							queen.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							queen.setColor("w");
							queen.setCoordinates(i, j);
							pieces.add(queen);
							chessBoard[i][j]+=queen.getColor()+queen.getTitle();
							break;
						case 5:
							King king = new King();
							king.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							king.setColor("w");
							king.setCoordinates(i, j);
							pieces.add(king);
							chessBoard[i][j]+=king.getColor()+king.getTitle();
							break;
						case 6:
							Bishop bishop1 = new Bishop();
							bishop1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishop1.setColor("w");
							bishop1.setCoordinates(i, j);
							pieces.add(bishop1);
							chessBoard[i][j]+=bishop1.getColor()+bishop1.getTitle();
							break;
						case 7:
							Knight knight1 = new Knight();
							knight1.setColor("w");
							knight1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight1.getColor()+knight1.getTitle();
							knight1.setCoordinates(i, j);
							pieces.add(knight1);
							break;
						case 8:
							Rook rook1 = new Rook();
							rook1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rook1.setColor("w");
							rook1.setCoordinates(i, j);
							pieces.add(rook1);
							chessBoard[i][j]+=rook1.getColor()+rook1.getTitle();
							break;
									
								}
			}
		  }
					}
			}
		}
	/**
	 * Method that moves individual piece on board according to coordinate params
	 * @param a1 coords indicating where piece of interest is on board
	 * @param a2 coords indicated where to move the piece of interest
	 */
	
	/*public void move(int []a1,int [] a2) {
		if(chessBoard[a1[0]][a1[1]]=="  "||chessBoard[a1[0]][a1[1]]=="##") {
			System.out.println("invalid move");
		}else if(chessBoard[a2[0]][a2[1]].charAt(0)==chessBoard[a1[0]][a1[1]].charAt(0)){
			System.out.println("invalid move ally at this location");
		}else {
			for(int i=0;i<pieces.size();i++) {
				if(pieces.get(i).getCor()[0]==a1[0] && pieces.get(i).getCor()[1]==a1[1]) {
					pieces.get(i).setCoordinates(a2[0],a2[1]);
					pieces.get(i).setPosition(Helpers.convertCorToPos(pieces.get(i).getCor()));
				}
			}
		chessBoard[a2[0]][a2[1]]=chessBoard[a1[0]][a1[1]];
		if((a1[0]%2!= 0 && a1[1]%2==0) ||(a1[0]%2==0 && a1[1]%2!=0)) {
			chessBoard[a1[0]][a1[1]]= "##";
		}else {
		chessBoard[a1[0]][a1[1]]= "  ";
		}
	   }
	}*/

	/**
	 * Prints board
	 */
	public void printBoard() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(chessBoard[i][j]+" ");
				if(i==0 && j>0) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	
	}
