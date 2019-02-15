import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { AgentAppointmentComponent } from './agent-appointment/agent-appointment.component';
import { ShowAppointmentResultComponent } from './show-appointment-result/show-appointment-result.component';
import { CancelAppointmentComponent } from './cancel-appointment/cancel-appointment.component';

import { DiseaseAccidentDataUIComponent } from './DiseaseAccidentDataUI/DiseaseAccidentDataUI.component';
import { MemLoginComponent } from './mem-login/mem-login.component';
import { MemHomeComponent } from './mem-home/mem-home.component';
import { RegCategoryUiComponent } from './RegCategoryUi/RegCategoryUi.component';
import { RegCancelInsuranceComponent } from './RegCancelInsurance/RegCancelInsurance.component';
import { LumpsumComponent } from './lumpsum/lumpsum.component';

import { ClaimDataUIComponent } from './ClaimDataUI/ClaimDataUI.component';
import { OfficerLoginComponent } from './OfficerLogin/OfficerLogin.component';
import { OfficerHomeComponent } from './OfficerHome/OfficerHome.component';
import { ShowDiseaseAccidentDataResultComponent } from './ShowDiseaseAccidentDataResult/ShowDiseaseAccidentDataResult.component';
import { ShowClaimDataResultComponent } from './ShowClaimDataResult/ShowClaimDataResult.component';
import { HospitalComponent } from './hospital/hospital.component';

const routes: Routes = [
{ path: 'agentAppointment', component: AgentAppointmentComponent },
{ path: 'showAppointmentResult', component: ShowAppointmentResultComponent },
{ path: 'cancelAppointment', component: CancelAppointmentComponent },
{ path: 'DiseaseAccidentDataUI', component: DiseaseAccidentDataUIComponent },
{ path: 'MemLogin', component: MemLoginComponent },
{ path: 'MemHome', component: MemHomeComponent },
{ path: 'RegCategoryUi', component: RegCategoryUiComponent },
{ path: 'RegCancelInsurance', component: RegCancelInsuranceComponent },
{ path: ' Lumpsum', component: LumpsumComponent },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
