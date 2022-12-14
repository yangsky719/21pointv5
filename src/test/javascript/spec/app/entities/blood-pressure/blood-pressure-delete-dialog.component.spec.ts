/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { TwentyOnePointsTestModule } from '../../../test.module';
import { BloodPressureDeleteDialogComponent } from 'app/entities/blood-pressure/blood-pressure-delete-dialog.component';
import { BloodPressureService } from 'app/entities/blood-pressure/blood-pressure.service';

describe('Component Tests', () => {
    describe('BloodPressure Management Delete Component', () => {
        let comp: BloodPressureDeleteDialogComponent;
        let fixture: ComponentFixture<BloodPressureDeleteDialogComponent>;
        let service: BloodPressureService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [TwentyOnePointsTestModule],
                declarations: [BloodPressureDeleteDialogComponent]
            })
                .overrideTemplate(BloodPressureDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BloodPressureDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BloodPressureService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it(
                'Should call delete service on confirmDelete',
                inject(
                    [],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });
});
