import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowClaimDataResultComponent } from './ShowClaimDataResult.component';

describe('ShowClaimDataResultComponent', () => {
  let component: ShowClaimDataResultComponent;
  let fixture: ComponentFixture<ShowClaimDataResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowClaimDataResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowClaimDataResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
