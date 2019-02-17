import { TestBed, inject } from '@angular/core/testing';

import { CancellumpsumService } from './Cancellumpsum.service';

describe('CancellumpsumService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CancellumpsumService]
    });
  });

  it('should be created', inject([CancellumpsumService], (service: CancellumpsumService) => {
    expect(service).toBeTruthy();
  }));
});
