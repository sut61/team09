import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemHomeComponent } from './mem-home.component';

describe('MemHomeComponent', () => {
  let component: MemHomeComponent;
  let fixture: ComponentFixture<MemHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
