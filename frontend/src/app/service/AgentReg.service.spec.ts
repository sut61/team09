import { TestBed, inject } from '@angular/core/testing';

import { AgentRegService } from './AgentReg.service';

describe('AgentRegService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AgentRegService]
    });
  });

  it('should be created', inject([AgentRegService], (service: AgentRegService) => {
    expect(service).toBeTruthy();
  }));
});
