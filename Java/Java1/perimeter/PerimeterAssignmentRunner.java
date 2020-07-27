import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int result = 0;
        for (Point p: s.getPoints()) {
            result += 1;
        }
        return result;
    }

    public double getLength(Point p1, Point p2) {
        int distanceX = p2.getX() - p1.getX();
        int distanceY = p2.getY() - p1.getY();
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }
    
    public double getAverageLength(Shape s) {
        // Put code here
        double totalDistance = 0;
        int totalPoints = getNumPoints(s);
        Point prevPoint = s.getLastPoint();
        for (Point currentPoint: s.getPoints()) {
            totalDistance += getLength(prevPoint, currentPoint);
            prevPoint = currentPoint;
        }
        return totalDistance /  totalPoints;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0;
        Point prevPoint = s.getLastPoint();
        for (Point currentPoint: s.getPoints()) {
            double currentSide = getLength(prevPoint, currentPoint);
            if (currentSide > largestSide) {
                largestSide = currentSide;
            }
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        for (Point currentPoint: s.getPoints()) {
            double currentX = currentPoint.getX();
            if (currentX > largestX) {
                largestX = currentX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0;
        DirectoryResource shapeFiles = new DirectoryResource();
        for (File f: shapeFiles.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerimeter = getPerimeter(s);
            if (currentPerimeter > largestPerimeter) {
                largestPerimeter = currentPerimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        String largestPerimeterFile = null;
        double largestPerimeter = 0;
        DirectoryResource shapeFiles = new DirectoryResource();
        for (File f: shapeFiles.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerimeter = getPerimeter(s);
            if (currentPerimeter > largestPerimeter) {
                largestPerimeter = currentPerimeter;
                largestPerimeterFile = f.getName();
            }
        }
        return largestPerimeterFile;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numPoints);
        System.out.println("avg length = " + avgLength);
        System.out.println("largest side = " + largestSide);
        System.out.println("largest x = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter: " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        String largestPerimeterFileName = getFileWithLargestPerimeter();
        System.out.println("Largest Perimeter File: " + largestPerimeterFileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
