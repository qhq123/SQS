package com.amazonaws.samples;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Sender extends JFrame{

	Sender()
	{
		MySQS a=new MySQS(); 
		final Queuehandler q=new Queuehandler();
		final Messagehandler m=new Messagehandler();
		
		this.setTitle("Sender");
		this.setBounds(400,200,400,200);
		JButton button1=new JButton("Select queue");
		final JTextArea textArea1=new JTextArea();
		JButton button2=new JButton("Send");
		final JTextArea textArea2=new JTextArea();
		this.add(textArea1);
		this.add(button1);
		this.add(textArea2);
		this.add(button2);
		this.setLayout(new BorderLayout());
		button1.setBounds(250, 20, 110, 20);
		textArea1.setBounds(50, 20, 170, 20);
		button2.setBounds(270, 80, 70, 30);
		textArea2.setBounds(50, 60, 170, 70);
		this.setVisible(true);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String input=textArea1.getText();
				q.creatqueue(input);
				MySQS.queuename=input;
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String input=textArea2.getText();
				m.send(input);
				textArea2.setText("");
			}
		});
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Sender s=new Sender();
	}
	
	
}
