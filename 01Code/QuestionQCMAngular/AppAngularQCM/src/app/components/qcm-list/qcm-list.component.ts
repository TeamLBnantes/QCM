import { Component, OnInit } from '@angular/core';
import { Qcm } from 'src/app/classes/qcm';
import { Subscription } from 'rxjs';
import { QcmServiceService } from 'src/app/service/qcm-service.service';

@Component({
  selector: 'app-qcm-list',
  templateUrl: './qcm-list.component.html',
  styleUrls: ['./qcm-list.component.css']
})
export class QcmListComponent implements OnInit {
  qcms$: Qcm[];
  private subscription: Subscription;
  lancer: boolean;
  tableVisuel: string[]=["table-default", "table-secondary", "table-primary", "table-success","table-info","table-danger","table-warning","table-active","table-light","table-dark",];
  constructor(private qcmService: QcmServiceService) {

   }

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

