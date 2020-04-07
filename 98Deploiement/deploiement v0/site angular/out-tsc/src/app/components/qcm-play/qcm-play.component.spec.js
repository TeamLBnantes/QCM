import { async, TestBed } from '@angular/core/testing';
import { QcmPlayComponent } from './qcm-play.component';
describe('QcmPlayComponent', () => {
    let component;
    let fixture;
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [QcmPlayComponent]
        })
            .compileComponents();
    }));
    beforeEach(() => {
        fixture = TestBed.createComponent(QcmPlayComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=qcm-play.component.spec.js.map