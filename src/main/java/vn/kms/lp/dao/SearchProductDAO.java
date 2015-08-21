package vn.kms.lp.dao;

import java.math.BigDecimal;
import java.util.List;

import vn.kms.lp.model.ProductModel;

public interface SearchProductDAO {
     List<ProductModel> searchByFeatures(String name,String category,BigDecimal fromPrice,BigDecimal toPrice,String orderBy);
}
