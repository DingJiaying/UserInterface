package demo3;
/**
 * ��ϰ�ڲ�����
 * @author ding
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.net.*;
import javax.swing.*;

public class ExampleFrame_03 extends JFrame{
	JDesktopPane desktopPane = null;// ����һ������������
	InternalFrame pInFrame = null;// ����һ�������ڲ��������
	InternalFrame rInFrame = null;// ����һ�������ڲ��������
	InternalFrame tInFrame = null;// ����һ�������ڲ��������
	InternalFrame qInFrame = null;// ����һ�������ڲ��������
	InternalFrame sInFrame = null;// ����һ������ڲ��������
	
	
	public static void main(String args[]) {
		ExampleFrame_03 frame = new ExampleFrame_03();//ʵ��������
		frame.setVisible(true);
	}
	public ExampleFrame_03() {
		super();
		setTitle("5410ʵ����");
		setBounds(100, 100, 690, 1149);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �����������
		desktopPane = new JDesktopPane();// ��������������
		// �����ڲ�������϶�ģʽ
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		// Ϊ����������ӱ���ͼƬ
		final JLabel backLabel = new JLabel(); // ����һ����ǩ�������
		// ��ñ���ͼƬ��·��
		URL resource = this.getClass().getResource("�󱳾�.JPG");
		ImageIcon icon = new ImageIcon(resource); // ��������ͼƬ����
		backLabel.setIcon(icon); // ���ǩ�����ʾ����ͼƬ
		// �����������ʾλ�ü���С
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		// ����ǩ������ӵ�ָ������λ��
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
		// ���Ӱ�ť
		final JPanel panel = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setLayout(flowLayout);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JButton ReadyButton = new JButton();
		ReadyButton.setText("����");
		ReadyButton
				.addActionListener(new BAListener(pInFrame, "����"));
		panel.add(ReadyButton);
		
		final JButton workButton = new JButton();
		workButton.setText("����");
		workButton
				.addActionListener(new BAListener(rInFrame, "����"));
		panel.add(workButton);
		
		final JButton sleepButton = new JButton();
		sleepButton.setText("����");
		sleepButton
				.addActionListener(new BAListener(tInFrame, "����"));
		panel.add(sleepButton);
		
		final JButton interceptButton = new JButton();
		interceptButton.setText("����");
		interceptButton
				.addActionListener(new BAListener(qInFrame, "����"));
		panel.add(interceptButton);
		
		final JButton InactivatedButton = new JButton();
		InactivatedButton.setText("���");
		InactivatedButton
				.addActionListener(new BAListener(sInFrame, "���"));
		panel.add(InactivatedButton);
	}
	
	private class BAListener implements ActionListener {
		InternalFrame inFrame;
		String title;
		public BAListener(InternalFrame inFrame, String title) {
			this.inFrame = inFrame;
			this.title = title;
		}
		public void actionPerformed(ActionEvent e) {
			if (inFrame == null || inFrame.isClosed()) {
				// �����������е������ڲ�����
				JInternalFrame[] allFrames = desktopPane.getAllFrames();
				// ������������ӵ���ڲ����������
				int titleBarHight = 30 * allFrames.length;
				int x = 10 + titleBarHight, y = x;// ���ô������ʾλ��
				int width = 250, height = 180;// ���ô���Ĵ�С
				inFrame = new InternalFrame(title);// ����ָ��������ڲ�����
				// ���ô������ʾλ�ü���С
				inFrame.setBounds(x, y, width, height);
				inFrame.setVisible(true);// ���ô���ɼ�
				desktopPane.add(inFrame);// ���������ӵ����������
			}
			try {
				inFrame.setSelected(true);// ѡ�д���
			} catch (PropertyVetoException propertyVetoE) {
				propertyVetoE.printStackTrace();
			}
		}
	}
	private class InternalFrame extends JInternalFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InternalFrame(String title) {
			super();
			setTitle(title);// �����ڲ�����ı���
			setResizable(true);// �����������ɵ�����С
			setClosable(true);// �����ṩ�رհ�ť
			setIconifiable(true);// �����ṩͼ�껯��ť
			setMaximizable(true);// �����ṩ��󻯰�ť
			// ���ͼƬ��·��
			URL resource = this.getClass().getResource("in_frame.png"); 
			ImageIcon icon = new ImageIcon(resource); // ����ͼƬ����
			setFrameIcon(icon); // ���ô���ͼ��
		}
	}
}