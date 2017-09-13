package demo4;
/**
 * ����ʽ����
 * @author ding
 *
 */
import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;


public class PopStyle extends JFrame{
final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static void main(String args[]) {
		PopStyle frame = new PopStyle();
		frame.setVisible(true);
	}
	
	public PopStyle() {
		super();
		JDesktopPane desktopPane = null;// ����һ������������
		setBounds(100, 100, 690, 1149);
		setTitle("5410ʵ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �����������
		desktopPane = new JDesktopPane();// ��������������
		// �����ڲ�������϶�ģʽ
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		final JLabel backLabel = new JLabel(); // ����һ����ǩ�������
		// ��ñ���ͼƬ��·��
		URL resource = this.getClass().getResource("����.JPG");
		ImageIcon icon = new ImageIcon(resource); // ��������ͼƬ����
		backLabel.setIcon(icon); // ���ǩ�����ʾ����ͼƬ
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		// ����ǩ�����ӵ�ָ������λ��
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
		
		
		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		final JMenu workMenu = new JMenu("������W��");// �������ļ����˵�
		workMenu.setMnemonic('W');// ���ÿ�ݼ�
		menuBar.add(workMenu);// ��ӵ��˵���
		
		final JMenuItem arbitrationItem = new JMenuItem("�ٲã�Z��");// �����˵���
		arbitrationItem.setMnemonic('Z');// ���ÿ�ݼ�
		workMenu.add(arbitrationItem);// ��ӵ����ļ����˵�
		
		final JMenu collectMenu = new JMenu("�ռ���S��");// �������򿪡��Ӳ˵�
		collectMenu.setMnemonic('S');// ���ÿ�ݼ�
		workMenu.add(collectMenu);// ��ӵ����ļ����˵�
		// �����Ӳ˵���
				
		
		final JMenuItem conversationItem = new JMenuItem();
		conversationItem.setText("�Ự��S��");
		conversationItem.setMnemonic('S');
		conversationItem.setAccelerator(KeyStroke.getKeyStroke(VK_S, CTRL_MASK));
		conversationItem.addActionListener(new ItemListener());
		workMenu.add(conversationItem);
		
		workMenu.addSeparator();
		
		final JMenuItem secureItem = new JMenuItem();
		secureItem.setText("��ȫ�Ự��E��");
		secureItem.setMnemonic('E');
		secureItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		secureItem.addActionListener(new ItemListener());
		workMenu.add(secureItem);
		
		final JMenu InactivatedMenu = new JMenu();
		InactivatedMenu.setText("��E��");
		InactivatedMenu.setMnemonic('E');
		menuBar.add(InactivatedMenu);
		

				
		final JMenu sleepMenu = new JMenu("���ߣ�H��", false);
		sleepMenu.setText("���ߣ�H��");
		sleepMenu.setMnemonic('H');
		menuBar.add(sleepMenu);
		
		final JMenuItem interceptItem = new JMenuItem();
		interceptItem.setText("������L��");
		interceptItem.setMnemonic('L');
		interceptItem.addActionListener(new ItemListener());
		sleepMenu.add(interceptItem);
		
		final JMenuItem readyItem = new JMenuItem();
		readyItem.setText("������R��");
		readyItem.setMnemonic('R');
		readyItem.addActionListener(new ItemListener());
		sleepMenu.add(readyItem);
		//
	}
	
	private class ItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			System.out.println("���������ǲ˵��" + menuItem.getText());
		}
	}
}
