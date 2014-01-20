/*
 * Copyright (c) 2010, Frederik Vanhoutte This library is free software; you can
 * redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * http://creativecommons.org/licenses/LGPL/2.1/ This library is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */
package wblut.geom;


import wblut.WB_Epsilon;

// TODO: Auto-generated Javadoc
/**
 * 3D Vector.
 *
 * @author Frederik Vanhoutte (W:Blut) 2010
 */
public class WB_Vector3d extends WB_Point3d {
	
	/**
	 * Zero.
	 *
	 * @return the w b_ vector3d
	 */
	public static WB_Vector3d ZERO() {
		return new WB_Vector3d(0, 0, 0);
	}

	/**
	 * X.
	 *
	 * @return the w b_ vector3d
	 */
	public static WB_Vector3d X() {
		return new WB_Vector3d(1, 0, 0);
	}

	/**
	 * Y.
	 *
	 * @return the w b_ vector3d
	 */
	public static WB_Vector3d Y() {
		return new WB_Vector3d(0, 1, 0);
	}

	/**
	 * Z.
	 *
	 * @return the w b_ vector3d
	 */
	public static WB_Vector3d Z() {
		return new WB_Vector3d(0, 0, 1);
	}

	/**
	 * Instantiates a new WB_Vector.
	 */
	public WB_Vector3d() {
		super();
	}

	/**
	 * Instantiates a new WB_Vector.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public WB_Vector3d(final double x, final double y, final double z) {
		super(x, y, z);
	}

	/**
	 * Instantiates a new WB_Vector.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public WB_Vector3d(final double x, final double y) {
		super(x, y);
	}

	/**
	 * Instantiates a new WB_Vector.
	 *
	 * @param v point, vector or normal
	 */
	public WB_Vector3d(final WB_Point3d v) {
		super(v);
	}

	/**
	 * Get copy.
	 *
	 * @return copy
	 */
	@Override
	public WB_Vector3d get() {
		return new WB_Vector3d(x, y, z);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#add(double, double, double)
	 */
	@Override
	public WB_Vector3d add(final double x, final double y, final double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#add(wblut.geom.WB_Point3d)
	 */
	@Override
	public WB_Vector3d add(final WB_Point3d p) {
		x += p.x;
		y += p.y;
		z += p.z;
		return this;
	}

	/**
	 * Adds the into.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param result the result
	 */
	public void addInto(final double x, final double y, final double z,
			final WB_Vector3d result) {
		result.x = (this.x + x);
		result.y = (this.y + y);
		result.z = (this.z + z);
	}

	/**
	 * Adds the into.
	 *
	 * @param p the p
	 * @param result the result
	 */
	public void addInto(final WB_Point3d p, final WB_Vector3d result) {
		result.x = x + p.x;
		result.y = y + p.y;
		result.z = z + p.z;
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#addAndCopy(double, double, double)
	 */
	@Override
	public WB_Vector3d addAndCopy(final double x, final double y, final double z) {
		return new WB_Vector3d(this.x + x, this.y + y, this.z + z);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#addAndCopy(wblut.geom.WB_Point3d)
	 */
	@Override
	public WB_Vector3d addAndCopy(final WB_Point3d p) {
		return new WB_Vector3d(x + p.x, y + p.y, z + p.z);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#sub(double, double, double)
	 */
	@Override
	public WB_Vector3d sub(final double x, final double y, final double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#sub(wblut.geom.WB_Point3d)
	 */
	@Override
	public WB_Vector3d sub(final WB_Point3d v) {
		x -= v.x;
		y -= v.y;
		z -= v.z;
		return this;
	}

	/**
	 * Sub into.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param result the result
	 */
	public void subInto(final double x, final double y, final double z,
			final WB_Vector3d result) {
		result.x = (this.x - x);
		result.y = (this.y - y);
		result.z = (this.z - z);
	}

	/**
	 * Sub into.
	 *
	 * @param p the p
	 * @param result the result
	 */
	public void subInto(final WB_Point3d p, final WB_Vector3d result) {
		result.x = x - p.x;
		result.y = y - p.y;
		result.z = z - p.z;
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#subAndCopy(double, double, double)
	 */
	@Override
	public WB_Vector3d subAndCopy(final double x, final double y, final double z) {
		return new WB_Vector3d(this.x - x, this.y - y, this.z - z);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#subAndCopy(wblut.geom.WB_Point3d)
	 */
	@Override
	public WB_Vector3d subAndCopy(final WB_Point3d p) {
		return new WB_Vector3d(x - p.x, y - p.y, z - p.z);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#mult(double)
	 */
	@Override
	public WB_Vector3d mult(final double f) {
		x *= f;
		y *= f;
		z *= f;
		return this;
	}

	/**
	 * Mult into.
	 *
	 * @param f the f
	 * @param result the result
	 */
	public void multInto(final double f, final WB_Vector3d result) {
		result.x = (x * f);
		result.y = (y * f);
		result.z = (z * f);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#multAndCopy(double)
	 */
	@Override
	public WB_Vector3d multAndCopy(final double f) {
		return new WB_Vector3d(x * f, y * f, z * f);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#div(double)
	 */
	@Override
	public WB_Vector3d div(final double f) {
		return mult(1.0 / f);
	}

	/**
	 * Div into.
	 *
	 * @param f the f
	 * @param result the result
	 */
	public void divInto(final double f, final WB_Vector3d result) {
		multInto(1.0 / f, result);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#divAndCopy(double)
	 */
	@Override
	public WB_Vector3d divAndCopy(final double f) {
		return multAndCopy(1.0 / f);
	}

	/*
	 * (non-Javadoc)
	 * @see wblut.hemesh.geom.WB_XYZ#cross(wblut.hemesh.geom.WB_XYZ)
	 */
	@Override
	public WB_Vector3d cross(final WB_Point3d p) {
		return new WB_Vector3d(y * p.z - z * p.y, z * p.x - x * p.z, x * p.y
				- y * p.x);
	}

	/**
	 * Cross product.
	 *
	 * @param p the p
	 * @param q the q
	 * @return new WB_Vector
	 */
	public static WB_Vector3d cross(final WB_Point3d p, final WB_Point3d q) {
		return new WB_Vector3d(p.y * q.z - p.z * q.y, p.z * q.x - p.x * q.z,
				p.x * q.y - p.y * q.x);
	}

	/**
	 * Cross product.
	 *
	 * @param p the p
	 * @param result WB_Vector to store result
	 */
	public void crossInto(final WB_Point3d p, final WB_Vector3d result) {
		result.x = y * p.z - z * p.y;
		result.y = z * p.x - x * p.z;
		result.z = x * p.y - y * p.x;
	}

	/**
	 * Normalize vector.
	 *
	 * @param result WB_Vector to store result
	 */
	public void normalizeInto(final WB_Vector3d result) {
		final double d = mag();
		if (WB_Epsilon.isZero(d)) {
			result.set(0, 0, 0);
		} else {
			result.set(x, y, z);
			result.div(d);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	/**
	 * Rotate vertex around an arbitrary axis.
	 *
	 * @param angle angle
	 * @param p1x x-coordinate of first point on axis
	 * @param p1y y-coordinate of first point on axis
	 * @param p1z z-coordinate of first point on axis
	 * @param p2x x-coordinate of second point on axis
	 * @param p2y y-coordinate of second point on axis
	 * @param p2z z-coordinate of second point on axis
	 */
	@Override
	public void rotateAboutAxis(final double angle, final double p1x,
			final double p1y, final double p1z, final double p2x,
			final double p2y, final double p2z) {

		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutAxis(angle, new WB_Point3d(p1x, p1y, p1z),
				new WB_Vector3d(p2x - p1x, p2y - p1y, p2z - p1z));
		raa.applySelf(this);
	}

	/**
	 * Rotate vertex around an arbitrary axis.
	 *
	 * @param angle angle
	 * @param p1 first point on axis
	 * @param p2 second point on axis
	 */
	@Override
	public void rotateAboutAxis(final double angle, final WB_Point3d p1,
			final WB_Point3d p2) {

		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutAxis(angle, p1, p2.subToVector(p1));

		raa.applySelf(this);

	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#rotateAboutAxis(double, wblut.geom.WB_Point3d, wblut.geom.WB_Vector3d)
	 */
	@Override
	public void rotateAboutAxis(final double angle, final WB_Point3d p,
			final WB_Vector3d v) {

		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutAxis(angle, p, v);

		raa.applySelf(this);

	}

	/**
	 * Rotate about axis.
	 *
	 * @param angle the angle
	 * @param p the p
	 * @param n the n
	 */
	public void rotateAboutAxis(final double angle, final WB_Point3d p,
			final WB_Normal3d n) {

		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutAxis(angle, p, n);

		raa.applySelf(this);

	}
	
	/**
	 * Rotate about origin.
	 *
	 * @param angle the angle
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public void rotateAboutOrigin(final double angle, final double x,
			final double y, final double z) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutOrigin(angle, new WB_Vector3d(x, y, z));
		raa.applySelfAsVector(this);
	}

	/**
	 * Rotate about origin.
	 *
	 * @param angle the angle
	 * @param a the a
	 */
	public void rotateAboutOrigin(final double angle, final WB_Vector3d a) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutOrigin(angle, a);
		raa.applySelfAsVector(this);
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Point3d#toNormal()
	 */
	@Override
	public WB_Normal3d toNormal() {
		return new WB_Normal3d(x, y, z);
	}

	/**
	 * To point.
	 *
	 * @return the w b_ point3d
	 */
	public WB_Point3d toPoint() {
		return new WB_Point3d(x, y, z);
	}

}
