import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-carteira',
  templateUrl: 'carteira-dialog.component.html',
  styles: [
  ]
})
export class CarteiraDialogComponent{

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}  
  

}

