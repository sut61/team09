import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCategoryResultComponent } from './show-category-result.component';

describe('ShowCategoryResultComponent', () => {
  let component: ShowCategoryResultComponent;
  let fixture: ComponentFixture<ShowCategoryResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowCategoryResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCategoryResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
