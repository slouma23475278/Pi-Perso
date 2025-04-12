import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ActualitesComponent } from './actualites/actualites.component';
import { AvantagesClientsComponent } from './avantages-clients/avantages-clients.component';
import { BlogComponent } from './blog/blog.component';
import { BonplanComponent } from './bonplan/bonplan.component';
import { DocumentsComponent } from './documents/documents.component';
import { RapportComponent } from './rapport/rapport.component';

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'actualites', component: ActualitesComponent },
  { path: 'avantages-clients', component: AvantagesClientsComponent },
  { path: 'blog', component: BlogComponent },
  { path: 'bonplan', component: BonplanComponent },
  { path: 'documents', component: DocumentsComponent },
  { path: 'rapport', component: RapportComponent },
  { path: '', redirectTo: '/about', pathMatch: 'full' },
  { path: '**', redirectTo: '/about' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
