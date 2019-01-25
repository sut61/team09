import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { AgentAppointmentComponent } from './agent-appointment/agent-appointment.component';
import { ShowAppointmentResultComponent } from './show-appointment-result/show-appointment-result.component';
import { DiseaseAccidentDataUIComponent } from './DiseaseAccidentDataUI/DiseaseAccidentDataUI.component';
import { RegCategoryUiComponent } from './RegCategoryUi/RegCategoryUi.component';

const routes: Routes = [
{ path: 'agentAppointment', component: AgentAppointmentComponent },
{ path: 'showAppointmentResult', component: ShowAppointmentResultComponent },
{ path: 'DiseaseAccidentDataUI', component: DiseaseAccidentDataUIComponent },
{ path: 'RegCategoryUi', component: RegCategoryUiComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
