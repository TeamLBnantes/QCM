import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QcmListComponent } from './qcm-list.component';

describe('QcmListComponent', () => {
  let component: QcmListComponent;
  let fixture: ComponentFixture<QcmListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QcmListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QcmListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
