import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Qcm } from 'src/app/classes/qcm';
import { QcmServiceService } from 'src/app/service/qcm-service.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-qcm-play',
  templateUrl: './qcm-play.component.html',
  styleUrls: ['./qcm-play.component.css']
})
export class QcmPlayComponent implements OnInit {
  constructor(private qcmService: QcmServiceService
    //, private route: ActivatedRoute
    ) { }
  //qcmId = this.route.snapshot.params.qcmId;
  qcm: Qcm;
  private subscription: Subscription;
  ngOnInit(): void {

  }
/*
  getQcmPlayable() {
    this.subscription = this.qcmService.getPlayableQcm(this.qcmId).subscribe(
      (data: Qcm) => {
        this.qcm = data;
      }
    );
  }
  */
}
