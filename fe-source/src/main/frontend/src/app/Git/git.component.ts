import {Component, OnInit} from '@angular/core';
import {GitService} from './git.service';
@Component({
  selector: 'git-repo-list',
  templateUrl: './git.component.html'
})
export class GitComponent implements OnInit {
  commits: any[];
  isDataAvailable = false;

  constructor(private gitService: GitService) {
  };

  ngOnInit() {
    this.getCommits();
  }

  getCommits(): void {
    this.gitService
      .getCommits()
      .subscribe(commits => {
        this.commits = commits, this.isDataAvailable = true, console.log(commits)
      });
  }
}
;
