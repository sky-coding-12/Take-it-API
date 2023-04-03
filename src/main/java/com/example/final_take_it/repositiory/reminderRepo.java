package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reminderRepo extends JpaRepository<Reminder, Long> {
}
