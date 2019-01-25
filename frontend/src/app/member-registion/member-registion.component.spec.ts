import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberRegistionComponent } from './member-registion.component';

describe('MemberRegistionComponent', () => {
  let component: MemberRegistionComponent;
  let fixture: ComponentFixture<MemberRegistionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberRegistionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberRegistionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
