//
// Copyright (c) 2015 KMS Technology.
//
package vn.kms.lp.web.dao;

import java.util.List;

import vn.kms.lp.web.model.TestModel;

/**
 * @author thanhtran
 *
 */
public interface TestDAO {
    void save(TestModel entity);

    TestModel getById(Long id);

    List<TestModel> findByAttribute1(String attribute1);
}
