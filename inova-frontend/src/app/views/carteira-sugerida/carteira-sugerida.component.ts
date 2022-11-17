import {Component} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { CarteiraDialogComponent } from '../dialogs/carteira-dialog/carteira.component';

@Component({
  selector: 'app-carteira-sugerida',
  templateUrl: 'carteira-sugerida.component.html',
  styleUrls: ['./carteira-sugerida.component.css'],
})
export class CarteiraSugeridaComponent {

  constructor(public dialog: MatDialog) {}

  openDialog() {
    this.dialog.open(CarteiraDialogComponent, {
      data: {
        animal: 'panda',
      },
    });
  }

}

