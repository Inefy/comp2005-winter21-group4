import java.awt.event.*;
import java.awt.Image.*;

import javax.swing.*;

public class movePawn implements ActionListener {

	public int row = 16;
	public int col = 17;
	public JButton[][] step;
	public JButton rollDice;
	public int diceValue, playerTurn;
	public ImageIcon emptySpace = new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png"));
	public ImageIcon barricade = new ImageIcon(displayBoard.class.getResource("/images/barricade.png"));
	public ImageIcon endgoal = new ImageIcon(displayBoard.class.getResource("/images/endgoal.png"));
	public ImageIcon player1 = new ImageIcon(displayBoard.class.getResource("/images/player1.png")); // this will be
																										// ImageIcon and
																										// not Icon
	public ImageIcon player2 = new ImageIcon(displayBoard.class.getResource("/images/player2.png"));
	public ImageIcon player3 = new ImageIcon(displayBoard.class.getResource("/images/player3.png"));
	public ImageIcon player4 = new ImageIcon(displayBoard.class.getResource("/images/player4.png"));
	public int flag;
	public int x1, x2;
	public int y1, y2;

	public String player1Des, player2Des, player3Des, player4Des; // to store the player descriptions (basically the
																	// path)

	public String emptySpaceDes, barricadeDes, endgoalDes; // to store the other object description

	/*
	 * the background useless(was necessary for the implementation) buttons are null
	 * if you wanna check that with something else.
	 */

	public ImageIcon sample;
	public String test; // temporary string variable to hold the file path for the current step object
						// in the loop

	public movePawn(JButton[][] buttons, JButton rolldice, int dicevalue, int playerturn) {
		step = buttons;
		rollDice = rolldice;
		diceValue = dicevalue;
		playerTurn = playerturn;

		player1Des = player1.getDescription();
		player2Des = player2.getDescription();
		player3Des = player3.getDescription();
		player4Des = player4.getDescription();
		emptySpaceDes = emptySpace.getDescription();
		barricadeDes = barricade.getDescription();
		endgoalDes = endgoal.getDescription();

		// adding action listener to all the buttons
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// FYSAL todo: only add listener to useful buttons
				// step[i][j].addActionListener(this);

				sample = (ImageIcon) step[i][j].getIcon();
				if (sample != null) // this is the most important part. it checks for the white/useless spaces which
									// are basically null objects
				{
					step[i][j].addActionListener(this);
				}

			}
		}
		
		//fysal todo: restrict the other players here
		
		
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();
		flag++;
		int i, j;
		int x, y;

		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				sample = (ImageIcon) step[i][j].getIcon();
				if (sample != null) // this is the most important part. it checks for the white/useless spaces which
									// are basically null objects
				{
					if (selected.equals(step[i][j])) {
						if (flag == 1) {
							x1 = i;
							y1 = j;
							// to disable all the buttons when player1 takes turn
							if (playerTurn == 1) {

								for (x = 0; x < row; x++) {
									for (y = 0; y < col; y++) {

										sample = (ImageIcon) step[x][y].getIcon();
										if (sample != null) // this is the most important part. it checks for the white
															// spaces which are basically null objects
										{
											test = sample.getDescription();
											if ((test.equals(player2Des) || test.equals(player3Des)
													|| test.equals(player4Des)) && (x == 14 || x == 15)) {
												step[x][y].setEnabled(false);
											}
										}

									}

								}

							}

							// to disable all the buttons when player2 takes turn
							if (playerTurn == 2) {

								for (x = 0; x < row; x++) {
									for (y = 0; y < col; y++) {

										sample = (ImageIcon) step[x][y].getIcon();
										if (sample != null) {
											test = sample.getDescription();
											if ((test.equals(player1Des) || test.equals(player3Des)
													|| test.equals(player4Des)) && (x == 14 || x == 15)) {
												step[x][y].setEnabled(false);
											}
										}

									}

								}

							}

							// to disable all the buttons when player3 takes turn
							if (playerTurn == 3) {

								for (x = 0; x < row; x++) {
									for (y = 0; y < col; y++) {

										sample = (ImageIcon) step[x][y].getIcon();
										if (sample != null) {
											test = sample.getDescription();
											if ((test.equals(player2Des) || test.equals(player1Des)
													|| test.equals(player4Des)) && (x == 14 || x == 15)) {
												step[x][y].setEnabled(false);
											}
										}

									}

								}

							}

							// to disable all the buttons when player4 takes turn
							if (playerTurn == 4) {

								for (x = 0; x < row; x++) {
									for (y = 0; y < col; y++) {

										sample = (ImageIcon) step[x][y].getIcon();
										if (sample != null) {
											test = sample.getDescription();
											if ((test.equals(player2Des) || test.equals(player3Des)
													|| test.equals(player1Des)) && (x == 14 || x == 15)) {
												step[x][y].setEnabled(false);
											}
										}

									}

								}

							}
						}
						if (flag == 2) {
							x2 = i;
							y2 = j;
							for (i = 0; i < row; i++) {
								for (j = 0; j < col; j++) {
									step[i][j].setEnabled(true);
								}
							}
							if (x2 == 14 || x2 == 15) {
								flag = 1;
							} else if (playerTurn == 1) {
								step[x2][y2].setIcon(player1);
								step[x1][y1].setIcon(emptySpace);
							} else if (playerTurn == 2) {
								step[x2][y2].setIcon(player2);
								step[x1][y1].setIcon(emptySpace);
							} else if (playerTurn == 3) {
								step[x2][y2].setIcon(player3);
								step[x1][y1].setIcon(emptySpace);
							} else if (playerTurn == 4) {
								step[x2][y2].setIcon(player4);
								step[x1][y1].setIcon(emptySpace);
							}
						}
					}
				}

			}
		}

	}

}
