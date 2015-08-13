//
// Copyright (c) 2015 KMS Technology.
//
package vn.kms.lp.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import vn.kms.lp.dao.TestDAO;
import vn.kms.lp.model.TestModel;

/**
 * @author thanhtran
 *
 */
public class TestDAOMemoryImpl implements TestDAO {
    private static TestDAO instance;

    private Map<Long, TestModel> data;
    private AtomicLong idGenerator;

    private TestDAOMemoryImpl() {
        data = new ConcurrentHashMap<>();
        idGenerator = new AtomicLong(1);
    }

    @Override
    public void save(TestModel entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getAndIncrement());
        }
        data.put(entity.getId(), entity);
    }

    @Override
    public TestModel getById(Long id) {
        return data.get(id);
    }

    @Override
    public List<TestModel> findByAttribute1(String attribute1) {
        return data.values()
                .stream()
                .filter(testModel -> attribute1.equals(testModel.getAttribute1()))
                .collect(Collectors.toList());
    }

    public synchronized static final TestDAO getInstance() {
        if (instance == null) {
            instance = new TestDAOMemoryImpl();
        }
        return instance;
    }
}
