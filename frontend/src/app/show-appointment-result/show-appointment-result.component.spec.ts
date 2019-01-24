import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAppointmentResultComponent } from './show-appointment-result.component';

describe('ShowAppointmentResultComponent', () => {
  let component: ShowAppointmentResultComponent;
  let fixture: ComponentFixture<ShowAppointmentResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAppointmentResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAppointmentResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
