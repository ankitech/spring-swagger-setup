package ankitech.springswagger.service;

import ankitech.springswagger.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findById(String id) {
        return User.builder()
                .id(id)
                .firstName("first")
                .lastName("last")
                .dob(LocalDate.now())
                .email("some@domain.com")
                .phone("123456790")
                .rCreTime(LocalDateTime.now())
                .rModTime(LocalDateTime.now())
                .build();
    }

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setRCreTime(LocalDateTime.now());
        user.setRModTime(LocalDateTime.now());
        return user;
    }

    @Override
    public User updateUser(String id, User user) {

        //Search for existing record and then update it
        // User existingUser = userRepository.findById(id).orElseThrow(() -> new UserException(HttpStatus.NOT_FOUND, "User not found to update"));

        //if (!existingUser.getPhone().equals(user.getPhone())) {
        //    throw new UserException(HttpStatus.CONFLICT, "Phone number does not match");
        //}

        user.setId(id);
        user.setRCreTime(user.getRCreTime());
        user.setRModTime(LocalDateTime.now());
        return user;
    }

    @Override
    public void deleteUser(String id) {
        //search for existing record and then delete it

        //User existingUser = userRepository.findById(id).orElseThrow(() -> new UserException(HttpStatus.NOT_FOUND, "User not found to delete"));
        //userRepository.delete(existingUser);
    }
}
