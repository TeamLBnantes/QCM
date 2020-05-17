import { Pipe, PipeTransform } from '@angular/core';
import { Qcm } from 'src/app/classes/qcm';

@Pipe({
  name: 'filtreQCM'
})
export class FiltreQCMPipe implements PipeTransform {

  transform(Qcms: Qcm[], mot?: string):  Qcm[]{
    console.log(mot)
    if (!mot){
      return Qcms;}
/*     return Qcms.filter(item=>((item.topic.toLowerCase().indexOf(mot.toLowerCase())>-1)
                            ||(item.body.toLowerCase().indexOf(mot.toLowerCase())>-1)
                            ||(item.designerPseudo.toLowerCase().indexOf(mot.toLowerCase())>-1))) */
    return Qcms.filter(item=>(((item.topic+"/"+item.body+"/"+item.designerPseudo).toLowerCase().indexOf(mot.toLowerCase())>-1)))
  }

}

