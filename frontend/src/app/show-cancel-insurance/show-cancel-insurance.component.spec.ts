import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCancelInsuranceComponent } from './show-cancel-insurance.component';

describe('ShowCancelInsuranceComponent', () => {
  let component: ShowCancelInsuranceComponent;
  let fixture: ComponentFixture<ShowCancelInsuranceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowCancelInsuranceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCancelInsuranceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
