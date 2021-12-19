package com.study.springcore.case06;

public class RoundArea implements Area{
	private double radius;
	private double area=0;
	@Override
	public double getRoundArea() {
		area=Math.pow(radius, 2)*Math.PI;
		return area;
	}

	@Override
	public void setRadius(double r) {
		this.radius=r;
		
	}

	@Override
	public double getRadius() {
		
		return radius;
	}

	@Override
	public String toString() {
		return "RoundArea [r=" + radius + ", area=" + area + "]";
	}
	
}
