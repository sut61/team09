import { TestBed, inject } from '@angular/core/testing';

import { HospitalService } from './Hospital.service';

describe('HospitalService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HospitalService]
    });
  });

  it('should be created', inject([HospitalService], (service: HospitalService) => {
    expect(service).toBeTruthy();
  }));
});
