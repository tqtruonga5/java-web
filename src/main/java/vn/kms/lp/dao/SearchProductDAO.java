package vn.kms.lp.dao;

import java.util.List;

import vn.kms.lp.model.ProductModel;

public interface SearchProductDAO {
     List<ProductModel> searchByFeatures(String name,String category,String fromPrice,String toPrice,String orderBy);
}
