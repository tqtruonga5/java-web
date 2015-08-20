package vn.kms.lp.dao;

import vn.kms.lp.model.UserModel;

/**
 * @author truongtran
 *
 */
public interface UserDAO {
    UserModel getByUsername(String username);
    boolean validate(String username, String password);
}
