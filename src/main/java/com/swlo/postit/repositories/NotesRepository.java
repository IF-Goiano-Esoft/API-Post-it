package com.swlo.postit.repositories;

import com.swlo.postit.entities.Notes;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Long> {

}
