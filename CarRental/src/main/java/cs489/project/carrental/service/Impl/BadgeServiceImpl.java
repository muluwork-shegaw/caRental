package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.Badge;
import cs489.project.carrental.repository.BadgeRepository;
import cs489.project.carrental.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Override
    public Badge saveBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    @Override
    public Badge getBadgeById(Long id) {
        return badgeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBadge(Long id) {
        badgeRepository.deleteById(id);
    }
}
