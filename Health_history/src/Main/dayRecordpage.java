package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import set����class.dayRecord;
import set����class.exRecord;

public class dayRecordpage extends JFrame {

	private JPanel defaultpanel;
	private JTextField weight_textField;
	private JTextField today_textField;
	private JPanel ex_list_panel; 
	private dayRecord dayrecord;
	private ActionListener addex_listener;
	
	public dayRecordpage() {
		setTitle("exRecordpage	");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,400);
		//defaultpanel = new JPanel();
		//defaultpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(defaultpanel);
		GridBagLayout gb = new GridBagLayout();
		gb.rowHeights = new int[] {50, 50,50,50,50,50,50};
		gb.columnWidths = new int[] {100,100,50,50,50};
		//defaultpanel.setLayout(gb);
		setLayout(gb);
		dayrecord = new dayRecord();
		GridBagConstraints gbc_default = new GridBagConstraints();
		
		/* ��¥ �Է� �г� */
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		top_panel.setBackground(Color.BLUE);
		
		JLabel today_Label = new JLabel("��¥");
		today_Label.setHorizontalAlignment(SwingConstants.CENTER);
		//top_panel.add(today_Label);
		gbc_default.gridx = 0;
		gbc_default.gridy = 0;
		add(today_Label,gbc_default);
		
		today_textField = new JTextField();
		top_panel.add(today_textField);
		
		gbc_default.fill = GridBagConstraints.HORIZONTAL;
		gbc_default.gridx = 1;
		gbc_default.gridy = 0;
		gbc_default.ipadx = 100;
		gbc_default.ipady = 10;
		gbc_default.anchor = GridBagConstraints.WEST;
		//defaultpanel.add(top_panel,gbc_default);
		add(today_textField,gbc_default);
		
		
		
		/* � ����Ʈ �г� */
		ex_list_panel = new JPanel();
		ex_list_panel.setBackground(Color.WHITE);
		gb = new GridBagLayout();
		gb.rowHeights = new int[]{50, 50, 50, 50, 50};
		gb.columnWidths = new int[] {50,50,50,50,50};
		ex_list_panel.setLayout(gb);
		
		gbc_default = new GridBagConstraints();
		gbc_default.fill = GridBagConstraints.BOTH;
		gbc_default.gridx = 0;
		gbc_default.gridy = 1;
		//gbc_default.ipadx = 100;
		//gbc_default.ipady = 10;
		gbc_default.gridheight = 5;
		gbc_default.gridwidth = 5;
		
		//defaultpanel.add(ex_list_panel, gbc_default);
		
		JScrollPane sp = new JScrollPane(ex_list_panel);
		//defaultpanel.add(sp);
		//add(sp);
		add(sp, gbc_default);
		
		
		/* ������ �� ��߰� �г� */
		//JPanel bottom_panel = new JPanel();
		//bottom_panel.setLayout(new BorderLayout(0, 0));
		
		// ������ �Է� �г�
		//JPanel weight_panel = new JPanel();
		//bottom_panel.add(weight_panel, BorderLayout.WEST);
		
		JLabel today_weight_label = new JLabel("������ ������");
		//weight_panel.add(today_weight_label);
		gbc_default = new GridBagConstraints();
		gbc_default.fill = GridBagConstraints.HORIZONTAL;
		gbc_default.gridx = 0;
		gbc_default.gridy = 6;
		add(today_weight_label,gbc_default);
		
		
		weight_textField = new JTextField();
		//weight_panel.add(weight_textField);
		gbc_default.gridx = 1;
		add(weight_textField,gbc_default);
		
		
		// ��߰� ��ư
		JButton addexr_button = new JButton("� �߰�");
		addex_listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addexRecordpage exr = new addexRecordpage();
				exr.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				exr.setModal(true);
				exr.setVisible(true);
				dayrecord.add_exr(new exRecord(exr.get_exname(),exr.get_setgoal()));
				
				if(!dayrecord.getExr_ary().isEmpty()) {  												// � 1���� ���� ���
					GridBagConstraints gbc = new GridBagConstraints();									// exRecord �� ���� ���� gbc
					gbc.fill = GridBagConstraints.BOTH;
					gbc.anchor =GridBagConstraints.NORTH;
					gbc.ipadx = 100;
					gbc.ipady= 10;
					gbc.gridx = 0;
					gbc.gridy = 0;
					int count = 0;
					for(exRecord tmp_exr : dayrecord.getExr_ary()) {
						expanel ex= new expanel(tmp_exr);
						gbc.gridy = count++;
						ex_list_panel.add(ex,gbc);
					}
				}
				ex_list_panel.revalidate();															// � ���� �г� �ʱ�ȭ
				ex_list_panel.repaint();
			}
		};
		addexr_button.addActionListener(addex_listener);
		//bottom_panel.add(addexr_button, BorderLayout.EAST);
		gbc_default.gridx = 4;
		gbc_default.gridwidth=2;
		//defaultpanel.add(bottom_panel, gbc_default);
		add(addexr_button, gbc_default);
		
	}
	
	class expanel extends JPanel{
		//private JPanel panel;
		
		public expanel(exRecord other_exr) {
			
			//panel= new JPanel();
			this.setLayout(new GridBagLayout());
			
			JLabel ex_name = new JLabel(other_exr.getEx().getName());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = 0;
			this.add(ex_name,gbc);
			
			JButton btn1 = new JButton("����");
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx= 3;
			gbc.gridy= 0;
			this.add(btn1);
			
			
			
		}
		
	}

}
