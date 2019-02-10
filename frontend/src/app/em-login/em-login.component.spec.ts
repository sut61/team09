import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmLoginComponent } from './em-login.component';

describe('EmLoginComponent', () => {
  let component: EmLoginComponent;
  let fixture: ComponentFixture<EmLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
