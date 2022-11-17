import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './views/home/home.component';
import { CarteiraSugeridaComponent } from './views/carteira-sugerida/carteira-sugerida.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  }, {
    path: "carteiras",
    component: CarteiraSugeridaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
