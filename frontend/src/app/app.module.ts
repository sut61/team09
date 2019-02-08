import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NoopAnimationsModule} from '@angular/platform-browser/animations';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentService } from './service/appointment.service';
import { AgentAppointmentComponent } from './agent-appointment/agent-appointment.component';
import { ShowAppointmentResultComponent } from './show-appointment-result/show-appointment-result.component';
import { DiseaseAccidentDataUIComponent } from './DiseaseAccidentDataUI/DiseaseAccidentDataUI.component';
import { MemLoginComponent } from './mem-login/mem-login.component';
import { MemHomeComponent } from './mem-home/mem-home.component';
import {LoginService} from './service/login.service';
import {SessionService} from './service/session.service';
import { RegCategoryUiComponent } from './RegCategoryUi/RegCategoryUi.component';
import { LumpsumComponent } from './lumpsum/lumpsum.component';
import { MemberRegistionComponent } from './member-registion/member-registion.component';
import { AgentRegComponent } from './agent-reg/agent-reg.component';
import { MemRegService } from './service/memReg.service';

import { ClaimDataUIComponent } from './ClaimDataUI/ClaimDataUI.component';
import { OfficerLoginComponent } from './OfficerLogin/OfficerLogin.component';
import { OfficerHomeComponent } from './OfficerHome/OfficerHome.component';
import { ShowDiseaseAccidentDataResultComponent } from './ShowDiseaseAccidentDataResult/ShowDiseaseAccidentDataResult.component';
import { ShowClaimDataResultComponent } from './ShowClaimDataResult/ShowClaimDataResult.component';




const appRoutes: Routes = [
 {path: 'MemHome', component: MemHomeComponent},
 {path: 'AgentReg', component: AgentRegComponent},
{path: 'Lumpsum', component: LumpsumComponent},
{path: 'MemberRegistionComponent', component: MemberRegistionComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AgentAppointmentComponent,
    ShowAppointmentResultComponent,
	DiseaseAccidentDataUIComponent,
	MemLoginComponent,
	MemHomeComponent,
    RegCategoryUiComponent,
	DiseaseAccidentDataUIComponent,
	LumpsumComponent,
	AgentRegComponent,
	MemberRegistionComponent,
	ClaimDataUIComponent,
	OfficerLoginComponent,
	OfficerHomeComponent,
	ShowDiseaseAccidentDataResultComponent,
	ShowClaimDataResultComponent
  ],
  imports: [
    BrowserModule,
HttpClientModule,
BrowserAnimationsModule,
NoopAnimationsModule,
MatSelectModule,
MatDialogModule,
MatFormFieldModule,
MatButtonModule,
MatCardModule,
MatInputModule,
MatListModule,
MatToolbarModule,
MatDividerModule,
FormsModule,
RouterModule.forRoot(appRoutes),
AppRoutingModule
  ],
  providers: [MemRegService],
  bootstrap: [AppComponent]
})
export class AppModule { }

