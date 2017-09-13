package demo4;
/**
 * 弹出式界面
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
		JDesktopPane desktopPane = null;// 定义一个桌面面板对象
		setBounds(100, 100, 690, 1149);
		setTitle("5410实验室");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 创建桌面面板
		desktopPane = new JDesktopPane();// 创建桌面面板对象
		// 设置内部窗体的拖动模式
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		final JLabel backLabel = new JLabel(); // 创建一个标签组件对象
		// 获得背景图片的路径
		URL resource = this.getClass().getResource("背景.JPG");
		ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
		backLabel.setIcon(icon); // 令标签组件显示背景图片
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		// 将标签组件添加到指定索引位置
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
		
		
		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		final JMenu workMenu = new JMenu("工作（W）");// 创建“文件”菜单
		workMenu.setMnemonic('W');// 设置快捷键
		menuBar.add(workMenu);// 添加到菜单栏
		
		final JMenuItem arbitrationItem = new JMenuItem("仲裁（Z）");// 创建菜单项
		arbitrationItem.setMnemonic('Z');// 设置快捷键
		workMenu.add(arbitrationItem);// 添加到“文件”菜单
		
		final JMenu collectMenu = new JMenu("收集（S）");// 创建“打开”子菜单
		collectMenu.setMnemonic('S');// 设置快捷键
		workMenu.add(collectMenu);// 添加到“文件”菜单
		// 创建子菜单项
				
		
		final JMenuItem conversationItem = new JMenuItem();
		conversationItem.setText("会话（S）");
		conversationItem.setMnemonic('S');
		conversationItem.setAccelerator(KeyStroke.getKeyStroke(VK_S, CTRL_MASK));
		conversationItem.addActionListener(new ItemListener());
		workMenu.add(conversationItem);
		
		workMenu.addSeparator();
		
		final JMenuItem secureItem = new JMenuItem();
		secureItem.setText("安全会话（E）");
		secureItem.setMnemonic('E');
		secureItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		secureItem.addActionListener(new ItemListener());
		workMenu.add(secureItem);
		
		final JMenu InactivatedMenu = new JMenu();
		InactivatedMenu.setText("灭活（E）");
		InactivatedMenu.setMnemonic('E');
		menuBar.add(InactivatedMenu);
		

				
		final JMenu sleepMenu = new JMenu("休眠（H）", false);
		sleepMenu.setText("休眠（H）");
		sleepMenu.setMnemonic('H');
		menuBar.add(sleepMenu);
		
		final JMenuItem interceptItem = new JMenuItem();
		interceptItem.setText("侦听（L）");
		interceptItem.setMnemonic('L');
		interceptItem.addActionListener(new ItemListener());
		sleepMenu.add(interceptItem);
		
		final JMenuItem readyItem = new JMenuItem();
		readyItem.setText("就绪（R）");
		readyItem.setMnemonic('R');
		readyItem.addActionListener(new ItemListener());
		sleepMenu.add(readyItem);
		//
	}
	
	private class ItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			System.out.println("您单击的是菜单项：" + menuItem.getText());
		}
	}
}
