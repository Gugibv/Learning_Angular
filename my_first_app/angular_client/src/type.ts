import { HttpContext, HttpHeaders, HttpParams } from "@angular/common/http";

// 用于描述一个包含 HTTP 请求选项的对象
export interface Options{

    headers?: HttpHeaders | {
        [header: string]: string | string[];
    };
    observe?: 'body'; //  当 observe 被设置为 'body' 时，你将仅仅接收到响应的主体部分，而不包括其他任何元数据或事件
    context?: HttpContext;
    params?: HttpParams | {
        [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>;
    };
    reportProgress?: boolean;
    responseType?: 'json';
    withCredentials?: boolean;
    transferCache?: {
        includeHeaders?: string[];
    } | boolean;

}


export interface Products{
    items: Product[];
    total: number;
    page: number;
    perPage: number;
    totalPages: number;

}

export interface Product{
    price: string;
    name: string;
    images: string;
    rating: number;
    
}


export interface PaginationParams{
    [key:string]:string | number | boolean |ReadonlyArray<string | number | boolean>; //  允许你定义对象的索引类型，以便能够通过字符串或数字来访问对象的属性
    page: number ;
    perPage :number;
}

// 字符串索引签名：允许你通过字符串来访问对象的属性。它的语法是 [key: string]: valueType;，其中 key 是字符串类型，valueType 是对应属性的值类型。例如：
// interface StringIndexed {
//     [key: string]: number;
// }

// let myObj: StringIndexed = {
//     "a": 1,
//     "b": 2
// };

// console.log(myObj["a"]); // 输出: 1
// console.log(myObj["b"]); // 输出: 2