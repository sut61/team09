import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerLoginComponent } from './OfficerLogin.component';

describe('OfficerLoginComponent', () => {
  let component: OfficerLoginComponent;
  let fixture: ComponentFixture<OfficerLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfficerLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfficerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
