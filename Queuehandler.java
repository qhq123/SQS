package com.amazonaws.samples;

import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;

public class Queuehandler {
	void creatqueue(String queuename)
	{
		CreateQueueRequest createQueueRequest = new CreateQueueRequest(queuename);
		MySQS.myQueueUrl = MySQS.sqs.createQueue(createQueueRequest).getQueueUrl();
	}
	void deletequeue(String queuename)
	{
		String myQueueUrl= MySQS.sqs.createQueue(new CreateQueueRequest(queuename)).getQueueUrl();
		MySQS.sqs.deleteQueue(new DeleteQueueRequest(myQueueUrl));
	}
}
