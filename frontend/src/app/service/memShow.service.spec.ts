import { TestBed, inject } from '@angular/core/testing';

import { MemRegService } from './memReg.service';

describe('memShowService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [memShowService]
    });
  });

  it('should be created', inject([memShowService], (service: memShowService) => {
    expect(service).toBeTruthy();
  }));
});
