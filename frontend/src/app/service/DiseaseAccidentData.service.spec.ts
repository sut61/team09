import { TestBed, inject } from '@angular/core/testing';

import { DiseaseAccidentDataService } from './DiseaseAccidentData.service';

describe('DiseaseAccidentDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DiseaseAccidentDataService]
    });
  });

  it('should be created', inject([DiseaseAccidentDataService], (service: diseaseAccidentDataService) => {
    expect(service).toBeTruthy();
  }));
});
