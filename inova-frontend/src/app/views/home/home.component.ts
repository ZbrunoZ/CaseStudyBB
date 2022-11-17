import { Component, OnInit } from '@angular/core';
import { FundoService } from 'src/app/services/fundo.service';
import { Fundo } from 'src/app/models/fundo.model';


@Component({
  selector: 'app-home',
  templateUrl: 'home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  fundos: Fundo[] | undefined

  constructor(private fundoService: FundoService) { }

  ngOnInit(): void {

    this.fundoService.read().subscribe(fundos => {
      this.fundos = fundos
    })
  }

}
