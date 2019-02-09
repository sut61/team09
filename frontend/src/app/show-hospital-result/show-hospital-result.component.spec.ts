import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowHospitalResultComponent } from './show-hospital-result.component';

describe('ShowHospitalResultComponent', () => {
  let component: ShowHospitalResultComponent;
  let fixture: ComponentFixture<ShowHospitalResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowHospitalResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowHospitalResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
