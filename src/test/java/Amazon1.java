import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Amazon1 {
     public static void main(String a[]) {
        Amazon1 am1 = new Amazon1();
        List<List<Integer>> intList = new ArrayList<>();
        List<Integer> obj = new ArrayList<>();
        obj.add(1);
        obj.add(2);
        intList.add(obj);
        List<Integer> obj1 = new ArrayList<>();
        obj1.add(3);
        obj1.add(4);
        intList.add(obj1);
        List<Integer> obj2 = new ArrayList<>();
        obj2.add(1);
        obj2.add(-1);
        intList.add(obj2);
         List<DistanceTree> distanceTreeList = new ArrayList<>();
        intList.stream().filter(list -> list.size() == 2).forEach(list -> am1.calculateDistance(list, distanceTreeList));




        Collections.sort(distanceTreeList);
        System.out.println(distanceTreeList);

       List<List<Integer>> result = distanceTreeList.stream().limit(2).map(DistanceTree::getCoordinates).collect(Collectors.toList());
       //List<List<Integer>>  result1 = result.stream().map(DistanceTree::getCoordinates).collect(Collectors.toList());
        System.out.println(result);
    }

    public void calculateDistance(List<Integer> coordinates, List<DistanceTree> distanceTreeList) {
        DistanceTree dt = new DistanceTree();
        dt.setCoordinates(coordinates);
       Integer distance = Math.abs(coordinates.get(0)) + Math.abs(coordinates.get(1));
        dt.setDistance(distance);
        distanceTreeList.add(dt);
    }

    private class DistanceTree implements Comparable<DistanceTree>{

        List<Integer> coordinates;
        Integer distance;

        public List<Integer> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<Integer> coordinates) {
            this.coordinates = coordinates;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }


        @Override
        public int compareTo(DistanceTree o) {
            return this.getDistance().compareTo(o.getDistance());
        }
    }
}
