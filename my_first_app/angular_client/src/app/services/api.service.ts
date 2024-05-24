import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Options } from '../../type';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
     private httpClient : HttpClient

  ) { }


  get<T>(url :string,options:Options):Observable<T>{

    return this.httpClient.get<T>(url,options) as Observable<T>; 


    // 由于 HTTP 请求是异步的，使用 Observable 可以方便地处理这些异步操作。
    // 你可以使用 subscribe 方法来订阅 Observable，从而在请求完成后获取数据或者处理错误。
  }

}
