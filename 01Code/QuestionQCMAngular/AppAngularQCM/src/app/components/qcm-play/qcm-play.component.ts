import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { QcmServiceService } from 'src/app/service/qcm-service.service';
import { QcmPlayable } from 'src/app/classes/qcm-playable';
import { Qcm } from 'src/app/classes/qcm';
import { Subscription } from 'rxjs';
import { Question } from 'src/app/classes/question';

@Component({
  selector: 'app-qcm-play',
  templateUrl: './qcm-play.component.html',
  styleUrls: ['./qcm-play.component.css']
})
export class QcmPlayComponent implements OnInit {
  constructor(private route: ActivatedRoute, private qcmService: QcmServiceService) { }

  private subscription: Subscription;
  qcm: QcmPlayable;
  idqcm: string;
  lancer = false;
  thisIsTheEnd = false;
  qIndex: number;
 idQuestion: number;
 question: Question;


  ngOnInit(): void {
    this.idqcm = this.route.snapshot.paramMap.get('id');
    console.log(this.idqcm);
    this.getQcm();
  }
  getQcm() {
    this.subscription = this.qcmService.getQcmPlayable (parseInt(this.idqcm)).subscribe(
      (data: QcmPlayable) => {
        this.qcm = data;
      }
    );
  }
  lancerQcm() {
    console.log(this.lancer);
    this.idQuestion = this.qcm.questionsId[this.qIndex];
    this.subscription = this.qcmService.getQuestion (this.idQuestion).subscribe(
      (data: Question) => {
        this.question = data;
      }
    );
}

nextQuestion() {
  this.qIndex = (this.qIndex + 1);
  if (this.qIndex > this.qcm.questionsId.length) {
    this.thisIsTheEnd = true;
  } else {
    this.idQuestion = this.qcm.questionsId[this.qIndex];
    this.subscription = this.qcmService.getQuestion (this.idQuestion).subscribe(
      (data: Question) => {
          this.question = data;
  }
  );
}
}
ngOnDestroy(): void {
  // eviter les fuites de memoires
  if (this.subscription) {
    this.subscription.unsubscribe();
  }
}
}
