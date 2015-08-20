package vn.kms.lp.dao;

import java.util.List;

import vn.kms.lp.model.ProductModel;

public interface ProductDAO {
    public void save(ProductModel product);
    public void update(ProductModel product);
    public void deleteById(int id);
    public List<ProductModel> getAll();
    ProductModel getById(int id);
}
