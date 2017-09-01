package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Post;
import com.java.util.DbUtil;

public class PostDao {
	private Connection connection;

	public PostDao() {
		connection = DbUtil.getConnection();
	}

	public void addPost(Post post) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into posts(title,description) values (?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setString(2, post.getDescription());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePost(int postId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from posts where postid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, postId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void updatePost(Post post) {
        try {
            PreparedStatement preparedStatement = connection
					.prepareStatement("update posts set title=?, description=?" +
                            "where postid=?");
            // Parameters start with 1
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getDescription());
            preparedStatement.setInt(3, post.getPostid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<Post>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from posts");
            while (rs.next()) {
                Post post = new Post();
                
                post.setPostid(rs.getInt("postid"));
                post.setTitle(rs.getString("title"));
                post.setDescription(rs.getString("description"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }
	
	public Post getPostById(int postId) {
        Post post = new Post();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from posts where postid=?");
            preparedStatement.setInt(1, postId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {            	
            	post.setPostid(rs.getInt("postid"));
                post.setTitle(rs.getString("title"));
                post.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return post;
    }

}
