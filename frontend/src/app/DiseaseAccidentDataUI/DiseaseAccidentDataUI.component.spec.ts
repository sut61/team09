import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiseaseAccidentDataUIComponent } from './DiseaseAccidentDataUI.component';

describe('DiseaseAccidentDataUIComponent', () => {
  let component: DiseaseAccidentDataUIComponent;
  let fixture: ComponentFixture<DiseaseAccidentDataUIComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiseaseAccidentDataUIComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiseaseAccidentDataUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
