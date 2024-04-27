package cs489.project.carrental.utility;

import cs489.project.carrental.model.domain.User;
import cs489.project.carrental.repository.UserRepo;
import cs489.project.carrental.security.APIUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Util {

    private final UserRepo userRepo;

    public User getUserFromContext() {
        var context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (context.equals("anonymousUser"))
            return null;

        var customUser = (APIUserDetails) context;
        Long id = customUser.getId();

        var user = userRepo.findById(id);
        return user.get();
    }

}
