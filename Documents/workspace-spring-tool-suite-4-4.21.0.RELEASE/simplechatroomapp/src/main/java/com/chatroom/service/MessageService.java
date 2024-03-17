package com.chatroom.service;


	import com.chatroom.model.Message;
	import org.reactivestreams.Publisher;
	import org.springframework.stereotype.Service;
	import reactor.core.publisher.EmitterProcessor;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.UUID;

	@Service
	public class MessageService {

	    private final List<Message> messages = new ArrayList<>();
	    private final EmitterProcessor<Message> messageEmitter = EmitterProcessor.create();

	    public List<Message> getAllMessages() {
	        return messages;
	    }

	    public Message sendMessage(String content, String sender) {
	        Message message = new Message(UUID.randomUUID().toString(), content, sender);
	        messages.add(message);
	        messageEmitter.onNext(message);
	        return message;
	    }

	    public Publisher<Message> subscribeToMessages() {
	        return messageEmitter;
	    }
	}


