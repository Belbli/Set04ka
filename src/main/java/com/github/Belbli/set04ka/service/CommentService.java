package com.github.Belbli.set04ka.service;

import com.github.Belbli.set04ka.domain.Comment;
import com.github.Belbli.set04ka.domain.Message;
import com.github.Belbli.set04ka.domain.User;
import com.github.Belbli.set04ka.domain.Views;
import com.github.Belbli.set04ka.dto.EventType;
import com.github.Belbli.set04ka.dto.ObjectType;
import com.github.Belbli.set04ka.repo.CommentRepo;
import com.github.Belbli.set04ka.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;


    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
