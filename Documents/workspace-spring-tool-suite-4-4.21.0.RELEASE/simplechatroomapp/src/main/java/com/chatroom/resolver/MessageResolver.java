package com.chatroom.resolver;


import com.chatroom.*;
import com.chatroom.service.MessageService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageResolver implements GraphQLQueryResolver, GraphQLMutationResolver, GraphQLSubscriptionResolver {

    @Autowired
    private MessageService messageService;

    public List<Message> messages() {
        return messageService.getAllMessages();
    }

    public Message sendMessage(String content, String sender) {
        return messageService.sendMessage(content, sender);
    }

    public Publisher<Message> messageSent() {
        return messageService.subscribeToMessages();
    }
}


