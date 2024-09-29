package com.dperezba.notes_api.repository;

import com.dperezba.notes_api.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
