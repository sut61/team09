import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowagentRegisresultComponent } from './showagent-regisresult.component';

describe('ShowagentRegisresultComponent', () => {
  let component: ShowagentRegisresultComponent;
  let fixture: ComponentFixture<ShowagentRegisresultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowagentRegisresultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowagentRegisresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
