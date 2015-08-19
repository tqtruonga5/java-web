package vn.kms.lp.dao.impl;

import vn.kms.lp.dao.UserDAO;
import vn.kms.lp.model.UserModel;

public class UserDAOImpl implements UserDAO {
    private static UserDAO instance;

    @Override
    public UserModel getByUsername(String username) {
        return null;
    }

    public synchronized static final UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }
}
