import { TestBed, inject } from '@angular/core/testing';

import { RegCategoryUi } from './RegCategoryUi.service';

describe('RegCategoryUiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegCategoryUiService]
    });
  });

  it('should be created', inject([RegCategoryUiService], (service: RegCategoryUiService) => {
    expect(service).toBeTruthy();
  }));
});
