package teamproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Login.SubFrame1;
import Login.User;

public class ���� {

	
	
	// ��ư �߰� �� ActionListener ����
	JButton login_Button = new JButton("�α���");
	login_Button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// ��ϵ� ȸ������ üũ
					SubFrame1 sb = new SubFrame1();
					sb.setVisible(true);
		}
}
