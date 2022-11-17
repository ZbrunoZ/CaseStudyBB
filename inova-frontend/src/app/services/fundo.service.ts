import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { HttpClient } from "@angular/common/http";
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";
import { Fundo } from "../models/fundo.model";

@Injectable({
  providedIn: "root",
})
export class FundoService {
    
  baseUrl = "http://localhost:8080/fundos/";

  constructor(private http: HttpClient, private snackBar: MatSnackBar) {}

  read(): Observable<Fundo[]> {
    return this.http.get<Fundo[]>(this.baseUrl+"ativos/").pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  getSuggestedPortfolio(perfil: String): Observable<any> {

    return this.http.get<any>(this.baseUrl+"sugeridos/"+perfil).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  readById(id: number): Observable<Fundo> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Fundo>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, "X", {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ["msg-error"] : ["msg-success"],
    });
  }

  errorHandler(e: any): Observable<any> {
    this.showMessage("Ocorreu um erro!", true);
    return EMPTY;
  }
}
