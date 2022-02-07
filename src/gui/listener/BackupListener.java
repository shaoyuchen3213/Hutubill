package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;


public class BackupListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		BackupPanel p  = BackupPanel.instance;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if(mysqlPath.length() == 0) {
			JOptionPane.showMessageDialog(p, "备份前请事先配置mysql的路径");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		File file = new File("D:\\test");
		if(!file.exists()) {
			file.mkdir();
		}
		String fileName = JOptionPane.showInputDialog(null);
		File datafile = new File(file + File.separator + fileName+ ".sql");
		if(datafile.exists()) {
			JOptionPane.showMessageDialog(p, "文件名已存在，请更换");
			return;
		}
		try {
			MysqlUtil.backup(mysqlPath,datafile.getAbsolutePath());
			JOptionPane.showMessageDialog(p, "备份成功,备份文件位于:\r\n"+file.getAbsolutePath());
		}catch (Exception e1) {
			e1.printStackTrace();
            JOptionPane.showMessageDialog(p, "备份失败\r\n,错误:\r\n"+e1.getMessage());  
		}
	}
}
