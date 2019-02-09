import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowLumpsumResultComponent } from './show-lumpsum-result.component';

describe('ShowLumpsumResultComponent', () => {
  let component: ShowLumpsumResultComponent;
  let fixture: ComponentFixture<ShowLumpsumResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowLumpsumResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowLumpsumResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
