import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvantagesClientsComponent } from './avantages-clients.component';

describe('AvantagesClientsComponent', () => {
  let component: AvantagesClientsComponent;
  let fixture: ComponentFixture<AvantagesClientsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AvantagesClientsComponent]
    });
    fixture = TestBed.createComponent(AvantagesClientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
