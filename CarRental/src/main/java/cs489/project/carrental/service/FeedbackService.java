package cs489.project.carrental.service;

import cs489.project.carrental.DTO.FeedbackDto;
import cs489.project.carrental.model.domain.Feedback;

import java.time.LocalDateTime;
import java.util.List;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);

    Feedback getFeedbackById(Long id);

    void deleteFeedback(Long id);

    List<FeedbackDto> browseFeedBacksByPeriod(LocalDateTime startDate, LocalDateTime endDate);

    List<FeedbackDto> browseFeedbacks();
}
