import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentAppointmentComponent } from './agent-appointment.component';

describe('AgentAppointmentComponent', () => {
  let component: AgentAppointmentComponent;
  let fixture: ComponentFixture<AgentAppointmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentAppointmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
