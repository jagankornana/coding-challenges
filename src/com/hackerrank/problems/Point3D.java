package com.hackerrank.problems;

public class Point3D extends Point2D {

	private int z;

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public double dist3D(Point3D p) {

		double var1 = Math.pow(p.getX() - this.getX(), 2);
		double var2 = Math.pow(p.getY() - this.getY(), 2);
		double var3 = Math.pow(p.getZ() - this.getZ(), 2);
		double distance_3d = Math.sqrt(var1 + var2 + var3);
		return distance_3d;
	}

	public void printDistance(double d) {
		System.out.println("3D distance = " + (long) Math.ceil(d));
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

}
