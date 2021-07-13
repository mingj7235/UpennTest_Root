package com.joshua.repository.members;

import com.joshua.domain.members.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
