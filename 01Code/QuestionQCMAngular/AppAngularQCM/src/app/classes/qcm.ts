export class Qcm {
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
        };
        nbOfQuestions: number;

        constructor(obj: object) {
          Object.assign(this, obj);
        }

}
