package com.amazonaws.samples;

import java.util.List;
import java.util.Map.Entry;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class Messagehandler {
	void receive()
	{
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(MySQS.myQueueUrl);
        MySQS.messages = MySQS.sqs.receiveMessage(receiveMessageRequest.withMaxNumberOfMessages(1)).getMessages();
        for (Message m : MySQS.messages) {
        	MySQS.receivemessage.append(m.getBody()+"\n");
        	MySQS.sqs.deleteMessage(MySQS.myQueueUrl, m.getReceiptHandle());
		}
	}
	void send(String message)
	{
		MySQS.sqs.sendMessage(new SendMessageRequest(MySQS.myQueueUrl, message));
		System.out.println("Sending a message to "+MySQS.queuename);
	}
}
