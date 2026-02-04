import java.util.ArrayList;

public class GraphKontrol {
        ArrayList<Edge> listOfEdgesWithReel ;
        ArrayList<Double> edgeLengths ;

        public GraphKontrol() {
            listOfEdgesWithReel = new ArrayList<>() ;
            edgeLengths = new ArrayList<>() ;
            for (Edge edge : listOfEdgesWithReel ) {
                edgeLengths.add(edge.length ) ;
            }
        }


}
