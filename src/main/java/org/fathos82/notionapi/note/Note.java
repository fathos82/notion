package org.fathos82.notionapi.note;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.fathos82.notionapi.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private String content;
    private LocalDateTime updatedAt;
    @ManyToOne
    public User ownerUser;



    public void updateDate() {
        this.updatedAt = LocalDateTime.now();
    }
}


