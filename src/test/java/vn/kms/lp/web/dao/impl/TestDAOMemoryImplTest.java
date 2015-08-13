//
// Copyright (c) 2015 Health Market Science, Inc.
//
package vn.kms.lp.web.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vn.kms.lp.web.dao.TestDAO;
import vn.kms.lp.web.model.TestModel;

public class TestDAOMemoryImplTest {
    private TestDAO testDAO;

    @Before
    public void init() {
        testDAO = TestDAOMemoryImpl.getInstance();
    }

    @Test
    public void testSaveAndGet() {
        TestModel test1 = createData("Att1", 123l);
        testDAO.save(test1);
        Long id = test1.getId();

        Assert.assertNotNull("ID should be auto generated", id);

        TestModel actual = testDAO.getById(test1.getId());
        Assert.assertEquals("Attribute 1 must be the same", test1.getAttribute1(), actual.getAttribute1());
        Assert.assertEquals("Attribute 2 must be the same", test1.getAttribute2(), actual.getAttribute2());

        test1.setAttribute1("Updated Attribute");
        testDAO.save(test1);
        actual = testDAO.getById(id);
        Assert.assertEquals("Attribute 1 must be 'Updated Attribute' after updating", "Updated Attribute",
                actual.getAttribute1());
    }

    @Test
    public void testFindByAttribute1() {
        testDAO.save(createData("att1", 1l));
        testDAO.save(createData("att1", 2l));
        testDAO.save(createData("att2", 3l));

        List<TestModel> modelList = testDAO.findByAttribute1("att1");
        Assert.assertEquals("There are only 2 entity with attribute1 = 'att1'", 2, modelList.size());
    }

    private TestModel createData(String attribute1, Long attribute2) {
        TestModel testModel = new TestModel();
        testModel.setAttribute1(attribute1);
        testModel.setAttribute2(attribute2);
        return testModel;
    }
}
