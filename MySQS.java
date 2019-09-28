package com.amazonaws.samples;

import java.util.List;


import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class MySQS{
	static AmazonSQS sqs;
	static String myQueueUrl="";
	static String queuename="";
	static List<Message> messages;
	static StringBuilder receivemessage;
	MySQS() {
	ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
	receivemessage=new StringBuilder(); 
	try {
		credentialsProvider.getCredentials();
    } catch (Exception e) {
    throw new AmazonClientException(
        "Cannot load the credentials from the credential profiles file. " +
        "Please make sure that your credentials file is at the correct " +
        "location (C:\\Users\\62455\\.aws\\credentials), and is in valid format.",
        e);
    }
	sqs = AmazonSQSClientBuilder.standard()
          .withCredentials(credentialsProvider)
          .withRegion(Regions.US_WEST_2)
          .build();
	}
}
