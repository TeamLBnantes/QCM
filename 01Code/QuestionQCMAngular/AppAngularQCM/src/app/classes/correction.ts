import { AnswerCorrectionDto } from './answer-correction-dto';

export class Correction {
id: number;                         //correspond à l'id de la question
commentPostAnswer: string ;
answersCorrectionDto: Array<AnswerCorrectionDto>;
}
