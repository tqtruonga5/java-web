//
// Copyright (c) 2015 KMS Technology.
//
package vn.kms.lp.dao;

import java.util.List;

import vn.kms.lp.model.TestModel;

/**
 * @author thanhtran
 *
 */
public interface TestDAO {
    void save(TestModel entity);

    TestModel getById(Long id);

    List<TestModel> findByAttribute1(String attribute1);

    List<TestModel> findAll();
}
