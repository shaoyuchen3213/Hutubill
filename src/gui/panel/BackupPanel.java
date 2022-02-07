package gui.panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.ColorUtil;
import util.GUIUtil;
import gui.listener.BackupListener;
public class BackupPanel extends WorkingPanel{
	

	
	public static BackupPanel instance = new BackupPanel();
	JButton bBackup = new JButton("备份");
	public BackupPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bBackup);
		this.add(bBackup);
		addListener();
	}
	

	@Override
	public void addListener() {
		BackupListener listener = new BackupListener();
		bBackup.addActionListener(listener);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIUtil.showPanel(BackupPanel.instance);
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

}
