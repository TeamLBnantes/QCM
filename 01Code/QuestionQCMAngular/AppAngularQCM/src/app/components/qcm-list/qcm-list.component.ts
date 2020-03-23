import { Component, OnInit } from '@angular/core';
import { Qcm } from 'src/app/classes/qcm';
import { Subscription } from 'rxjs';
import { QcmServiceService } from 'src/app/service/qcm-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-qcm-list',
  templateUrl: './qcm-list.component.html',
  styleUrls: ['./qcm-list.component.css']
})
export class QcmListComponent implements OnInit {
  qcms$: Qcm[];
  qcmId: number;
  private subscription: Subscription;
  constructor(private qcmService: QcmServiceService) { }

  ngOnInit(): void {
    this.getAllQcm();
  }

  getAllQcm() {
    this.subscription = this.qcmService.getAllQcm().subscribe(
      (data: Qcm[]) => {
        this.qcms$ = data;
      }
    );
  }
ngOnDestroy(): void {
  // eviter les fuites de memoires
  if (this.subscription) {
    this.subscription.unsubscribe();
  }
}

}

