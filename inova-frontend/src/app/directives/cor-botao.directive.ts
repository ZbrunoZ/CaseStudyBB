import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appCorBotao]'
})
export class CorBotaoDirective {

  perfil: String | undefined

  constructor(private el: ElementRef) { }

  //TODO: Implementar a mudança da cor também quando o usuário fechar o dialog
  @HostListener('click') onClick() {
    this.perfil = this.el.nativeElement.id

    if (this.perfil == 'conservador'
      || this.perfil == 'moderado'
      || this.perfil == 'arrojado') {
      this.el.nativeElement.style.color = 'royalblue'
    }



  }

}
