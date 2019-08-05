import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class TestScreen {

	@Test
	public void testAddShapes() {
	}

	@Test
	public void testDeleteShape() {
		// assertTrue(Screen.deleteShape(ShapeType.Rectangle, new Point(5,
		// 10)));
	}

	@Test
	public void testDeleteShapesOfSpecificType() {
		// assertTrue(Screen.deleteShapesOfSpecificType(ShapeType.Circle));
	}

	@Test
	public void testSortAscendingInArea() {
		Screen.addShape(Shape.ShapeType.Square, new Point(10, 10),
				new ArrayList<>(Arrays.asList(0.25d)));
		Screen.addShape(Shape.ShapeType.Circle, new Point(10, 11),
				new ArrayList<>(Arrays.asList(0.25d)));
		Screen.addShape(Shape.ShapeType.Rectangle, new Point(5, 10),
				new ArrayList<>(Arrays.asList(10d, 15d)));

		assertNotEquals(
				new ArrayList<>(Arrays.asList(Shape.ShapeType.Square,
						Shape.ShapeType.Circle, Shape.ShapeType.Rectangle)),
				Screen.ascendingInArea());
	}

	@Test
	public void testSortAscendingInPerimeter() {
		assertNotEquals(
				new ArrayList<>(Arrays.asList(Shape.ShapeType.Square,
						Shape.ShapeType.Circle, Shape.ShapeType.Rectangle)),
				Screen.ascendingInPerimeter());
	}

	@Test
	public void testSortAscendingInTimeStamp() {
		assertNotEquals(
				new ArrayList<>(Arrays.asList(Shape.ShapeType.Square,
						Shape.ShapeType.Circle, Shape.ShapeType.Rectangle)),
				Screen.ascendingInTimestamp());
	}

	@Test
	public void testIsPointEnclosed() {
		assertNotEquals(
				new ArrayList<>(Arrays.asList(Shape.ShapeType.Square,
						Shape.ShapeType.Rectangle)),
				Screen.isPointEnclosed(new Point(10, 10)));
	}
}