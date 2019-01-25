import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegCategoryUiComponent } from './RegCategoryUi.component';
import {RegCategoryUiService} from  '../service/RegCategoryUi.Service';

describe('RegCategoryUiComponent', () => {
  let component: RegCategoryUiComponent;
  let fixture: ComponentFixture<RegCategoryUiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegCategoryUiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegCategoryUiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
