import { TestBed, inject } from '@angular/core/testing';

import { memHomeService } from './memHome.service';

describe('memHomeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [memHomeService]
    });
  });

  it('should be created', inject([memHomeService], (service: memHomeService) => {
    expect(service).toBeTruthy();
  }));
});
