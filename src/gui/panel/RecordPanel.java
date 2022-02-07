package gui.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JComboBox;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.Date;

import util.GUIUtil;
import util.ColorUtil;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import gui.panel.WorkingPanel;
import service.CategoryService;
import entity.Category;

public class RecordPanel extends WorkingPanel{
	static {
		GUIUtil.useLNF();
	}
	public static RecordPanel instance = new RecordPanel();
	JLabel lSpend = new JLabel("花费（￥）");
	JLabel lCategory = new JLabel("分类");
	JLabel lComment = new JLabel("备注");
	JLabel lDate = new JLabel("日期");
	
	public JTextField tfSpend = new JTextField("0");
	public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
	public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
	public JTextField tfComment = new JTextField();
	public JXDatePicker datepick = new JXDatePicker(new Date());
	
	JButton bSumbit = new JButton("记一笔");
	
	public RecordPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
		GUIUtil.setColor(ColorUtil.blueColor, bSumbit);
		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		
		int gap = 40;
		pInput.setLayout(new GridLayout(4,2,gap, gap));
		
		pInput.add(lSpend);
		pInput.add(tfSpend);
		pInput.add(lCategory);
		pInput.add(cbCategory);
		pInput.add(lComment);
		pInput.add(tfComment);
		pInput.add(lDate);
		pInput.add(datepick);
		
		pSubmit.add(bSumbit);
		
		this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);
        
        addListener();
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }

	@Override
	public void updateData() {
		
		// TODO Auto-generated method stub
		cbModel.cs = new CategoryService().list();
		cbCategory.updateUI();
		resetInput();
		tfSpend.grabFocus();
	}

	private void resetInput() {
		// TODO Auto-generated method stub
		tfSpend.setText("0");
		tfComment.setText("");
		if(0 !=cbModel.cs.size())
			cbCategory.setSelectedIndex(0);
		datepick.setDate(new Date());
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecordListener listener = new RecordListener();
		bSumbit.addActionListener(listener);
	}

	public Category geSelectedCategory() {
		// TODO Auto-generated method stub
		return (Category) cbCategory.getSelectedItem();
	}
	
	
}
