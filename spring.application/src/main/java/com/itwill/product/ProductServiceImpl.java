package com.itwill.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productService")
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	public ProductServiceImpl() {
		//productDao=new ProductDaoImpl();
		System.out.println("2-1.#### ProductServiceImpl()생성자:"+this);
	}
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		System.out.println("2-2.#### ProductServiceImpl("+productDao+")생성자:"+this);
		this.productDao=productDao;
	}
	@Override
	public void setProductDao(ProductDao productDao) {
		System.out.println("3.#### ProductServiceImpl.setProductDao("+productDao+")호출");
		this.productDao = productDao;
	}
	@Override
	public List<Product> productList(){
		return productDao.productList();
	}
	@Override
	public Product productDetail(int p_no) {
		return productDao.productDetail(p_no);
	}
}
