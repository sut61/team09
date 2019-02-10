import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemShowComponent } from './mem-show.component';

describe('MemShowComponent', () => {
  let component: MemShowComponent;
  let fixture: ComponentFixture<MemShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
