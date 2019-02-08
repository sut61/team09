import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerRegComponent } from './officer-reg.component';

describe('OfficerRegComponent', () => {
  let component: OfficerRegComponent;
  let fixture: ComponentFixture<OfficerRegComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfficerRegComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfficerRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
