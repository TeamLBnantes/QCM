import { Component, OnInit, Inject } from '@angular/core';
import { QcmPlayComponent } from '../qcm-play/qcm-play.component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-popupmedia',
  templateUrl: './popupmedia.component.html',
  styleUrls: ['./popupmedia.component.css']
})
export class PopupmediaComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<QcmPlayComponent>,
    @Inject(MAT_DIALOG_DATA) data, sanitizer: DomSanitizer) {

    this.addresseMedia = data.addresseMedia;
    this.typeMedia = data.typeMedia;
    this.legende = data.legende;
    if (this.typeMedia == 'video'){
    this.addresseMedia = this.urlVideoModifier(this.addresseMedia);
    }
    this.safeAddresseMedia = sanitizer.bypassSecurityTrustResourceUrl(this.addresseMedia);
   }
   addresseMedia: string;
   legende: string;
   typeMedia: string;
   addresseModified: string;
   safeAddresseMedia: any;

  ngOnInit(): void {
  }

  urlVideoModifier(addresse) {
    if (addresse.includes("youtube")) {
      this.addresseModified = addresse.replace("watch?v=", "embed/");
    } else if (addresse.includes("youtu.be")){
      this.addresseModified = addresse.replace("youtu.be/", "www.youtube.com/embed/");
    } else if (addresse.includes("vimeo")){
      this.addresseModified = addresse.replace("vimeo", "player.vimeo");
    } else if (addresse.includes("dailymotion")){
      this.addresseModified = addresse.replace("/video", "embed/video");
    } else if (addresse.includes("drive.google")){
      this.addresseModified = addresse.replace("view?usp=sharing", "preview");

    } else {
      this.addresseModified = addresse;
    }
    return this.addresseModified;

  }

}
