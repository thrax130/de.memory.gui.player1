package de.memory.gui.player1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.memory.api.IPlayer;
import de.memory.gui.MemoryGUI;
import de.memory.gui.OvalView;

public class Player1View extends MemoryGUI {
	
	private OvalView player1Oval = new OvalView(Color.GREEN);
	private JLabel player1Pairs = new JLabel("000");
	private JButton collectPairButton = new JButton("collect pair");
	
	public Player1View() {
		super("Player 1");
		playerNumber = 1;
	}
	@Override
	protected JComponent northView() {
		// TODO Auto-generated method stub
		return this.getHeaderView();
	}

	@Override
	protected JComponent southView() {
		collectPairButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getModel().getPlayer(1).collectPair();
			}
		});
		JPanel footer = new JPanel();
		footer.setLayout(new BorderLayout());
		footer.add(collectPairButton, BorderLayout.CENTER);
		return footer;
	}

	@Override
	protected JComponent eastView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected JComponent westView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updateView() {
		super.updateView();
		this.player1Pairs.setText(""+getModel().getPlayer(1).getAmountCardPairs());
		this.player1Pairs.repaint();
		this.player1Oval.setColor( player.isActive() ? Color.GREEN : Color.RED);
		this.player1Oval.repaint();
	}
	
	private JComponent getHeaderView() {
		JPanel header = new JPanel();
		header.setLayout(new GridLayout (2,2));
		header.add(new JLabel("Player 1"));
		header.add(this.player1Oval);
		header.add(new JLabel("Pairs:"));
		header.add(this.player1Pairs);
		
		return header;
	}
	
	@Override
	public void startNewGame() {
		//reset visibility of all memory field elements
		resetVisibilityMemoryFieldElements();
	}
}
