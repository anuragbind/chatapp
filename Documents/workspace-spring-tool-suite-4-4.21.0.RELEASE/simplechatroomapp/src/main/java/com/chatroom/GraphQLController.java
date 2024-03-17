package com.chatroom;





import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphQLController {

    @Autowired
    
    private GraphQL graphQL;

    @PostMapping("/graphql")
    public ExecutionResult executeQuery(@RequestBody String query) {
        return graphQL.execute(query);
    }
}
