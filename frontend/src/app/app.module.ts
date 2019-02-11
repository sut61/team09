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
import { CancelAppointmentService } from './service/cancel-appointment.service';
import { CancelAppointmentComponent } from './cancel-appointment/cancel-appointment.component';

import { ShowAppointmentResultComponent } from './show-appointment-result/show-appointment-result.component';
import { DiseaseAccidentDataUIComponent } from './DiseaseAccidentDataUI/DiseaseAccidentDataUI.component';
import { MemLoginComponent } from './mem-login/mem-login.component';
import { MemHomeComponent } from './mem-home/mem-home.component';
import { LoginService} from './service/login.service';
import { SessionService} from './service/session.service';
import { RegCategoryUiComponent } from './RegCategoryUi/RegCategoryUi.component';
import { RegCancelInsuranceComponent } from './RegCancelInsurance/RegCancelInsurance.component';
import { LumpsumComponent } from './lumpsum/lumpsum.component';
import { MemberRegistionComponent } from './member-registion/member-registion.component';
import { AgentRegComponent } from './agent-reg/agent-reg.component';
import { MemRegService } from './service/memReg.service';

import { ClaimDataUIComponent } from './ClaimDataUI/ClaimDataUI.component';
import { OfficerLoginComponent } from './OfficerLogin/OfficerLogin.component';
import { OfficerHomeComponent } from './OfficerHome/OfficerHome.component';
import { ShowDiseaseAccidentDataResultComponent } from './ShowDiseaseAccidentDataResult/ShowDiseaseAccidentDataResult.component';
import { ShowClaimDataResultComponent } from './ShowClaimDataResult/ShowClaimDataResult.component';
import { OfficerRegComponent } from './officer-reg/officer-reg.component';
import { ShowagentRegisresultComponent } from './showagent-regisresult/showagent-regisresult.component';
import { HospitalComponent } from './hospital/hospital.component';
import { HospitalService } from './service/Hospital.service';
import { ShowHospitalResultComponent } from './show-hospital-result/show-hospital-result.component';
import { ShowLumpsumResultComponent } from './show-lumpsum-result/show-lumpsum-result.component';
import { EmLoginComponent } from './em-login/em-login.component';
import { MemShowComponent } from './mem-show/mem-show.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';


const appRoutes: Routes = [
 {path: 'MemHome', component: MemHomeComponent},
 {path: 'AgentReg', component: AgentRegComponent},
{path: 'Lumpsum', component: LumpsumComponent},
{path: 'ClaimDataUI', component: ClaimDataUIComponent},
{path: 'OfficerLogin', component: OfficerLoginComponent},
{path: 'MemShowComponent', component: MemShowComponent},
{path: 'OfficerHome', component: OfficerHomeComponent},
{path: 'EmLoginComponent', component: EmLoginComponent},
{path: 'ShowDiseaseAccidentDataResult', component: ShowDiseaseAccidentDataResultComponent},
{path: 'ShowClaimDataResult', component: ShowClaimDataResultComponent},
{path: 'MemberRegistionComponent', component: MemberRegistionComponent},
{path: 'OfficerReg', component: OfficerRegComponent},
{path: 'ShowagentRegisresultComponent', component: ShowagentRegisresultComponent},
{path: 'Hospital', component: HospitalComponent},
{path: 'ShowHospitalResultComponent', component: ShowHospitalResultComponent},
{path: 'ShowLumpsumResultComponent', component: ShowLumpsumResultComponent},
{path: 'cancelAppointment', component: CancelAppointmentComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    AgentAppointmentComponent,
    CancelAppointmentComponent,
    ShowAppointmentResultComponent,
	DiseaseAccidentDataUIComponent,
	MemLoginComponent,
	MemHomeComponent,
   RegCategoryUiComponent,
RegCancelInsuranceComponent,
	DiseaseAccidentDataUIComponent,
	LumpsumComponent,
	AgentRegComponent,
	MemberRegistionComponent,
	ClaimDataUIComponent,
	OfficerLoginComponent,
	OfficerHomeComponent,
	ShowDiseaseAccidentDataResultComponent,
	ShowClaimDataResultComponent,
	OfficerRegComponent,
	ShowagentRegisresultComponent,
	HospitalComponent,
	ShowHospitalResultComponent,
  ShowLumpsumResultComponent,
  EmLoginComponent,
  MemShowComponent
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
MatSnackBarModule,
RouterModule.forRoot(appRoutes),
AppRoutingModule
  ],
  providers: [MemRegService],
  bootstrap: [AppComponent]
})
export class AppModule { }

