import java.awt.event.*;
import javax.swing.*;

public class movePawn implements ActionListener {

	public int row = 16;
	public int col = 17;
	public JButton[][] step;
	public JButton rollDice;
	public int diceValue, playerTurn;
	public JLabel valueLabel, turnOrder;
	public ImageIcon emptySpace = new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png"));
	public ImageIcon barricade = new ImageIcon(displayBoard.class.getResource("/images/barricade.png"));
	public ImageIcon endgoal = new ImageIcon(displayBoard.class.getResource("/images/endgoal.png"));
	public ImageIcon player1 = new ImageIcon(displayBoard.class.getResource("/images/player1.png"));
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
	 * if you wanna check something else, keep those useless stuffs in mind. wasted
	 * our precious time!! thanks Aman for figuring it out!!!
	 */

	public ImageIcon sample;
	// public String temp; // temporary string variable to hold the file path for
	// the current step[][] object
	// in the loop

	public movePawn(JButton[][] buttons, JButton rolldice, int dicevalue, int playerturn, JLabel valuelabel, JLabel turnorder) {
		step = buttons;
		rollDice = rolldice;
		diceValue = dicevalue;
		playerTurn = playerturn;
		valueLabel = valuelabel;
		turnOrder = turnorder;

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

				sample = (ImageIcon) step[i][j].getIcon();
				if (sample != null) // this is the most important part. it checks for the white/useless spaces which
									// are basically null objects
				{
					step[i][j].addActionListener(this); // adding action listener to only useful buttons

					step[i][j].setEnabled(false); // disable all the buttons, later enable for each player

					// fysal todo: restrict the other players here
					String temp = sample.getDescription();

					// to enable player1 pawns
					if (playerTurn == 1) {
						if (temp.equals(player1Des)) {
							step[i][j].setEnabled(true);
						}
					}
					// to enable player2 pawns
					if (playerTurn == 2) {
						if (temp.equals(player2Des)) {
							step[i][j].setEnabled(true);
						}
					}
					// to enable player3 pawns
					if (playerTurn == 3) {
						if (temp.equals(player3Des)) {
							step[i][j].setEnabled(true);
						}
					}
					// to enable player4 pawns
					if (playerTurn == 4) {
						if (temp.equals(player4Des)) {
							step[i][j].setEnabled(true);
						}
					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();

		flag++;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sample = (ImageIcon) step[i][j].getIcon();
				if (sample != null) // this is the most important part. it checks for the white/useless spaces which
									// are basically null objects
				{
					if (selected.equals(step[i][j])) {

						if (flag == 1) {
							x1 = i;
							y1 = j;
							// System.out.println("i'm here!");
							// fysal todo: restrict the other players here
							for (int x = 0; x < row; x++) {
								for (int y = 0; y < col; y++) {
									// System.out.println("i'm here!");
									sample = (ImageIcon) step[x][y].getIcon();

									// to disable last two rows and enable other things (LATER ONLY
									// ENABLE LEGAL MOVES)
									if (sample != null) {
										
										@SuppressWarnings("unused")
										String temp = sample.getDescription();
										
										/*
										 *  if (temp.equals(emptySpaceDes)) { //
										 * System.out.println("i'm here!"); step[x][y].setEnabled(true); }
										 * 
										 * else { // System.out.println("i'm here!"); step[x][y].setEnabled(false); }
										 */
										
										if (x < (row - 2)) {
											step[x][y].setEnabled(true);
										}
										else {
											step[x][y].setEnabled(false);
										}
									}
								}
							}
						}

						else if (flag == 2) {
							x2 = i;
							y2 = j;

							/*
							 * if x1,y1 is a barricade we have to move it to a legal move if x1,y1 is
							 * another pawn we have to move it to it's players starting position
							 */
							
							if (playerTurn == 1) {
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

							for (int x = 0; x < row; x++) {
								for (int y = 0; y < col; y++) {
									sample = (ImageIcon) step[x][y].getIcon();
									if (sample != null) {
										step[x][y].setEnabled(true);
									} else {
										step[x][y].setEnabled(false);
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
