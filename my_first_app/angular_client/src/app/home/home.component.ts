import { Component } from '@angular/core';
import { ProductsService } from '../services/products.service';
import { Product ,Products } from '../../type';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  // it can be used for initialiaztion logc, but it is generally recommended to move all initalization logic to lifecycle hooks like ngOnInit  

  constructor(
     private productsService: ProductsService
  ){}

 

  ngOnInit(){
     this.productsService.getProducts('', { page: 0, perPage: 5 }).subscribe((products: Products) => {
      console.log(products);
    });
  }
 

}       
