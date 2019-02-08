import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowDiseaseAccidentDataResultComponent } from './ShowDiseaseAccidentDataResult.component';

describe('ShowDiseaseAccidentDataResultComponent', () => {
  let component: ShowDiseaseAccidentDataResultComponent;
  let fixture: ComponentFixture<ShowDiseaseAccidentDataResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowDiseaseAccidentDataResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowDiseaseAccidentDataResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
