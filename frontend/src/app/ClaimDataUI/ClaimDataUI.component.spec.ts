import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimDataUIComponent } from './ClaimDataUI.component';

describe('ClaimDataUIComponent', () => {
  let component: ClaimDataUIComponent;
  let fixture: ComponentFixture<ClaimDataUIComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimDataUIComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimDataUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
