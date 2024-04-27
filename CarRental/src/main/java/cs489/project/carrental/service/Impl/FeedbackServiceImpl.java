package cs489.project.carrental.service.Impl;

import cs489.project.carrental.DTO.FeedbackDto;
import cs489.project.carrental.model.domain.Feedback;
import cs489.project.carrental.repository.FeedbackRepository;
import cs489.project.carrental.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository feedbackRepository;
    private ModelMapper modelMapper;

    FeedbackServiceImpl(FeedbackRepository feedbackRepository, ModelMapper modelMapper) {
        this.feedbackRepository = feedbackRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    public List<FeedbackDto> browseFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream().map(feedback -> modelMapper.map(feedback, FeedbackDto.class)).toList();
    }

    public List<FeedbackDto> browseFeedBacksByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        Stream<Feedback> feedbackStream = feedbacks.stream().filter(feedback -> feedback.getUpdatedAt().isBefore(endDate)
                && feedback.getUpdatedAt().isAfter(startDate));
        return feedbackStream.map(feedback -> modelMapper.map(feedback, FeedbackDto.class)).toList();
    }
}
