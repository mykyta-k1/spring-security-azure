package com.security.testing.service.contract;

import com.security.testing.model.User;

public interface UserService {

    User getById(Long id);

    User create(User user);

    User update(User user);

    void delete(Long id);

}
