/**
 * 
 */
package wblut.math;



// TODO: Auto-generated Javadoc
/**
 * The Class WB_SpatialParameter3D.
 *
 * @param <T> the generic type
 * @author Frederik Vanhoutte, W:Blut
 */
public class WB_SpatialParameter3D<T> implements WB_Parameter<T> {

	/** The value. */
	WB_Function3D<T>	value;

	/**
	 * Instantiates a new w b_ spatial parameter3 d.
	 *
	 * @param value the value
	 */
	public WB_SpatialParameter3D(final WB_Function3D<T> value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * @see wblut.math.WB_Parameter#value()
	 */
	public T value() {
		// TODO Auto-generated method stub
		return value.f(0, 0, 0);
	}

	/*
	 * (non-Javadoc)
	 * @see wblut.math.WB_Parameter#value(double)
	 */
	public T value(final double x) {
		// TODO Auto-generated method stub
		return value.f(x, 0, 0);
	}

	/*
	 * (non-Javadoc)
	 * @see wblut.math.WB_Parameter#value(double, double)
	 */
	public T value(final double x, final double y) {
		return value.f(x, y, 0);
	}

	/*
	 * (non-Javadoc)
	 * @see wblut.math.WB_Parameter#value(double, double, double)
	 */
	public T value(final double x, final double y, final double z) {
		return value.f(x, y, z);
	}

	/*
	 * (non-Javadoc)
	 * @see wblut.math.WB_Parameter#value(double, double, double, double)
	 */
	public T value(final double x, final double y, final double z,
			final double t) {
		return value.f(x, y, z);
	}

}