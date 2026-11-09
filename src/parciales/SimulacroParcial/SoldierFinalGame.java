package parciales.SimulacroParcial;

import java.util.Scanner;

public class SoldierFinalGame {
	
	public static void main(String[] args) {
	
		int i, j;
		int fila, columna;
		int generador;
		int rehenes=5;		
		int mercenarios=5;
		int muros=10;
		int vida=100;
		int balas=5;
		int recargas=3;
		int botiquines=2;
		int portales=1;
		int minas=3;
	
		int tamano=10;
		int contadorRehenes = 0;
		int contadorMercenarios = 0;
		int minasDesactivadas;
		int tablero[][] = new int[tamano][tamano];
		int posXSoldado=0, posYSoldado=0;
		String opcion;
		boolean ganador=false;
	
		Scanner leer = new Scanner(System.in);
		
		for (i = 0; i < tamano; i++) {
			for (j = 0; j < tamano; j++) {
				tablero[i][j] = 0;
			}
		}
		
		tablero[posXSoldado][posYSoldado] = 1;
		tablero[tamano-1][tamano-1] = 2;
		
		for (generador = 1; generador <= rehenes; generador++) {
			fila=(int)(Math.random()*tamano);
			columna=(int)(Math.random()*tamano);
			if(tablero[fila][columna]!=0) {
				generador--;
			}else {
				tablero[fila][columna]=3;
			}
		}
		
		for (generador = 1; generador <= mercenarios; generador++) {
			fila=(int)(Math.random()*tamano);
			columna=(int)(Math.random()*tamano);
			if(tablero[fila][columna]!=0) {
				generador--;
			}else {
				tablero[fila][columna]=4;
			}
		}
		
		for (generador = 1; generador <= muros; generador++) {
			fila=(int)(Math.random()*tamano);
			columna=(int)(Math.random()*tamano);
			if(tablero[fila][columna]!=0) {
				generador--;
			}else {
				tablero[fila][columna]=5;
			}
		}
		
		for (generador = 1; generador <= recargas; generador++) {
			fila=(int)(Math.random()*tamano);
			columna=(int)(Math.random()*tamano);
			if(tablero[fila][columna]!=0) {
				generador--;
			}else {
				tablero[fila][columna]=6;
			}
		}
		
		for (generador = 1; generador <= botiquines; generador++) {
			fila=(int)(Math.random()*tamano);
			columna=(int)(Math.random()*tamano);
			if(tablero[fila][columna]!=0) {
				generador--;
			}else {
				tablero[fila][columna]=7;
			}
		}
		
		for (generador = 1; generador <= portales; generador++) {
			fila=(int)(Math.random()*tamano);
			columna=(int)(Math.random()*tamano);
			if(tablero[fila][columna]!=0) {
				generador--;
			}else {
				tablero[fila][columna]=8;
			}
		}
		
		for (generador = 1; generador <= minas; generador++) {
			fila=(int)(Math.random()*tamano);
			columna=(int)(Math.random()*tamano);
			if(tablero[fila][columna]!=0) {
				generador--;
			}else {
				tablero[fila][columna]=9;
			}
		}
		
		System.out.println("SOLDAIER FINAL GAME");
		System.out.println("\nVIDA: "+ vida + " | REHÉNES: " + contadorRehenes + " | MERCENARIOS: " + contadorMercenarios + " | BALAS: " + balas + "\n");
		System.out.println("╔══════════════════════════════╗");
		for (i = 0; i < tamano; i++) {
			System.out.print("║");
			for (j = 0; j < tamano; j++) {				
				if(tablero[i][j]==0) {
					System.out.print("[ ]");
				}
				if(tablero[i][j]==1) {
					System.out.print("[♀]");
				}
				if(tablero[i][j]==2) {
					System.out.print("[∏]");
				}
				if(tablero[i][j]==3) {
					System.out.print("[☺]");
				}
				if(tablero[i][j]==4) {
					System.out.print("[☻]");
				}
				if(tablero[i][j]==5) {
					System.out.print("[▓]");
				}
				if(tablero[i][j]==6) {
					System.out.print("[®]");
				}
				if(tablero[i][j]==7) {
					System.out.print("[♥]");
				}
				if(tablero[i][j]==8) {
					System.out.print("[◘]");
				}
				if(tablero[i][j]==9) {
					System.out.print("[☼]");
				}
				if(tablero[i][j]==10) {
					System.out.print("[X]");
				}
			}
			System.out.println("║");
		}
		System.out.println("╚══════════════════════════════╝");
		
		do {
			System.out.println("\nMENÚ SOLDAIER FINAL GAME\n");
			System.out.println("[A] IZQUIERDA");
			System.out.println("[S] ABAJO");
			System.out.println("[D] DERECHA");
			System.out.println("[W] ARRIBA");
			System.out.println("[DA] DISPARAR IZQUIERDA");
			System.out.println("[DS] DISPARAR ABAJO");
			System.out.println("[DD] DISPARAR DERECHA");
			System.out.println("[DW] DISPARAR ARRIBA");
			System.out.println("[M] DESACTIVAR MINAS");
			System.out.println("[E] SALIR\n");
			System.out.print("Digite la opción deseada: ");
			opcion=leer.next().toUpperCase();
			switch(opcion) {
			
				case "D":
					if(posYSoldado + 1 < tamano) {
						if(tablero[posXSoldado][posYSoldado + 1] == 0) {
							tablero[posXSoldado][posYSoldado + 1] = 1;
							tablero[posXSoldado][posYSoldado] = 0;
							posYSoldado++;
						}else {
							if(tablero[posXSoldado][posYSoldado + 1] == 3) {
								tablero[posXSoldado][posYSoldado + 1] = 1;
								tablero[posXSoldado][posYSoldado] = 0;
								posYSoldado++;
								contadorRehenes++;
							}else {
								if(tablero[posXSoldado][posYSoldado + 1] == 4) {									
									vida = vida - 20;
									if(vida <= 0) {
										ganador = true;
										System.out.println("\n!!! GAME OVER !!!\n");
										tablero[posXSoldado][posYSoldado] = 10;
									}
								}else {
									if(tablero[posXSoldado][posYSoldado + 1] == 5) {									
										tablero[posXSoldado][posYSoldado] = 1;
									}else {
										if(tablero[posXSoldado][posYSoldado + 1] == 6) {
											tablero[posXSoldado][posYSoldado + 1] = 1;
											tablero[posXSoldado][posYSoldado] = 0;
											posYSoldado++;
											balas = balas + 3;
										}else {
											if(tablero[posXSoldado][posYSoldado + 1] == 7) {
												tablero[posXSoldado][posYSoldado + 1] = 1;
												tablero[posXSoldado][posYSoldado] = 0;
												posYSoldado++;												
												if(vida <= 80) {
													vida = vida + 20;
												}
											}else {
												if(tablero[posXSoldado][posYSoldado + 1] == 8) {
													tablero[posXSoldado][posYSoldado] = 0;
													for (generador = 1; generador <= 1; generador++) {
														posXSoldado=(int)(Math.random()*tamano);
														posYSoldado=(int)(Math.random()*tamano);
														if(tablero[posXSoldado][posYSoldado]!=0) {
															generador--;
														}else {
															tablero[posXSoldado][posYSoldado]=1;
														}
													}												
												}else {
													if(tablero[posXSoldado][posYSoldado + 1] == 9) {									
														tablero[posXSoldado][posYSoldado + 1] = 1;
														tablero[posXSoldado][posYSoldado] = 0;
														posYSoldado++;
														vida = vida - 50;
														if(vida <= 0) {
															ganador = true;
															System.out.println("\n!!! GAME OVER !!!\n");
															tablero[posXSoldado][posYSoldado] = 10;
														}
													}else {
														if(tablero[posXSoldado][posYSoldado + 1] == 2) {															
															tablero[posXSoldado][posYSoldado] = 0;
															posYSoldado++;
															if(contadorMercenarios == 5 && contadorRehenes == 5) {
																ganador = true;
																System.out.println("\n!!! YOU WIN !!!\n");																
															}else {
																ganador = true;
																System.out.println("\n!!! GAME OVER !!!\n");
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					break;
					
				case "A":
					if(posYSoldado - 1 >= 0) {
						if(tablero[posXSoldado][posYSoldado - 1] == 0) {
							tablero[posXSoldado][posYSoldado - 1] = 1;
							tablero[posXSoldado][posYSoldado] = 0;
							posYSoldado--;
						}else {
							if(tablero[posXSoldado][posYSoldado - 1] == 3) {
								tablero[posXSoldado][posYSoldado - 1] = 1;
								tablero[posXSoldado][posYSoldado] = 0;
								posYSoldado--;
								contadorRehenes++;
							}else {
								if(tablero[posXSoldado][posYSoldado - 1] == 4) {									
									vida = vida - 20;
									if(vida <= 0) {
										ganador = true;
										System.out.println("\n!!! GAME OVER !!!\n");
										tablero[posXSoldado][posYSoldado] = 10;
									}
								}else {
									if(tablero[posXSoldado][posYSoldado - 1] == 5) {									
										tablero[posXSoldado][posYSoldado] = 1;
									}else {
										if(tablero[posXSoldado][posYSoldado - 1] == 6) {
											tablero[posXSoldado][posYSoldado - 1] = 1;
											tablero[posXSoldado][posYSoldado] = 0;
											posYSoldado--;
											balas = balas + 3;
										}else {
											if(tablero[posXSoldado][posYSoldado - 1] == 7) {
												tablero[posXSoldado][posYSoldado - 1] = 1;
												tablero[posXSoldado][posYSoldado] = 0;
												posYSoldado--;												
												if(vida <= 80) {
													vida = vida + 20;
												}
											}else {
												if(tablero[posXSoldado][posYSoldado - 1] == 8) {
													tablero[posXSoldado][posYSoldado] = 0;
													for (generador = 1; generador <= 1; generador++) {
														posXSoldado=(int)(Math.random()*tamano);
														posYSoldado=(int)(Math.random()*tamano);
														if(tablero[posXSoldado][posYSoldado]!=0) {
															generador--;
														}else {
															tablero[posXSoldado][posYSoldado]=1;
														}
													}												
												}else {
													if(tablero[posXSoldado][posYSoldado - 1] == 9) {									
														tablero[posXSoldado][posYSoldado - 1] = 1;
														tablero[posXSoldado][posYSoldado] = 0;
														posYSoldado--;
														vida = vida - 50;
														if(vida <= 0) {
															ganador = true;
															System.out.println("\n!!! GAME OVER !!!\n");
															tablero[posXSoldado][posYSoldado] = 10;
														}
													}else {
														if(tablero[posXSoldado][posYSoldado - 1] == 2) {															
															tablero[posXSoldado][posYSoldado] = 0;
															posYSoldado--;
															if(contadorMercenarios == 5 && contadorRehenes == 5) {
																ganador = true;
																System.out.println("\n!!! YOU WIN !!!\n");																
															}else {
																ganador = true;
																System.out.println("\n!!! GAME OVER !!!\n");
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					break;
					
				case "S":
					if(posXSoldado + 1 < tamano) {
						if(tablero[posXSoldado + 1][posYSoldado] == 0) {
							tablero[posXSoldado + 1][posYSoldado] = 1;
							tablero[posXSoldado][posYSoldado] = 0;
							posXSoldado++;
						}else {
							if(tablero[posXSoldado + 1][posYSoldado] == 3) {
								tablero[posXSoldado + 1][posYSoldado] = 1;
								tablero[posXSoldado][posYSoldado] = 0;
								posXSoldado++;
								contadorRehenes++;
							}else {
								if(tablero[posXSoldado + 1][posYSoldado] == 4) {									
									vida = vida - 20;
									if(vida <= 0) {
										ganador = true;
										System.out.println("\n!!! GAME OVER !!!\n");
										tablero[posXSoldado][posYSoldado] = 10;
									}
								}else {
									if(tablero[posXSoldado + 1][posYSoldado] == 5) {									
										tablero[posXSoldado][posYSoldado] = 1;
									}else {
										if(tablero[posXSoldado + 1][posYSoldado] == 6) {
											tablero[posXSoldado + 1][posYSoldado] = 1;
											tablero[posXSoldado][posYSoldado] = 0;
											posXSoldado++;
											balas = balas + 3;
										}else {
											if(tablero[posXSoldado + 1][posYSoldado] == 7) {
												tablero[posXSoldado + 1][posYSoldado] = 1;
												tablero[posXSoldado][posYSoldado] = 0;
												posXSoldado++;												
												if(vida <= 80) {
													vida = vida + 20;
												}
											}else {
												if(tablero[posXSoldado + 1][posYSoldado] == 8) {
													tablero[posXSoldado][posYSoldado] = 0;
													for (generador = 1; generador <= 1; generador++) {
														posXSoldado=(int)(Math.random()*tamano);
														posYSoldado=(int)(Math.random()*tamano);
														if(tablero[posXSoldado][posYSoldado]!=0) {
															generador--;
														}else {
															tablero[posXSoldado][posYSoldado]=1;
														}
													}												
												}else {
													if(tablero[posXSoldado + 1][posYSoldado] == 9) {									
														tablero[posXSoldado + 1][posYSoldado] = 1;
														tablero[posXSoldado][posYSoldado] = 0;
														posXSoldado++;
														vida = vida - 50;
														if(vida <= 0) {
															ganador = true;
															System.out.println("\n!!! GAME OVER !!!\n");
															tablero[posXSoldado][posYSoldado] = 10;
														}
													}else {
														if(tablero[posXSoldado + 1][posYSoldado] == 2) {															
															tablero[posXSoldado][posYSoldado] = 0;
															posXSoldado++;
															if(contadorMercenarios == 5 && contadorRehenes == 5) {
																ganador = true;
																System.out.println("\n!!! YOU WIN !!!\n");																
															}else {
																ganador = true;
																System.out.println("\n!!! GAME OVER !!!\n");
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					break;
					
				case "W":
					if(posXSoldado - 1 >= 0) {
						if(tablero[posXSoldado - 1][posYSoldado] == 0) {
							tablero[posXSoldado - 1][posYSoldado] = 1;
							tablero[posXSoldado][posYSoldado] = 0;
							posXSoldado--;
						}else {
							if(tablero[posXSoldado - 1][posYSoldado] == 3) {
								tablero[posXSoldado - 1][posYSoldado] = 1;
								tablero[posXSoldado][posYSoldado] = 0;
								posXSoldado--;
								contadorRehenes++;
							}else {
								if(tablero[posXSoldado - 1][posYSoldado] == 4) {									
									vida = vida - 20;
									if(vida <= 0) {
										ganador = true;
										System.out.println("\n!!! GAME OVER !!!\n");
										tablero[posXSoldado][posYSoldado] = 10;
									}
								}else {
									if(tablero[posXSoldado - 1][posYSoldado] == 5) {									
										tablero[posXSoldado][posYSoldado] = 1;
									}else {
										if(tablero[posXSoldado - 1][posYSoldado] == 6) {
											tablero[posXSoldado - 1][posYSoldado] = 1;
											tablero[posXSoldado][posYSoldado] = 0;
											posXSoldado--;
											balas = balas + 3;
										}else {
											if(tablero[posXSoldado - 1][posYSoldado] == 7) {
												tablero[posXSoldado - 1][posYSoldado] = 1;
												tablero[posXSoldado][posYSoldado] = 0;
												posXSoldado--;												
												if(vida <= 80) {
													vida = vida + 20;
												}
											}else {
												if(tablero[posXSoldado - 1][posYSoldado] == 8) {
													tablero[posXSoldado][posYSoldado] = 0;
													for (generador = 1; generador <= 1; generador++) {
														posXSoldado=(int)(Math.random()*tamano);
														posYSoldado=(int)(Math.random()*tamano);
														if(tablero[posXSoldado][posYSoldado]!=0) {
															generador--;
														}else {
															tablero[posXSoldado][posYSoldado]=1;
														}
													}												
												}else {
													if(tablero[posXSoldado - 1][posYSoldado] == 9) {									
														tablero[posXSoldado - 1][posYSoldado] = 1;
														tablero[posXSoldado][posYSoldado] = 0;
														posXSoldado--;
														vida = vida - 50;
														if(vida <= 0) {
															ganador = true;
															System.out.println("\n!!! GAME OVER !!!\n");
															tablero[posXSoldado][posYSoldado] = 10;
														}
													}else {
														if(tablero[posXSoldado - 1][posYSoldado] == 2) {															
															tablero[posXSoldado][posYSoldado] = 0;
															posXSoldado--;
															if(contadorMercenarios == 5 && contadorRehenes == 5) {
																ganador = true;
																System.out.println("\n!!! YOU WIN !!!\n");																
															}else {
																ganador = true;
																System.out.println("\n!!! GAME OVER !!!\n");
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					break;
					
					case "DD":
						if(balas > 0) {
							balas--;
							for(j=posYSoldado+1; j<tamano; j++) {
								if(tablero[posXSoldado][j]==3) {
									ganador = true;
									System.out.println("\n!!! GAME OVER !!!\n");
									tablero[posXSoldado][j]=10;
									j=tamano+1;
								}else {
									if(tablero[posXSoldado][j]==4) {
										contadorMercenarios++;
										tablero[posXSoldado][j]=0;	
										j=tamano+1;
									}else {
										if(tablero[posXSoldado][j]==5) {											
											j=tamano+1;
										}
									}
								}
							}							
						}else {
							System.out.println("\n!!! RELOAD YOUR GUN !!!\n");
						}
					break;
					
					case "DA":
						if(balas > 0) {
							balas--;
							for(j=posYSoldado-1; j>=0; j--) {
								if(tablero[posXSoldado][j]==3) {
									ganador = true;
									System.out.println("\n!!! GAME OVER !!!\n");
									tablero[posXSoldado][j]=10;
									j=-1;
								}else {
									if(tablero[posXSoldado][j]==4) {
										contadorMercenarios++;
										tablero[posXSoldado][j]=0;	
										j=-1;
									}else {
										if(tablero[posXSoldado][j]==5) {											
											j=-1;
										}
									}
								}
							}							
						}else {
							System.out.println("\n!!! RELOAD YOUR GUN !!!\n");
						}
					break;
					
					case "DS":
						if(balas > 0) {
							balas--;
							for(i=posXSoldado+1; i<tamano; i++) {
								if(tablero[i][posYSoldado]==3) {
									ganador = true;
									System.out.println("\n!!! GAME OVER !!!\n");
									tablero[i][posYSoldado]=10;
									i=tamano+1;
								}else {
									if(tablero[i][posYSoldado]==4) {
										contadorMercenarios++;
										tablero[i][posYSoldado]=0;	
										i=tamano+1;
									}else {
										if(tablero[i][posYSoldado]==5) {											
											i=tamano+1;
										}
									}
								}
							}							
						}else {
							System.out.println("\n!!! RELOAD YOUR GUN !!!\n");
						}
					break;
					
					case "DW":
						if(balas > 0) {
							balas--;
							for(i=posXSoldado-1; i>=0; i--) {
								if(tablero[i][posYSoldado]==3) {
									ganador = true;
									System.out.println("\n!!! GAME OVER !!!\n");
									tablero[i][posYSoldado]=10;
									i=-1;
								}else {
									if(tablero[i][posYSoldado]==4) {
										contadorMercenarios++;
										tablero[i][posYSoldado]=0;	
										i=-1;
									}else {
										if(tablero[i][posYSoldado]==5) {											
											i=-1;
										}
									}
								}
							}							
						}else {
							System.out.println("\n!!! RELOAD YOUR GUN !!!\n");
						}
					break;
					
					case "M":
						minasDesactivadas = 0;
						for(i=posXSoldado-1; i<=posXSoldado+1; i++) {
							for(j=posYSoldado-1; j<=posYSoldado+1; j++) {
								if(i >= 0 && i < tamano && j >= 0 && j < tamano) {
									if(tablero[i][j]==9) {
										tablero[i][j]=0;
										minasDesactivadas++;
									}
								}
							}
						}
						if(minasDesactivadas > 0) {
							System.out.println("\n!!! MINAS DESACTIVADAS: " + minasDesactivadas + " !!!\n");
						}else {
							System.out.println("\n!!! NO HAY MINAS CERCA !!!\n");
						}
					break;
					
			}
			
			System.out.println("SOLDAIER FINAL GAME");
			System.out.println("\nVIDA: "+ vida + " | REHÉNES: " + contadorRehenes + " | MERCENARIOS: " + contadorMercenarios + " | BALAS: " + balas + "\n");
			System.out.println("╔══════════════════════════════╗");
			for (i = 0; i < tamano; i++) {
				System.out.print("║");
				for (j = 0; j < tamano; j++) {				
					if(tablero[i][j]==0) {
						System.out.print("[ ]");
					}
					if(tablero[i][j]==1) {
						System.out.print("[♀]");
					}
					if(tablero[i][j]==2) {
						System.out.print("[∏]");
					}
					if(tablero[i][j]==3) {
						System.out.print("[☺]");
					}
					if(tablero[i][j]==4) {
						System.out.print("[☻]");
					}
					if(tablero[i][j]==5) {
						System.out.print("[▓]");
					}
					if(tablero[i][j]==6) {
						System.out.print("[®]");
					}
					if(tablero[i][j]==7) {
						System.out.print("[♥]");
					}
					if(tablero[i][j]==8) {
						System.out.print("[◘]");
					}
					if(tablero[i][j]==9) {
						System.out.print("[☼]");
					}
					if(tablero[i][j]==10) {
						System.out.print("[X]");
					}
				}
				System.out.println("║");
			}
			System.out.println("╚══════════════════════════════╝");			
			
		}while(!opcion.equals("E") && ganador==false);

		leer.close();
	}
}