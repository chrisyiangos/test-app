import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MainappSharedModule } from 'app/shared';
import {
    RfbLocationComponent,
    RfbLocationDetailComponent,
    RfbLocationUpdateComponent,
    RfbLocationDeletePopupComponent,
    RfbLocationDeleteDialogComponent,
    rfbLocationRoute,
    rfbLocationPopupRoute
} from './';

const ENTITY_STATES = [...rfbLocationRoute, ...rfbLocationPopupRoute];

@NgModule({
    imports: [MainappSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        RfbLocationComponent,
        RfbLocationDetailComponent,
        RfbLocationUpdateComponent,
        RfbLocationDeleteDialogComponent,
        RfbLocationDeletePopupComponent
    ],
    entryComponents: [RfbLocationComponent, RfbLocationUpdateComponent, RfbLocationDeleteDialogComponent, RfbLocationDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MainappRfbLocationModule {}
