package com.amazonaws.samples;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Receiver extends JFrame{

	Receiver()
	{
		MySQS a=new MySQS(); 
		final Queuehandler q=new Queuehandler();
		final Messagehandler m=new Messagehandler();
		
		this.setTitle("Sender");
		this.setBounds(400,200,500,300);
		JButton button1=new JButton("Select queue");
		final JTextArea textArea1=new JTextArea();
		JButton button2=new JButton("Receive");
		final JTextArea textArea2=new JTextArea();
		JButton button3=new JButton("Delete queue");
		JButton button4=new JButton("clean");
		this.add(textArea1);
		this.add(button1);
		this.add(textArea2);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.setLayout(new BorderLayout());
		button1.setBounds(300, 10, 110, 20);
		textArea1.setBounds(50, 20, 220, 20);
		button2.setBounds(320, 80, 80, 30);
		textArea2.setBounds(50, 60, 220, 170);
		button3.setBounds(300, 40, 110, 20);
		button4.setBounds(320, 150, 80, 30);
		this.setVisible(true);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String input=textArea1.getText();
				MySQS.queuename=input;
				q.creatqueue(MySQS.queuename);
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m.receive();
				textArea2.setText(MySQS.receivemessage.toString());
			}
		});
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String input=textArea1.getText();
				MySQS.queuename=input;
				q.deletequeue(MySQS.queuename);
			}
		});
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				textArea2.setText("");
			}
		});
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Receiver s=new Receiver();
	}
	
	

}
