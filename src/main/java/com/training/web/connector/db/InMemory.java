package com.training.web.connector.db;

import com.training.web.connector.db.dto.UserDTO;
import com.training.web.domain.exception.UserNotException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Profile("memory")
public class InMemory implements DataSource {

    private final ConcurrentHashMap<Long, UserDTO> memory = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);
    @Override
    public UserDTO getByUserId(Long id) {
        return memory.get(id);
    }

    @Override
    public UserDTO getByName(String name) {
        return memory.values().stream()
                .filter(userDTO -> userDTO.getName().equals(name))
                .findFirst().orElseThrow(() -> new UserNotException("User Not found"));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        memory.put(counter.incrementAndGet(), userDTO);
        return userDTO;
    }
}
