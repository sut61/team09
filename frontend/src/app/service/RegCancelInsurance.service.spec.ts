import { TestBed, inject } from '@angular/core/testing';

import { RegCancelInsurance } from './RegCancelInsurance.service';

describe('RegCancelInsuranceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegCancelInsuranceService]
    });
  });

  it('should be created', inject([RegCancelInsuranceService], (service: RegCancelInsuranceService) => {
    expect(service).toBeTruthy();
  }));
});
