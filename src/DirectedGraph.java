import java.util.LinkedList;

/**
 * This class represents a directed graph
 * @param <T> the type of data to be stored in the graph
 *           the data must implement the Comparable interface
 *           so that it can be compared to other data
 */

public class DirectedGraph<T> {
    LinkedList<Vertex> vertices;

    /**
     * This class represents a vertex in the graph
     */
    public DirectedGraph(){
        vertices = new LinkedList<>();
    }

    /**
     * This class represents a vertex in the graph
     * @param data the data to be stored in the vertex
     */
    public void addVertex(T data){
        vertices.add(new Vertex(data));
    }

    /**
     * This method will add an edge to the graph
     * @param start the start vertex
     * @param end the end vertex
     * @param weight the weight of the edge
     */
    public void addEdge(T start, T end, String weight){
        Vertex startVertex = null;
        Vertex endVertex = null;
        for(Vertex vertex : vertices){
            if(vertex.data.equals(start)){
                startVertex = vertex;
            }
            if(vertex.data.equals(end)){
                endVertex = vertex;
            }
        }
        if(startVertex == null){
            startVertex = new Vertex<>(start);
            vertices.add(startVertex);
        }
        if(endVertex == null){
            endVertex = new Vertex<>(end);
            vertices.add(endVertex);
        }
        startVertex.edges.add(new Edge<>(startVertex, endVertex, weight));
    }


    /**
     * This method will return the vertex with the given data
     * @param data the data to be searched for
     * @return the vertex with the given data
     */

    public Vertex<T> getVertex(T data){
        for(Vertex<T> vertex : vertices){
            if(vertex.data.equals(data)){
                return vertex;
            }
        }
        return null;
    }

    /**
     * This method will print the graph
     */
    public void printGraph(){
        for(Vertex<T> vertex : vertices){
            System.out.println(vertex.data);
            for(Edge<T> edge : vertex.edges){
                System.out.println(edge.start.data + " -> " + edge.end.data + " : " + edge.weight);
            }
        }
    }


    /**
     * This class represents a vertex in the graph
     * @param <T> the type of data to be stored in the vertex
     */


    public class Vertex<T>{
        LinkedList<Edge<T>> edges;
        T data;
        boolean isValid;

        /**
         * This class represents a vertex in the graph
         * @param data the data to be stored in the vertex
         */
        public Vertex(T data){
            this.data = data;
            edges = new LinkedList<>();
            isValid = false;
        }

        /**
         * This method will return the data stored in the vertex
         * @return
         */
        public boolean isValid(){
            return isValid;
        }
        /**
         * This method will set the data stored in the vertex
         * @return the data stored in the vertex
         */

        public void setValid(boolean isValid){
            this.isValid = isValid;
        }

        /**
         * This method will return the data stored in a linked list of edges
         * @return
         */

        public LinkedList<Edge<T>> getEdgeList(){
            return edges;
        }

    }

    /**
     * This class represents an edge in the graph
     * @param <T>
     */

    public class Edge<T>{
        Vertex<T> start;
        Vertex<T> end;
        String weight;

        public Edge(Vertex<T> start, Vertex<T> end, String weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

    }
}
