import { Answer } from './answer';

export class Question {
  id: number;
  body: string;
  topic: string;
  createDate: Date;
  editDate: Date;
  designerPseudo: string;
  multimedia: {
      id: number;
      typeMultimedia: string;
      adresseCible: string;
      adresseVignette: string;
      legende: string;
  };
  answersPlayableDto: Answer[];    // liste des réponses, ordonnees aléatoirement pour ce passage
}
