import { TestBed, inject } from '@angular/core/testing';

import { MemRegService } from './memReg.service';

describe('MemRegService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MemRegService]
    });
  });

  it('should be created', inject([MemRegService], (service: MemRegService) => {
    expect(service).toBeTruthy();
  }));
});
