package lab8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

public class ComputedUI {
	Computed computed;
	ReturnInfor returnInfor;
	JFrame frame;
	JButton start;
	JTextField computedText;
	JTextArea jTextArea;
	JPanel northPanel;
	
	public ComputedUI() {
		frame=new JFrame("阶乘计算");
		frame.setSize(500,400);
		computedText=new JTextField();
		computedText.setColumns(10);
		
		start=new JButton("开始计算");
		
		northPanel=new JPanel();
		northPanel.add(new JLabel("输入值："));
		northPanel.add(computedText);
		northPanel.add(start);
		
		frame.add(northPanel,BorderLayout.NORTH);
		jTextArea=new JTextArea();
		jTextArea.setFont(new Font("微软雅黑",Font.PLAIN,16));
		JScrollPane jScrollPane=new JScrollPane(jTextArea);
		
		
		frame.add(jScrollPane,BorderLayout.CENTER);
		frame.setVisible(true);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int sum=Integer.parseInt(computedText.getText());
				computed=new Computed(sum);
				computed.start();
				returnInfor=new ReturnInfor(computed,new ComputAble() {
					public void log(String msg,BigInteger result)
					{
						jTextArea.append(msg+"="+result+"\n");
					}
				});
				new Thread(returnInfor).start();
			}
		});
		
		
	}
	
}
