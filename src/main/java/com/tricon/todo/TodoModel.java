package com.tricon.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class TodoModel {
    @Id
    private String id;
    @NotNull(message = "Todo can't be Null")
    private String todo;
    @NotNull(message = "Todo status can't be Null!")
    private Boolean status;
    private Date createdAt;
    private Date updatedAt;
}
