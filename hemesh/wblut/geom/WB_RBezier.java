/**
 * 
 */
package wblut.geom;


// TODO: Auto-generated Javadoc
/**
 * The Class WB_RBezier.
 *
 * @author Frederik Vanhoutte, W:Blut
 */
public class WB_RBezier extends WB_Bezier {

	/** The weights. */
	private final double[]		weights;
	
	/** The wpoints. */
	protected WB_Homogeneous[]	wpoints;

	/**
	 * Instantiates a new w b_ r bezier.
	 *
	 * @param controlPoints the control points
	 */
	public WB_RBezier(final WB_Point3d[] controlPoints) {
		super(controlPoints);
		weights = new double[n + 1];
		wpoints = new WB_Homogeneous[n + 1];
		for (int i = 0; i < n + 1; i++) {
			weights[i] = 1.0;
			wpoints[i] = new WB_Homogeneous(points[i], weights[i]);

		}

	}

	/**
	 * Instantiates a new w b_ r bezier.
	 *
	 * @param controlPoints the control points
	 */
	public WB_RBezier(final WB_Homogeneous[] controlPoints) {
		super(controlPoints);
		weights = new double[n + 1];
		for (int i = 0; i < n + 1; i++) {
			weights[i] = controlPoints[i].w;
		}
		wpoints = new WB_Homogeneous[n + 1];
		for (int i = 0; i < n + 1; i++) {
			wpoints[i] = new WB_Homogeneous(controlPoints[i]);

		}

	}

	/**
	 * Instantiates a new w b_ r bezier.
	 *
	 * @param controlPoints the control points
	 * @param weights the weights
	 */
	public WB_RBezier(final WB_Point3d[] controlPoints, final double[] weights) {
		super(controlPoints);
		this.weights = weights;
		wpoints = new WB_Homogeneous[n + 1];
		for (int i = 0; i < n + 1; i++) {
			wpoints[i] = new WB_Homogeneous(points[i], weights[i]);

		}
	}

	/*
	 * (non-Javadoc)
	 * @see wblut.nurbs.WB_Curve#curvePoint(double)
	 */
	@Override
	public WB_Point3d curvePoint(final double u) {
		final double[] B = allBernstein(u);
		final WB_Homogeneous C = new WB_Homogeneous();
		for (int k = 0; k <= n; k++) {
			C.add(wpoints[k], B[k]);
		}
		return new WB_Point3d(C.project());
	}

	/* (non-Javadoc)
	 * @see wblut.geom.WB_Bezier#elevateDegree()
	 */
	@Override
	public WB_RBezier elevateDegree() {

		final WB_Homogeneous[] npoints = new WB_Homogeneous[n + 2];
		npoints[0] = wpoints[0];
		npoints[n + 1] = wpoints[n];
		final double inp = 1.0 / (n + 1);
		for (int i = 1; i <= n; i++) {
			npoints[i] = WB_Homogeneous.interpolate(wpoints[i], wpoints[i - 1],
					i * inp);

		}
		return new WB_RBezier(npoints);

	}

}
