package org.fathos82.notionapi.user;

public record CreateUserRequest(String userName, String fullName, String email, String password) {
}
