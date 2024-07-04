package com.example.blogapp;
import java.util.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class BlogPostListDemo {

    public static void main(String[] args) {
        BlogPostService service = new BlogPostService();

        // Demonstrate creating and populating a list
        service.createSamplePosts();

        // Demonstrate various List operations and concepts
        service.demonstrateListOperations();
    }
}

class BlogPostService {
    private List<Post> posts;

    public BlogPostService() {
        // Initialize the list
        this.posts = new ArrayList<>();
    }

    public void createSamplePosts() {
        // Adding elements to the list
        posts.add(new Post(1, "Java Basics", "Learn Java fundamentals", 1, true, LocalDateTime.now()));
        posts.add(new Post(2, "Spring Boot", "Introduction to Spring Boot", 1, false, LocalDateTime.now().minusDays(1)));
        posts.add(new Post(3, "Microservices", "Building microservices with Spring", 2, true, LocalDateTime.now().minusDays(2)));
        posts.add(new Post(4, "JPA Basics", "Learn JPA and Hibernate", 2, true, LocalDateTime.now().minusDays(3)));

        System.out.println("Sample posts created. Total posts: " + posts.size());
    }

    public void demonstrateListOperations() {
        System.out.println("\n--- Demonstrating List Operations ---");

        // 1. Accessing elements
        System.out.println("First post: " + posts.get(0).getTitle());

        // 2. Updating elements
        posts.set(1, new Post(2, "Spring Boot Advanced", "Advanced Spring Boot topics", 1, true, LocalDateTime.now()));
        System.out.println("Updated second post: " + posts.get(1).getTitle());

        // 3. Removing elements
        posts.remove(3);
        System.out.println("Removed last post. New size: " + posts.size());

        // 4. Iterating over the list
        System.out.println("\nAll posts (using for-each loop):");
        for (Post post : posts) {
            System.out.println(post.getTitle());
        }

        // 5. Using streams to filter the list
        List<Post> approvedPosts = posts.stream()
                                        .filter(Post::isApproved)
                                        .collect(Collectors.toList());
        System.out.println("\nApproved posts: " + approvedPosts.size());

        // 6. Using streams to map the list
        List<String> postTitles = posts.stream()
                                       .map(Post::getTitle)
                                       .collect(Collectors.toList());
        System.out.println("All titles: " + postTitles);

        // 7. Sorting the list
        posts.sort(Comparator.comparing(Post::getCreationDate));
        System.out.println("\nSorted posts by creation date:");
        posts.forEach(post -> System.out.println(post.getCreationDate() + ": " + post.getTitle()));

        // 8. Demonstrating getPostsByUserId
        int userId = 1;
        List<Post> userPosts = getPostsByUserId(userId);
        System.out.println("\nPosts by user " + userId + ": " + userPosts.size());

        // 9. Demonstrating immutable list
        List<String> categories = List.of("Technology", "Programming", "Java");
        System.out.println("\nCategories (immutable): " + categories);

        // This would throw an UnsupportedOperationException:
        // categories.add("Spring");
    }

    // Example of filtering a list
    public List<Post> getPostsByUserId(int userId) {
        return posts.stream()
                    .filter(post -> post.getUserId() == userId)
                    .collect(Collectors.toList());
    }

    // Example of getting approved posts
    public List<Post> getApprovedPosts() {
        return posts.stream()
                    .filter(Post::isApproved)
                    .collect(Collectors.toList());
    }

    // Example of mapping posts to titles
    public List<String> getPostTitles() {
        return posts.stream()
                    .map(Post::getTitle)
                    .collect(Collectors.toList());
    }
}

class Post {
    private int id;
    private String title;
    private String content;
    private int userId;
    private boolean approved;
    private LocalDateTime creationDate;

    // Constructor
    public Post(int id, String title, String content, int userId, boolean approved, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.approved = approved;
        this.creationDate = creationDate;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public int getUserId() { return userId; }
    public boolean isApproved() { return approved; }
    public LocalDateTime getCreationDate() { return creationDate; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setApproved(boolean approved) { this.approved = approved; }
}