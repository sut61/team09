import { TestBed, inject } from '@angular/core/testing';

import { ClaimDataService } from './ClaimData.service';

describe('ClaimDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClaimDataService]
    });
  });

  it('should be created', inject([ClaimDataService], (service: claimDataService) => {
    expect(service).toBeTruthy();
  }));
});
