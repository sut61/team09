import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerHomeComponent } from './OfficerHome.component';

describe('OfficerHomeComponent', () => {
  let component: OfficerHomeComponent;
  let fixture: ComponentFixture<OfficerHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfficerHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfficerHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
