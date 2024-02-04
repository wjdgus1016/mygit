package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;


public class InetAddressFrameEx1 extends MFrame 
implements ActionListener{
	TextField tf;
	TextArea ta;
	Button lookup;
	InetAddress intAddr;
	
	public InetAddressFrameEx1() {
		setTitle("inetaddress example");
		add(ta=new TextArea("���ͳ� �ּ�\n"));
		Panel p =new Panel();
		p.setLayout(new BorderLayout());
		p.add(new Label("ȣ��Ʈ�̸�"),BorderLayout.NORTH);
		p.add(tf=new TextField("",40));
		p.add(lookup=new Button("ȣ��Ʈ�������"),BorderLayout.SOUTH);
		tf.addActionListener(this);
		lookup.addActionListener(this);
		ta.setFont(new Font("dialog", Font.BOLD, 15));
		ta.setForeground(Color.BLUE);
		ta.setEnabled(false);
		add(ta);
		validate();
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		if(obj==tf || obj==lookup) {
			String host =tf.getText().trim();
			try {
				intAddr =InetAddress.getByName(host);
				String add=intAddr.getHostName();
				String ip=intAddr.getHostAddress();
				ta.append(add+"\n");
				ta.append(ip+"\n");
				//ta.append(intAddr.getHostName()+"\n"+intAddr.getHostAddress());
			} catch (Exception e2) {
				ta.append(host+"\n");
				ta.append("�ش�Ǵ� ȣ��Ʈ�� �����ϴ�.\n");
			}
			tf.setText("");
			tf.requestFocus();
		}
		
		
	}
	
	public static void main(String[] args) {
		new InetAddressFrameEx1();
	}
}




























