package com.spring.machine;

import com.spring.module.Divide;
import com.spring.module.Minus;
import com.spring.module.Multi;
import com.spring.module.Summation;

public class Calculator {
	
	private Summation sum = new Summation();
	private Minus minus = new Minus();
	private Multi multi = new Multi();
	private Divide div = new Divide();
	
	public int sum(int a, int b) {
		return sum.sum(a, b);
	}
	
	public int minus(int a, int b) {
		return minus.minus(a, b);
	}
	
	public int multi(int a, int b) {
		return multi.multi(a, b);
	}
	
	public int div(int a, int b) {
		return div.div(a, b);
	}

	public Summation getSum() {
		return sum;
	}

	public void setSum(Summation sum) {
		this.sum = sum;
	}

	public Minus getMinus() {
		return minus;
	}

	public void setMinus(Minus minus) {
		this.minus = minus;
	}

	public Multi getMulti() {
		return multi;
	}

	public void setMulti(Multi multi) {
		this.multi = multi;
	}

	public Divide getDiv() {
		return div;
	}

	public void setDiv(Divide div) {
		this.div = div;
	}
	
	
}
