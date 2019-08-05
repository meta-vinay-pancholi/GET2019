import java.util.ArrayList;
import java.util.List;

public class Screen {
	static ArrayList<Shape> shapesList = new ArrayList<>();

	static void addShape(Shape.ShapeType shapeType, Point point,
			List<Double> parameters) {
		shapesList.add(FactoryShape.createShape(shapeType, point, parameters));
	}

	static boolean deleteShape(Shape.ShapeType shapeType, Point point) {
		for (int index = 0; index < shapesList.size(); index++) {
			if (shapesList.get(index).getShapeType() == shapeType
					&& shapesList.get(index).getOrigin().getXPoint() == point
							.getXPoint()
					&& shapesList.get(index).getOrigin().getYPoint() == point
							.getYPoint()) {
				shapesList.remove(index);
				return false;
			}
		}
		return true;
	}

	static boolean deleteShapesOfSpecificType(Shape.ShapeType shapeType) {
		boolean flag = false;
		for (int index = 0; index < shapesList.size(); index++) {
			if (shapesList.get(index).getShapeType() == shapeType) {
				shapesList.remove(index);
				flag = true;
			}
		}
		if (flag) {
			return true;
		}
		return false;
	}

	static ArrayList<Shape> ascendingInArea() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		System.out.println("Ascending in area :");

		for (int indexI = 0; indexI < sortedShapes.size() - 1; indexI++) {
			for (int indexJ = 0; indexJ < sortedShapes.size() - 1 - indexI; indexJ++) {
				if (sortedShapes.get(indexJ).getArea() > sortedShapes.get(
						indexJ + 1).getArea()) {
					Shape temp = sortedShapes.get(indexJ + 1);
					sortedShapes.set(indexJ + 1, sortedShapes.get(indexJ));
					sortedShapes.set(indexJ, temp);
				}
			}
		}
		for (int i = 0; i < sortedShapes.size(); i++) {
			System.out.println(sortedShapes.get(i).getClass().getSimpleName());
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInPerimeter() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		System.out.println("\n Ascending in perimeter :");

		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getPerimeter() > sortedShapes
						.get(j + 1).getPerimeter()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		for (int i = 0; i < sortedShapes.size(); i++) {
			System.out.println(sortedShapes.get(i).getClass().getSimpleName());
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInTimestamp() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		System.out.println("\n Ascending in timestamp");

		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getTimestamp() > (sortedShapes
						.get(j + 1).getTimestamp())) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		for (int i = 0; i < sortedShapes.size(); i++) {
			System.out.println(sortedShapes.get(i));
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInOriginDistance() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				double originDistanceJ = Math.sqrt(Math.pow(sortedShapes.get(j)
						.getOrigin().getXPoint(), 2)
						+ Math.pow(sortedShapes.get(j).getOrigin().getYPoint(),
								2));
				double originDistanceJ1 = Math.sqrt(Math.pow(
						sortedShapes.get(j + 1).getOrigin().getXPoint(), 2)
						+ Math.pow(sortedShapes.get(j + 1).getOrigin()
								.getYPoint(), 2));
				if (originDistanceJ > originDistanceJ1) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> isPointEnclosed(Point point) {
		ArrayList<Shape> pointEnclosedShapes = new ArrayList<>();
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).isPointEnclosed(point)) {
				pointEnclosedShapes.add(shapesList.get(i));
			}
		}

		System.out.println("\nShapes enclosing points");
		for (int i = 0; i < pointEnclosedShapes.size(); i++) {
			System.out.println(pointEnclosedShapes.get(i));
		}
		return pointEnclosedShapes;
	}
}