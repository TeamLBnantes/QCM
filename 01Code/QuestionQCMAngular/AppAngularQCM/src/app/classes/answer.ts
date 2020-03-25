export class Answer {
  id: number;
  body: string;
  multimedia: {
      id: number;
      typeMultimedia: string;
      adresseCible: string;
  };
}
