import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { AboutComponent } from './about/about.component';
import { ActualitesComponent } from './actualites/actualites.component';
import { BlogComponent } from './blog/blog.component';
import { BonplanComponent } from './bonplan/bonplan.component';
import { AvantagesClientsComponent } from './avantages-clients/avantages-clients.component';
import { RapportComponent } from './rapport/rapport.component';
import { DocumentsComponent } from './documents/documents.component';
import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    ActualitesComponent,
    BlogComponent,
    BonplanComponent,
    AvantagesClientsComponent,
    RapportComponent,
    DocumentsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
