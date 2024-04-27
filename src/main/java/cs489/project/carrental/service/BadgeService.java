package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Badge;

public interface BadgeService {
    Badge saveBadge(Badge badge);
    Badge getBadgeById(Long id);
    void deleteBadge(Long id);
}
