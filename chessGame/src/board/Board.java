package board;
import java.util.ArrayList;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Board {
	String chessBoard[][] = new String[9][9];
	ArrayList<Piece> pieces = new ArrayList<>(); 
	/*Pawn pawns[] = new Pawn[16];
	Rook rooks[] = new Rook[4];
	Knight knights[] = new Knight[4];
	Bishop bishops[] = new Bishop[4];
	Queen queens[] = new Queen[2];
	King kings[] = new King[2];*/
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	public Board() {
		int counter= 8;
		char charCounter = 'A';
		/*for(int i=0;i<16;i++) {
			pawns[i] = new Pawn();
		}
		for(int i =0;i<4;i++) {
			rooks[i]= new Rook();
		}
		for(int i =0;i<4;i++) {
			knights[i]= new Knight();
		}
		for(int i =0;i<4;i++) {
			bishops[i]= new Bishop();
		}
		for(int i=0;i<2;i++) {
			queens[i]=new Queen();
		}
		for(int i=0;i<2;i++) {
			kings[i] = new King();
		}*/
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
							int [] arr = {i,j};
							rook.setCoordinates(i,j);
							pieces.add(rook);
							chessBoard[i][j]+=rook.getColor()+rook.getTitle();
							 
							
							break;
						case 2:
							/*knights[0].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[0].setColor("b");*/
							Knight knight = new Knight();
							knight.setColor("b");
							knight.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight.getColor()+knight.getTitle();
							knight.setCoordinates(i, j);
							pieces.add(knight);
							break;
						case 3:
							/*bishops[0].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[0].setColor("b");*/
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
							/*bishops[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[1].setColor("b");
							chessBoard[i][j]+=bishops[1].getColor()+bishops[1].getTitle();
							*/
							break;
						case 7:
							Knight knight1 = new Knight();
							knight1.setColor("b");
							knight1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight1.getColor()+knight1.getTitle();
							knight1.setCoordinates(i, j);
							pieces.add(knight1);
							/*knights[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[1].setColor("b");
							chessBoard[i][j]+=knights[1].getColor()+knights[1].getTitle();
							*/
							break;
						case 8:
							Rook rook1 = new Rook();
							rook1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rook1.setColor("b");
							rook1.setCoordinates(i, j);
							pieces.add(rook1);
							chessBoard[i][j]+=rook1.getColor()+rook1.getTitle();
							/*
							rooks[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rooks[1].setColor("b");
							chessBoard[i][j]+=rooks[1].getColor()+rooks[1].getTitle();
							*/
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
							/*pawns[j].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							pawns[j].setColor("b");
							chessBoard[i][j]+=pawns[j].getColor()+pawns[j].getTitle();
							*/
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
							/*pawns[j].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							pawns[j].setColor("w");
							chessBoard[i][j]="w"+pawns[j].getTitle();*/
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
							/*rooks[2].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rooks[2].setColor("w");
							chessBoard[i][j]+=rooks[2].getColor()+rooks[2].getTitle();*/
							break;
						case 2:
							Knight knight = new Knight();
							knight.setColor("w");
							knight.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight.getColor()+knight.getTitle();
							knight.setCoordinates(i, j);
							pieces.add(knight);
							/*
							knights[2].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[2].setColor("w");
							chessBoard[i][j]+=knights[2].getColor()+knights[2].getTitle();
							*/
							break;
						case 3:
							Bishop bishop = new Bishop();
							bishop.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishop.setColor("w");
							bishop.setCoordinates(i, j);
							pieces.add(bishop);
							chessBoard[i][j]+=bishop.getColor()+bishop.getTitle();
							/*bishops[2].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[2].setColor("w");
							chessBoard[i][j]+=bishops[2].getColor()+bishops[2].getTitle();
							*/
							break;
						case 4:
							Queen queen = new Queen();
							queen.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							queen.setColor("w");
							queen.setCoordinates(i, j);
							pieces.add(queen);
							chessBoard[i][j]+=queen.getColor()+queen.getTitle();
							/*queens[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							queens[1].setColor("w");
							chessBoard[i][j]+=queens[1].getColor()+queens[1].getTitle();
							*/
							break;
						case 5:
							King king = new King();
							king.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							king.setColor("w");
							king.setCoordinates(i, j);
							pieces.add(king);
							chessBoard[i][j]+=king.getColor()+king.getTitle();
							/*kings[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							kings[1].setColor("w");
							chessBoard[i][j]+=kings[1].getColor()+kings[1].getTitle();
							*/
							break;
						case 6:
							Bishop bishop1 = new Bishop();
							bishop1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishop1.setColor("w");
							bishop1.setCoordinates(i, j);
							pieces.add(bishop1);
							chessBoard[i][j]+=bishop1.getColor()+bishop1.getTitle();
							/*bishops[3].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[3].setColor("w");
							chessBoard[i][j]+=bishops[3].getColor()+bishops[3].getTitle();
							*/
							break;
						case 7:
							Knight knight1 = new Knight();
							knight1.setColor("w");
							knight1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							chessBoard[i][j]+=knight1.getColor()+knight1.getTitle();
							knight1.setCoordinates(i, j);
							pieces.add(knight1);
							/*
							knights[3].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[3].setColor("w");
							chessBoard[i][j]+=knights[3].getColor()+knights[3].getTitle();
							*/
							break;
						case 8:
							Rook rook1 = new Rook();
							rook1.setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rook1.setColor("w");
							rook1.setCoordinates(i, j);
							pieces.add(rook1);
							chessBoard[i][j]+=rook1.getColor()+rook1.getTitle();
							/*
							rooks[3].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rooks[3].setColor("w");
							chessBoard[i][j]+=rooks[3].getColor()+rooks[3].getTitle();
							*/
							break;
							/*default:
								if(i>2 && i<7) {
									if(i%2!=0 && j%2!=0) {
										chessBoard[i][j]="  ";
									}else if(i%2!=0 && j%2==0) {
										chessBoard[i][j] ="##";
									}*/
									
								}
			}
		  }
					}
			}
		}
	public void move(int []a1,int [] a2) {
		if(chessBoard[a1[0]][a1[1]]=="  "||chessBoard[a1[0]][a1[1]]=="##") {
			System.out.println("invalid move");
		}else if(chessBoard[a2[0]][a2[1]].charAt(0)==chessBoard[a1[0]][a1[1]].charAt(0)){
			System.out.println("invalid move ally at this location");
		}else {
		chessBoard[a2[0]][a2[1]]=chessBoard[a1[0]][a1[1]];
		if((a1[0]%2!= 0 && a1[1]%2==0) ||(a1[0]%2==0 && a1[1]%2!=0)) {
			chessBoard[a1[0]][a1[1]]= "##";
		}else {
		chessBoard[a1[0]][a1[1]]= "  ";
		}
	   }
	}
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
