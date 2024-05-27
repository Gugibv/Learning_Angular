package com.grey.controller;

import com.grey.bean.Product;
import com.grey.bean.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/phoneList")
    public List<String> queryList(){
        List<String> result = new ArrayList<>();
        for(int i=10000;i<10010;i++){

            result.add("phone num: "+ i);
        }

        return result;
    }


    @GetMapping("/getProductList")
    public Products getProductList(@RequestParam(name = "page", defaultValue = "1") int page,
                                   @RequestParam(name = "perPage", defaultValue = "5") int perPage){

        List<Product> dataList = this.getProductData();

        return this.paginate(dataList, page, perPage);
    }




    public  Products paginate(List<Product> dataList, int page, int perPage) {
        int totalItems = dataList.size();
        int totalPages = (int) Math.ceil((double) totalItems / perPage);

        int fromIndex = (page - 1) * perPage;
        int toIndex = Math.min(fromIndex + perPage, totalItems);

        List<Product> items = dataList.subList(fromIndex, toIndex);

        return new Products(items, page, perPage, totalPages);
    }


     public   List<Product>  getProductData(){
         List<Product> dataList = new ArrayList<>();
         // 假设这里是从数据库或其他地方获取到的商品信息
         dataList.add(new Product(1, "Black Hoodie", "assets/images/dataList/image1.jpg", "24", 5));
         dataList.add(new Product(2, "Branded Shoes", "assets/images/dataList/image2.jpg", "13.5", 4));
         dataList.add(new Product(3, "White", "assets/images/dataList/image3.jpg", "85.0", 3));
         dataList.add(new Product(4, "Gray Dress 1", "assets/images/dataList/image4.jpg", "625", 3));
         dataList.add(new Product(5, "Black T-Shirt (Mens)", "assets/images/dataList/image5.jpg", "55.0", 5));
         dataList.add(new Product(6, "Jeans Jacket", "assets/images/dataList/image6.jpg", "115.0", 4));
         dataList.add(new Product(7, "Black T-Shirt (Womens)", "assets/images/dataList/image7.jpg", "25.0", 3));
         dataList.add(new Product(8, "Beige Trench Coat", "assets/images/dataList/image8.jpg", "52.0", 1));
         dataList.add(new Product(9, "Stylish Shoes", "assets/images/dataList/image9.jpg", "32.0", 2));
         dataList.add(new Product(10, "Stylish Shoes - B", "assets/images/dataList/image10.jpg", "55.0", 5));
         dataList.add(new Product(11, "Beanie Black", "assets/images/dataList/image11.jpg", "15.0", 1));
         dataList.add(new Product(12, "Beanie Orange", "assets/images/dataList/image12.jpg", "12.5", 2));
         dataList.add(new Product(13, "Beanie Red", "assets/images/dataList/image13.jpg", "14.5", 4));
         dataList.add(new Product(15, "Cyan Long Sleeve Shirt", "assets/images/dataList/image15.jpg", "15.5", 5));
         dataList.add(new Product(16, "Yellow Raincoat", "assets/images/dataList/image16.jpg", "12.5", 3));


         return  dataList;

     }



}