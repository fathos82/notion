package org.fathos82.notionapi.user;

public record UserResponse(Long id,String username, String email) {
    public UserResponse(User user) {
        this(user.getId(), user.getUsername(), user.getEmail());
    }
}
