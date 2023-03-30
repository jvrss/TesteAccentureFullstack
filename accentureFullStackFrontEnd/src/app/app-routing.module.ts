import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpresaRoutes } from './empresa/empresa-routing.module';
import { FornecedorRoutes } from './fornecedor/fornecedor-routing.module';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/homeEmpresa',
    pathMatch: 'full'
  },
  ...EmpresaRoutes,
  ...FornecedorRoutes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
