import { TestBed } from '@angular/core/testing';

import { QcmServiceService } from './qcm-service.service';

describe('QcmServiceService', () => {
  let service: QcmServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QcmServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
