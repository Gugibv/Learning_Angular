import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component,OnInit,inject } from '@angular/core';

@Component({
  selector: 'app-data-display',
  standalone: true,
  imports: [CommonModule,HttpClientModule],
  templateUrl: './data-display.component.html',
  styleUrl: './data-display.component.css'
})
export class DataDisplayComponent implements OnInit{

  httpClient = inject(HttpClient);
  data : any= [];
  
  apiUrl = 'product/phoneList';

   ngOnInit(): void {
    this.httpClient.get(this.apiUrl).subscribe((data: any) => {
      console.log(data);
      this.data = data;
    });
   }

}
