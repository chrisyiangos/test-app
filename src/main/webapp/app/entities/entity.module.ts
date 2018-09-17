import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { MainappRfbLocationModule } from './rfb-location/rfb-location.module';
import { MainappRfbEventModule } from './rfb-event/rfb-event.module';
import { MainappRfbEventAttendanceModule } from './rfb-event-attendance/rfb-event-attendance.module';
import { MainappRfbUserModule } from './rfb-user/rfb-user.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        MainappRfbLocationModule,
        MainappRfbEventModule,
        MainappRfbEventAttendanceModule,
        MainappRfbUserModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MainappEntityModule {}
