package com.grey.bean;

import java.util.ArrayList;
import java.util.List;

public class Products {
     private List<Product> item;
     private int page;
     private int perPage;
     private int totalPages;

     public Products(List<Product> item, int page, int perPage, int totalPages) {
          this.item = item;
          this.page = page;
          this.perPage = perPage;
          this.totalPages = totalPages;
     }

     public List<Product> getItem() {
          return item;
     }

     public void setItem(List<Product> item) {
          this.item = item;
     }

     public int getPage() {
          return page;
     }

     public void setPage(int page) {
          this.page = page;
     }

     public int getPerPage() {
          return perPage;
     }

     public void setPerPage(int perPage) {
          this.perPage = perPage;
     }

     public int getTotalPages() {
          return totalPages;
     }

     public void setTotalPages(int totalPages) {
          this.totalPages = totalPages;
     }
}
