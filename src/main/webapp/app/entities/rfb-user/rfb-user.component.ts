import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRfbUser } from 'app/shared/model/rfb-user.model';
import { Principal } from 'app/core';
import { RfbUserService } from './rfb-user.service';

@Component({
    selector: 'jhi-rfb-user',
    templateUrl: './rfb-user.component.html'
})
export class RfbUserComponent implements OnInit, OnDestroy {
    rfbUsers: IRfbUser[];
    currentAccount: any;
    eventSubscriber: Subscription;
    currentSearch: string;

    constructor(
        private rfbUserService: RfbUserService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private activatedRoute: ActivatedRoute,
        private principal: Principal
    ) {
        this.currentSearch =
            this.activatedRoute.snapshot && this.activatedRoute.snapshot.params['search']
                ? this.activatedRoute.snapshot.params['search']
                : '';
    }

    loadAll() {
        if (this.currentSearch) {
            this.rfbUserService
                .search({
                    query: this.currentSearch
                })
                .subscribe(
                    (res: HttpResponse<IRfbUser[]>) => (this.rfbUsers = res.body),
                    (res: HttpErrorResponse) => this.onError(res.message)
                );
            return;
        }
        this.rfbUserService.query().subscribe(
            (res: HttpResponse<IRfbUser[]>) => {
                this.rfbUsers = res.body;
                this.currentSearch = '';
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    search(query) {
        if (!query) {
            return this.clear();
        }
        this.currentSearch = query;
        this.loadAll();
    }

    clear() {
        this.currentSearch = '';
        this.loadAll();
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRfbUsers();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRfbUser) {
        return item.id;
    }

    registerChangeInRfbUsers() {
        this.eventSubscriber = this.eventManager.subscribe('rfbUserListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
