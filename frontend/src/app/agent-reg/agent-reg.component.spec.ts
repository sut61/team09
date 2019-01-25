import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentRegComponent } from './agent-reg.component';

describe('AgentRegComponent', () => {
  let component: AgentRegComponent;
  let fixture: ComponentFixture<AgentRegComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentRegComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
