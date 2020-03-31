import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { QcmServiceService } from 'src/app/service/qcm-service.service';
import { QcmPlayable } from 'src/app/classes/qcm-playable';
import { Qcm } from 'src/app/classes/qcm';
import { Subscription } from 'rxjs';
import { Question } from 'src/app/classes/question';
import { Correction} from 'src/app/classes/correction';
import { AnswerCorrectionDto } from 'src/app/classes/answer-correction-dto';

@Component({
  selector: 'app-qcm-play',
  templateUrl: './qcm-play.component.html',
  styleUrls: ['./qcm-play.component.css']
})
export class QcmPlayComponent implements OnInit {
  constructor(private route: ActivatedRoute, private qcmService: QcmServiceService) { }

  private subscription: Subscription;
  private subscription2: Subscription;
  qcm: QcmPlayable;
  idqcm: string;
  lancer = false;
  corriger = false;
  thisIsTheEnd = false;
  bilan=false;
  qIndex: number=0;
  idQuestion: number;
  question: Question;          //dans la question, les rep sont dans anwerPlayableDTO. ordre aléatoire
  reponsesAttendus: Correction;   //il faudra les mettre dans le même ordre que presentée dans la qiestion
  mapRep : Map<number, AnswerCorrectionDto>;   //map entre l'id d'une réponse et son contenu
  varAnswersCorrection: AnswerCorrectionDto[];  // tab des réponses attendu dans même ordre que reponses proposées
  //reponsesQuestionUser: Correction;    //servira à stoker les réponses de l'utilisateur à cette question
  reponsesQCMUser: boolean[]; //stockage de l'ensembles des réponses de l'utilisateur sur le qcm
                                // qui poura etre retourné à QuizIzSkillz (l'id de ces rep sera recup dans l'objet qcm)
  reponsesAnswersUser: boolean[]; //reponse de l'utilisateur à Une question (donc à la liste des reponses)
  trueReponseAnswerUser : boolean[];  //tableau correction des reponses de l'utilisateur pour la question courante
  ngOnInit(): void {
    this.idqcm = this.route.snapshot.paramMap.get('id');
    console.log(this.idqcm);
    this.getQcm();
    this.reponsesQCMUser=[]; //init le tableau des resultat de l'utilisateur sur ce qcm. Eval des question dans l'ordre
  }
  getQcm() {
    this.subscription = this.qcmService.getQcmPlayable (parseInt(this.idqcm)).subscribe(
      (data: QcmPlayable) => {
        this.qcm = data;
      }
    );
  }
  lancerQcm() {
    this.lancer=true;
    this.idQuestion = this.qcm.questionsId[this.qIndex];
    this.subscription = this.qcmService.getQuestion (this.idQuestion).subscribe(
      (data: Question) => {
        this.question = data;
      }
    );
        ////// pour le test
    this.subscription2 = this.qcmService.getCorrection (this.idQuestion).subscribe(
      (data: Correction) => {
        this.reponsesAttendus = data;
      }
    );
    this.reponsesAnswersUser=[];
  }
  lancerQuestionCorriger() {
    this.corriger=true;    //pour afficher les reponses

     this.mapRep = new Map<number, AnswerCorrectionDto>();
     for (let rep of this.reponsesAttendus.answersCorrectionDto) {
       this.mapRep.set(rep.id, rep);
       console.log("############################# ")
       console.log("id : "+rep.id)
       console.log("answer id: "+this.mapRep.get(rep.id).id)
       console.log("answer valeur attendu: "+this.mapRep.get(rep.id).expectedAnswer)
       console.log("comment: "+this.mapRep.get(rep.id).commentPostAnswer)
     }; 
     this.varAnswersCorrection=[];     //tableau des réponses attendus
     for (let rep of this.question.answersPlayableDto){
        this.varAnswersCorrection.push(this.mapRep.get(rep.id))
     };
     //le tableau des reponse de l'utilisateur est initié et maj dans la page html
     this.trueReponseAnswerUser=[];    //tableau comparatif et donc de ercensement des bonnes reponses, init à vide
     
     let i=0;
     this.reponsesQCMUser.push(true);
     for (let rep of this.varAnswersCorrection){
      if (this.reponsesAnswersUser[i]){
              }else{this.reponsesAnswersUser[i]=false}
      this.trueReponseAnswerUser.push(rep.expectedAnswer==this.reponsesAnswersUser[i]);
      this.reponsesQCMUser[this.qIndex]=(this.trueReponseAnswerUser[i] && this.reponsesQCMUser[this.qIndex])
      //console.log(rep.expectedAnswer==this.reponsesAnswersUser[i])
      i++;
     }

    console.log("je suis dans le corrige");
    if (this.qIndex == this.qcm.questionsId.length-1){
      this.thisIsTheEnd = true;
    }
    console.log("thisIsTheAnd vaut : "+this.thisIsTheEnd);

    



  };
  nextQuestion() {
    this.corriger=false;
    this.reponsesAnswersUser=[];
    this.qIndex = (this.qIndex + 1);
    // if (this.qIndex > this.qcm.questionsId.length) {
    //   this.thisIsTheEnd = true;
    // } else {
      this.idQuestion = this.qcm.questionsId[this.qIndex];
      this.subscription = this.qcmService.getQuestion (this.idQuestion).subscribe(
        (data: Question) => {
          this.question = data;
        }
      );
        ////// pour le test
      this.subscription2 = this.qcmService.getCorrection (this.idQuestion).subscribe(
        (data: Correction) => {
          this.reponsesAttendus = data;
        }
      );




    // }
  }

  bilanQCM(){
    this.bilan=true;
  }

ngOnDestroy(): void {
  // eviter les fuites de memoires
  if (this.subscription) {
    this.subscription.unsubscribe();
  }
  if (this.subscription2) {
    this.subscription2.unsubscribe();
  }
}
}
