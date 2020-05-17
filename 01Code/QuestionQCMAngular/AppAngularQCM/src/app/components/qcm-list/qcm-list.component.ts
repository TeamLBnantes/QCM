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
  message = '';
  qcms$: Qcm[];
  charged: boolean;
  private subscription: Subscription;
  tableVisuel: string[]=["table-default", "table-secondary", "table-primary", "table-success","table-info","table-danger","table-warning","table-active","table-light","table-dark",];
  constructor(private qcmService: QcmServiceService) {
   }

   refreshList(mot: string){
     this.qcms$=this.qcms$.slice();
     console.log("coucou " + mot)
     this.message=mot
   }
   initFiltre(){
    this.message=""
    this.qcms$=this.qcms$.slice();
   }

  ngOnInit(): void {
    this.getAllQcm();
  }

  getAllQcm() {
    this.subscription = this.qcmService.getAllQcm().subscribe(
      (data: Qcm[]) => {
        this.qcms$ = data;
        this.charged = true;

      }

    );
};


ngOnDestroy(): void {
  // eviter les fuites de memoires
  if (this.subscription) {
    this.subscription.unsubscribe();
  }
}

}

