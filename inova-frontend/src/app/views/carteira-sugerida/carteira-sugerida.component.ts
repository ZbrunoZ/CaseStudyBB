import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { FundoService } from 'src/app/services/fundo.service';
import { CarteiraDialogComponent } from '../dialogs/carteira-dialog/carteira-dialog.component';

@Component({
  selector: 'app-carteira-sugerida',
  templateUrl: 'carteira-sugerida.component.html',
  styleUrls: ['./carteira-sugerida.component.css'],
})
export class CarteiraSugeridaComponent implements OnInit {


  fundosConservadores: any;
  fundosModerados: any;
  fundosArrojados: any;

  constructor(public dialog: MatDialog, private fundoService: FundoService) { }

  ngOnInit(): void {

    this.fundoService.getSuggestedPortfolio("conservador").subscribe(fundos => {
      this.fundosConservadores = fundos
    })

    this.fundoService.getSuggestedPortfolio("moderado").subscribe(fundos => {
      this.fundosModerados = fundos
    })

    this.fundoService.getSuggestedPortfolio("arrojado").subscribe(fundos => {
      this.fundosArrojados = fundos
    })



  }

  openDialog(perfil: String) {

    let fundos: any
  
    switch (perfil) {
      case 'conservador': {
        console.log('conservador')
        fundos = this.fundosConservadores
        break;
      }
      case 'moderado': {
        console.log('moderado')
        fundos = this.fundosModerados
        break;
      }
      case 'arrojado': {
        console.log('arrojado')
        fundos = this.fundosArrojados
        break;
      }
    }


    this.dialog.open(CarteiraDialogComponent, {
      data: fundos,
    });
  }

}

