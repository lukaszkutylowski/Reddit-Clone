package pl.lukaszkutylowski.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.lukaszkutylowski.demo.dto.CommentsDto;
import pl.lukaszkutylowski.demo.model.Comment;
import pl.lukaszkutylowski.demo.model.Post;
import pl.lukaszkutylowski.demo.model.User;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    Comment map(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "usename", expression = "java(comment.getUser().getUsername())")
    CommentsDto mapToDto(Comment comment);
}
