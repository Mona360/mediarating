import { Injectable } from '@angular/core';
import {
  CanActivate, Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  CanActivateChild,
  CanLoad, Route
} from '@angular/router';
import { Store } from '@ngrx/store';

import { OIDCState, selectAccessToken, rememberRouteBeforeLogin, defineUser } from 'src/app/oidc/store';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate, CanActivateChild, CanLoad {
  // user must login in production but not on develop
  isLoggedIn : boolean = environment.production ? false : true;
  constructor(
    private router: Router,
    private readonly oidcStore: Store<OIDCState>,
  ) {
    if (!environment.production) {
        this.oidcStore.dispatch(defineUser({ user : environment.fakeUserID }));
    }
    this.oidcStore.select(selectAccessToken).subscribe((accessToken) => {
      this.isLoggedIn = true; // accessToken !== undefined;
    });
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (!this.isLoggedIn) {
      this.oidcStore.dispatch(rememberRouteBeforeLogin({url : state.url.trim()}))
      this.router.navigate(['/login']);
    }
    return this.isLoggedIn;
  }

  canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    return this.isLoggedIn;
  }

  canLoad(route: Route): boolean {
    return this.isLoggedIn;
  }
}
