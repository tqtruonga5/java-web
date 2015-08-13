//
// Copyright (c) 2015 KMS Technology.
//
package vn.kms.lp.model;

import java.io.Serializable;

/**
 * @author thanhtran
 *
 */
public class TestModel implements Serializable {

    private static final long serialVersionUID = 1137872248033620999L;

    private Long id;

    private String attribute1;

    private Long attribute2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public Long getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(Long attribute2) {
        this.attribute2 = attribute2;
    }

}
