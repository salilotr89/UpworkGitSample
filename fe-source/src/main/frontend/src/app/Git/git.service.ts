import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Commit } from './commit';
import { NgForm } from '@angular/forms';

@Injectable()
export class GitService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private commitUrl = '/';  // URL to web api
  constructor(private http: Http) { }

  getCommits(): Observable<Commit[]> {
    console.log("debug here");
    return this.http
      .get(this.commitUrl)
      .map(response => response.json() as Commit[])
  }


}
