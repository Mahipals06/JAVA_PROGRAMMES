//Area of Polygon in cartisian plane
public class Area_Polygon {
	static class Point{
		double x;
		double y;
		Point(double x1,double y1){
			x=x1;
			y=y1;
		}
	}
	static double crossproduct(Point a,Point b) {
		return (a.x*b.y)-(a.y*b.x);
	}
	static double area(Point[] vertices,int n) {
		double sum=0.0;
		for(int i=0;i<n;i++) {
			sum+=crossproduct(vertices[i],vertices[(i+1)%n]);
		}
		return Math.abs(sum/2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p[]=new Point[3];
		p[0]=new Point(3,0);
		p[1]=new Point(0,4);
		p[2]=new Point(0,0);
		System.out.print("Area is :"+area(p,3));
	}

}
