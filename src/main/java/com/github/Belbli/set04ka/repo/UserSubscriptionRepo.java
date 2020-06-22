package com.github.Belbli.set04ka.repo;

import com.github.Belbli.set04ka.domain.User;
import com.github.Belbli.set04ka.domain.UserSubscription;
import com.github.Belbli.set04ka.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);
}
