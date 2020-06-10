export class QcmPlayable {
  id: number;
  body: string;
  createDate: Date;
  editDate: Date;
  designerPseudo: string;
  topic: string;
  multimedia: {
    id: number;
    typeMultimedia: string;
    adresseCible: string;
    adresseVignette: string;
    legende: string;
};
  questionsId: number[];
  idMCQpassed: number;
  constructor(obj: object) {
    Object.assign(this, obj);
  }
}
