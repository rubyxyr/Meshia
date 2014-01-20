/**
 * Based on Karsten Schmidt's and Frederik Vanhoutte's Obj export code /*
 * Copyright Martin Prout (2012) This library is free software; you can
 * redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * http://creativecommons.org/licenses/LGPL/2.1/ This library is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301, USA
 */
package wblut.hemesh;

/**
 * Bare bones PovRAY 3D format exporter. Purely handles the writing of data to
 * the .inc file, as a mesh2 object. See {@link HET_Export} for details.
 * 
 * @see HET_Export#saveAsPOV(HE_Mesh, HET_POVWriter, boolean)
 */
import java.io.PrintWriter;

import wblut.geom.WB_Point3d;



// TODO: Auto-generated Javadoc
/**
 * The Class HET_POVWriter.
 *
 * @author Martin Prout
 */
public class HET_POVWriter {

	/** The comma. */
	final String			COMMA				= ", ";
	
	/** The pov writer. */
	protected PrintWriter	povWriter;
	
	/** The num vertices written. */
	protected int			numVerticesWritten	= 0;
	
	/** The num normals written. */
	protected int			numNormalsWritten	= 0;

	/**
	 * Handles PrintWriter input.
	 *
	 * @param pw the pw
	 */
	public void beginSave(final PrintWriter pw) {
		povWriter = pw;
		handleBeginSave();
	}

	/**
	 * End of mesh2 declaration.
	 */
	public void endSave() {
		povWriter.println("}");
		povWriter.flush();
	}

	/**
	 * Begin the mesh2 output as a PovRAY declaration.
	 *
	 * @param name the name
	 */
	public void beginMesh2(final String name) {
		final StringBuilder pov = new StringBuilder("#declare ");
		pov.append(name);
		pov.append(" = mesh2{\n");
		pov.append("\tvertex_vectors {");
		povWriter.println(pov);
	}

	/**
	 * End the current section ie vertex_vector, normal_vector or face_indices.
	 */
	public void endSection() {
		povWriter.println("\t}");
	}

	/**
	 * Output start of normal_vectors.
	 *
	 * @param count the count
	 */
	public void beginNormals(final int count) {
		povWriter.println("\tnormal_vectors{");
		total(count);
	}

	/**
	 * Output start of face_indices.
	 *
	 * @param count the count
	 */
	public void beginIndices(final int count) {
		povWriter.println("\tface_indices{");
		total(count);
	}

	/**
	 * Used to output total count vertex_vector, normal_vector & face_indices.
	 *
	 * @param count the count
	 */
	public void total(final int count) {
		povWriter.println(String.format("\t%d,", count));
	}

	/**
	 * Face vertex indices.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 */
	public void face(final int a, final int b, final int c) {
		povWriter.println(buildVector(a, b, c));
	}

	/**
	 * Gets the curr normal offset.
	 *
	 * @return the curr normal offset
	 */
	public int getCurrNormalOffset() {
		return numNormalsWritten;
	}

	/**
	 * Gets the curr vertex offset.
	 *
	 * @return the curr vertex offset
	 */
	public int getCurrVertexOffset() {
		return numVerticesWritten;
	}

	/**
	 * Handle begin save.
	 */
	protected void handleBeginSave() {
		povWriter.println("// generated by HE_POVExport");
		numVerticesWritten = 0;
		numNormalsWritten = 0;
	}

	/**
	 * New object.
	 *
	 * @param name the name
	 */
	public void newObject(final String name) {
		povWriter.println(name);
	}

	/**
	 * Triangle normals.
	 *
	 * @param n the n
	 */
	public void normal(final WB_Point3d n) {
		povWriter.println(buildVector(n));
		numNormalsWritten++;
	}

	/**
	 * Triangle vertices.
	 *
	 * @param v the v
	 */
	public void vertex(final WB_Point3d v) {
		povWriter.println(buildVector(v));
		numVerticesWritten++;
	}

	/**
	 * Builds the vector.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @return the string builder
	 */
	private StringBuilder buildVector(final int a, final int b, final int c) {
		final StringBuilder my_vector = new StringBuilder(120);
		my_vector.append('\t').append('<');
		my_vector.append(a).append(COMMA);
		my_vector.append(b).append(COMMA);
		my_vector.append(c).append('>');
		return my_vector.append(COMMA);
	}

	/**
	 * Builds the vector.
	 *
	 * @param n the n
	 * @return the string builder
	 */
	private StringBuilder buildVector(final WB_Point3d n) {
		final StringBuilder my_vector = new StringBuilder(120);
		my_vector.append('\t').append('<');
		my_vector.append(n.x).append(COMMA);
		my_vector.append(n.y * -1).append(COMMA);
		my_vector.append(n.z * -1).append('>');
		return my_vector.append(COMMA);
	}

}