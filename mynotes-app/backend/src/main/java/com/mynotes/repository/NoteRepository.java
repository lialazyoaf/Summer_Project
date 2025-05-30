package com.mynotes.repository;

import com.mynotes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface NoteRepository extends MongoRepository<Note, String> {
    // search by title or content (case‑insensitive)
    List<Note> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);

    // (optional) find all sorted by createdAt
    default List<Note> findAllByCreatedAtDesc() {
        return findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }
}
