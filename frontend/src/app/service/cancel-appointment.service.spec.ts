import { TestBed } from '@angular/core/testing';

import { CancelAppointmentService } from './cancel-appointment.service';

describe('CancelAppointmentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CancelAppointmentService = TestBed.get(CancelAppointmentService);
    expect(service).toBeTruthy();
  });
});
