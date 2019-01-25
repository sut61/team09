import { TestBed, inject } from '@angular/core/testing';

import { LumpsumserviceService } from './lumpsumservice.service';

describe('LumpsumserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LumpsumserviceService]
    });
  });

  it('should be created', inject([LumpsumserviceService], (service: LumpsumserviceService) => {
    expect(service).toBeTruthy();
  }));
});
