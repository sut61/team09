import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegCancelInsuranceComponent } from './RegCancelInsurance.component';

describe('RegCancelInsuranceComponent', () => {
  let component: RegCancelInsuranceComponent;
  let fixture: ComponentFixture<RegCancelInsuranceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegCancelInsuranceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegCancelInsuranceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
