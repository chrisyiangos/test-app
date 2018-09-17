import { NgModule } from '@angular/core';

import { MainappSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [MainappSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [MainappSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class MainappSharedCommonModule {}
