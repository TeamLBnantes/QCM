import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopupmediaComponent } from './popupmedia.component';

describe('PopupmediaComponent', () => {
  let component: PopupmediaComponent;
  let fixture: ComponentFixture<PopupmediaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopupmediaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopupmediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
