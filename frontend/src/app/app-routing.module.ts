import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { AgentAppointmentComponent } from './agent-appointment/agent-appointment.component';
import { ShowAppointmentResultComponent } from './show-appointment-result/show-appointment-result.component';
import { DiseaseAccidentDataUIComponent } from './DiseaseAccidentDataUI/DiseaseAccidentDataUI.component';
import { MemLoginComponent } from './mem-login/mem-login.component';
import { MemHomeComponent } from './mem-home/mem-home.component';
import { RegCategoryUiComponent } from './RegCategoryUi/RegCategoryUi.component';
<<<<<<< HEAD
import { AgentRegComponent } from './agent-reg/agent-reg.component';

=======
>>>>>>> 5e4909ace3af06350f01a9783af32ca44278a21a
const routes: Routes = [
{ path: 'agentAppointment', component: AgentAppointmentComponent },
{ path: 'showAppointmentResult', component: ShowAppointmentResultComponent },
{ path: 'DiseaseAccidentDataUI', component: DiseaseAccidentDataUIComponent },
{ path: 'MemLogin', component: MemLoginComponent },
{ path: 'MemHome', component: MemHomeComponent },
{ path: 'RegCategoryUi', component: RegCategoryUiComponent },
{ path: 'AgentReg', component: AgentRegComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
