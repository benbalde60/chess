package board;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Board {
	String chessBoard[][] = new String[9][9];
	Pawn pawns[] = new Pawn[16];
	Rook rooks[] = new Rook[4];
	Knight knights[] = new Knight[4];
	Bishop bishops[] = new Bishop[4];
	Queen queens[] = new Queen[2];
	King kings[] = new King[2];
	
	public Board() {
		int counter= 8;
		char charCounter = 'A';
		for(int i=0;i<16;i++) {
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
		}
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
							rooks[0].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rooks[0].setColor("b");
							chessBoard[i][j]+=rooks[0].getColor()+rooks[0].getTitle();
							break;
						case 2:
							knights[0].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[0].setColor("b");
							chessBoard[i][j]+=knights[0].getColor()+knights[0].getTitle();
							break;
						case 3:
							bishops[0].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[0].setColor("b");
							chessBoard[i][j]+=bishops[0].getColor()+bishops[0].getTitle();
							break;
						case 4:
							queens[0].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							queens[0].setColor("b");
							chessBoard[i][j]+=queens[0].getColor()+queens[0].getTitle();
							break;
						case 5:
							kings[0].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							kings[0].setColor("b");
							chessBoard[i][j]+=kings[0].getColor()+kings[0].getTitle();
							break;
						case 6:
							bishops[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[1].setColor("b");
							chessBoard[i][j]+=bishops[1].getColor()+bishops[1].getTitle();
							break;
						case 7:
							knights[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[1].setColor("b");
							chessBoard[i][j]+=knights[1].getColor()+knights[1].getTitle();
							break;
						case 8:
							rooks[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rooks[1].setColor("b");
							chessBoard[i][j]+=rooks[0].getColor()+rooks[1].getTitle();
							break;
						}
						break;
						}
					case 2:
						if(j>0 && j<=8) {
							pawns[j].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							pawns[j].setColor("b");
							chessBoard[i][j]+="b"+pawns[0].getTitle();
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
							pawns[j].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							pawns[j].setColor("w");
							chessBoard[i][j]="w"+pawns[j].getTitle();
						}
						break;
					case 8:
						if(j>0 && j<=8) {
						switch(j) {
						case 1:
							rooks[2].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rooks[2].setColor("w");
							chessBoard[i][j]+=rooks[0].getColor()+rooks[0].getTitle();
							break;
						case 2:
							knights[2].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[2].setColor("w");
							chessBoard[i][j]+=knights[2].getColor()+knights[2].getTitle();
							break;
						case 3:
							bishops[2].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[2].setColor("w");
							chessBoard[i][j]+=bishops[2].getColor()+bishops[2].getTitle();
							break;
						case 4:
							queens[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							queens[1].setColor("w");
							chessBoard[i][j]+=queens[1].getColor()+queens[1].getTitle();
							break;
						case 5:
							kings[1].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							kings[1].setColor("w");
							chessBoard[i][j]+=kings[1].getColor()+kings[1].getTitle();
							break;
						case 6:
							bishops[3].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							bishops[3].setColor("w");
							chessBoard[i][j]+=bishops[3].getColor()+bishops[3].getTitle();
							break;
						case 7:
							knights[3].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							knights[3].setColor("w");
							chessBoard[i][j]+=knights[3].getColor()+knights[3].getTitle();
							break;
						case 8:
							rooks[3].setPosition(chessBoard[0][j]+chessBoard[i][0]);
							rooks[3].setColor("w");
							chessBoard[i][j]+=rooks[3].getColor()+rooks[3].getTitle();
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
