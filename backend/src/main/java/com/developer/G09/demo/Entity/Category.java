package com.okta.developer.demo.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Category") //ชื่อตาราง
public class Category {
@Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
private Long id;
private String caregoryname;
private String type;
private Long date; //วันที่ทำการเพิ่ม
protected Category() {}
public Category(String caregoryname, Long date){  //constructor
    this.caregoryname = caregoryname;
     this.date = date;
}
}