package cn.com.chengzi.framework.common.query;

import java.util.Date;

import org.springframework.util.StringUtils;

public class SimpleQueryCriteria implements QueryCriteria {
	private Integer intVal1;
	  private Integer intVal2;
	  private Integer intVal3;
	  private Integer intVal4;
	  private Integer intVal5;
	  private Long longVal1;
	  private Long longVal2;
	  private Long longVal3;
	  private Long longVal4;
	  private Long longVal5;
	  private String strVal1;
	  private String strVal2;
	  private String strVal3;
	  private String strVal4;
	  private String strVal5;
	  private String strVal6;
	  private String strVal7;
	  private String strVal8;
	  private Date dateVal1;
	  private Date dateVal2;
	  private Date dateVal3;
	  private Date dateVal4;
	  private Date dateVal5;
	  private Date dateVal6;
	  private Date dateVal7;
	  private Date dateVal8;

	  public SimpleQueryCriteria()
	  {
	  }

	  public SimpleQueryCriteria(Integer intVal1)
	  {
	    this.intVal1 = intVal1;
	  }

	  public SimpleQueryCriteria(String strVal1) {
	    this.strVal1 = strVal1;
	  }

	  public SimpleQueryCriteria(String strVal1, String strVal2) {
	    this.strVal1 = strVal1;
	    this.strVal2 = strVal2;
	  }

	  public Integer getIntVal1() {
	    return this.intVal1;
	  }

	  public void setIntVal1(Integer intVal1) {
	    this.intVal1 = intVal1;
	  }

	  public Integer getIntVal2() {
	    return this.intVal2;
	  }

	  public void setIntVal2(Integer intVal2) {
	    this.intVal2 = intVal2;
	  }

	  public Integer getIntVal3() {
	    return this.intVal3;
	  }

	  public void setIntVal3(Integer intVal3) {
	    this.intVal3 = intVal3;
	  }

	  public Integer getIntVal4() {
	    return this.intVal4;
	  }

	  public void setIntVal4(Integer intVal4) {
	    this.intVal4 = intVal4;
	  }

	  public Integer getIntVal5() {
	    return this.intVal5;
	  }

	  public void setIntVal5(Integer intVal5) {
	    this.intVal5 = intVal5;
	  }

	  public Long getLongVal1() {
	    return this.longVal1;
	  }

	  public void setLongVal1(Long longVal1) {
	    this.longVal1 = longVal1;
	  }

	  public Long getLongVal2() {
	    return this.longVal2;
	  }

	  public void setLongVal2(Long longVal2) {
	    this.longVal2 = longVal2;
	  }

	  public Long getLongVal3() {
	    return this.longVal3;
	  }

	  public void setLongVal3(Long longVal3) {
	    this.longVal3 = longVal3;
	  }

	  public Long getLongVal4() {
	    return this.longVal4;
	  }

	  public void setLongVal4(Long longVal4) {
	    this.longVal4 = longVal4;
	  }

	  public Long getLongVal5() {
	    return this.longVal5;
	  }

	  public void setLongVal5(Long longVal5) {
	    this.longVal5 = longVal5;
	  }

	  public String getStrVal1() {
	    return trim(this.strVal1);
	  }

	  public void setStrVal1(String strVal1) {
	    this.strVal1 = strVal1;
	  }

	  public String getStrVal2() {
	    return trim(this.strVal2);
	  }

	  public void setStrVal2(String strVal2) {
	    this.strVal2 = strVal2;
	  }

	  public String getStrVal3() {
	    return trim(this.strVal3);
	  }

	  public void setStrVal3(String strVal3) {
	    this.strVal3 = strVal3;
	  }

	  public String getStrVal4() {
	    return trim(this.strVal4);
	  }

	  public void setStrVal4(String strVal4) {
	    this.strVal4 = strVal4;
	  }

	  public String getStrVal5() {
	    return trim(this.strVal5);
	  }

	  public void setStrVal5(String strVal5) {
	    this.strVal5 = strVal5;
	  }

	  public String getStrVal6() {
	    return trim(this.strVal6);
	  }

	  public void setStrVal6(String strVal6) {
	    this.strVal6 = strVal6;
	  }

	  public String getStrVal7() {
	    return trim(this.strVal7);
	  }

	  public void setStrVal7(String strVal7) {
	    this.strVal7 = strVal7;
	  }

	  public String getStrVal8() {
	    return trim(this.strVal8);
	  }

	  public void setStrVal8(String strVal8) {
	    this.strVal8 = strVal8;
	  }

	  public Date getDateVal1() {
	    return this.dateVal1;
	  }

	  public void setDateVal1(Date dateVal1) {
	    this.dateVal1 = dateVal1;
	  }

	  public Date getDateVal2() {
	    return this.dateVal2;
	  }

	  public void setDateVal2(Date dateVal2) {
	    this.dateVal2 = dateVal2;
	  }

	  public Date getDateVal3() {
	    return this.dateVal3;
	  }

	  public void setDateVal3(Date dateVal3) {
	    this.dateVal3 = dateVal3;
	  }

	  public Date getDateVal4() {
	    return this.dateVal4;
	  }

	  public void setDateVal4(Date dateVal4) {
	    this.dateVal4 = dateVal4;
	  }

	  public Date getDateVal5() {
	    return this.dateVal5;
	  }

	  public void setDateVal5(Date dateVal5) {
	    this.dateVal5 = dateVal5;
	  }

	  public Date getDateVal6() {
	    return this.dateVal6;
	  }

	  public void setDateVal6(Date dateVal6) {
	    this.dateVal6 = dateVal6;
	  }

	  public Date getDateVal7() {
	    return this.dateVal7;
	  }

	  public void setDateVal7(Date dateVal7) {
	    this.dateVal7 = dateVal7;
	  }

	  public Date getDateVal8() {
	    return this.dateVal8;
	  }

	  public void setDateVal8(Date dateVal8) {
	    this.dateVal8 = dateVal8;
	  }

	  private String trim(String str) {
	    return StringUtils.isEmpty(str) ? str : str.trim();
	  }

	  public String toString()
	  {
	    return "SimpleQueryCriteria [intVal1=" + this.intVal1 + ", intVal2=" + 
	      this.intVal2 + ", intVal3=" + this.intVal3 + ", intVal4=" + this.intVal4 + 
	      ", intVal5=" + this.intVal5 + ", longVal1=" + this.longVal1 + 
	      ", longVal2=" + this.longVal2 + ", longVal3=" + this.longVal3 + 
	      ", longVal4=" + this.longVal4 + ", longVal5=" + this.longVal5 + 
	      ", strVal1=" + this.strVal1 + ", strVal2=" + this.strVal2 + 
	      ", strVal3=" + this.strVal3 + ", strVal4=" + this.strVal4 + 
	      ", strVal5=" + this.strVal5 + ", strVal6=" + this.strVal6 + 
	      ", strVal7=" + this.strVal7 + ", strVal8=" + this.strVal8 + 
	      ", dateVal1=" + this.dateVal1 + ", dateVal2=" + this.dateVal2 + 
	      ", dateVal3=" + this.dateVal3 + ", dateVal4=" + this.dateVal4 + 
	      ", dateVal5=" + this.dateVal5 + ", dateVal6=" + this.dateVal6 + 
	      ", dateVal7=" + this.dateVal7 + ", dateVal8=" + this.dateVal8 + "]";
	  }
}
