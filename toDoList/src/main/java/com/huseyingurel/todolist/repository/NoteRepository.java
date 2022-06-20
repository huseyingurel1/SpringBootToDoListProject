package com.huseyingurel.todolist.repository;

import com.huseyingurel.todolist.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository< Note,Long > {
}
