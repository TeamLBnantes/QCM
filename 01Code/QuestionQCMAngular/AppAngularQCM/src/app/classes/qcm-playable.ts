export class QcmPlayable {
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
  };
  questionsId: number[];

  constructor(obj: object) {
    Object.assign(this, obj);
  }
}
