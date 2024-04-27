//package cs489.project.carrental.service.Impl;
//
//import cs489.project.carrental.model.domain.Review;
//import cs489.project.carrental.repository.ReviewRepository;
//import cs489.project.carrental.service.ReviewService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ReviewServiceImpl implements ReviewService {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @Override
//    public Review saveReview(Review review) {
//        return reviewRepository.save(review);
//    }
//
//    @Override
//    public Review getReviewById(Long id) {
//        return reviewRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void deleteReview(Long id) {
//        reviewRepository.deleteById(id);
//    }
//}
