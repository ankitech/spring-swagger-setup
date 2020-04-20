package ankitech.springswagger.service;

import ankitech.springswagger.model.User;

public interface UserService {

    User findById(String id);

    User createUser(User user);

    User updateUser(String id, User user);

    void deleteUser(String id);
}
