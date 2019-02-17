import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancellumpsumComponent } from './cancellumpsum.component';

describe('CancellumpsumComponent', () => {
  let component: CancellumpsumComponent;
  let fixture: ComponentFixture<CancellumpsumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancellumpsumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancellumpsumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
