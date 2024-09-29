package com.dperezba.notes_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    @SequenceGenerator(name = "note_id_seq", sequenceName = "note_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "note_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "note_id")
    public Integer noteId;

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "body", columnDefinition = "TEXT")
    public String body;

    @Column(name = "num_order", nullable = false)
    public Short numOrder;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    public LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    public LocalDateTime updatedAt;

    @Column(name = "status", nullable = false)
    public Short status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "fk_users_notes"))
    private User user;

}
