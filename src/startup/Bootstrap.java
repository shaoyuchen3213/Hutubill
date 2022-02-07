package startup;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.DateUtil;
import util.GUIUtil;

public class Bootstrap {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		GUIUtil.useLNF();
		
		SwingUtilities.invokeAndWait(new Runnable(){
			@Override
			public void run() {
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
		});
	}

}
