import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemLoginComponent } from './mem-login.component';

describe('MemLoginComponent', () => {
  let component: MemLoginComponent;
  let fixture: ComponentFixture<MemLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
