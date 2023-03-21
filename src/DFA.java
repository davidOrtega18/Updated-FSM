import java.util.LinkedList;

public class DFA{
    DirectedGraph<String> graph = new DirectedGraph<>();
    public DFA(){
        graph.addEdge("q0", "q1", "I");
        graph.addEdge("q0", "q2", "F");
        graph.addEdge("q2", "q1", "M");
        graph.addEdge("q1", "q0", "M");

        graph.getVertex("q2").isValid = true;

        graph.printGraph();

    }

    /**
     * This method will check if the input is valid
     * @param input the input to be checked
     * @return true if the input is valid, false otherwise
     */
    public boolean isVisited(String input){
        DirectedGraph<String>.Vertex<String> current = graph.getVertex("q0");
        LinkedList<DirectedGraph<String>.Edge<String>> edgeLinkedList;

        char[] chars = input.toCharArray();
        for (char i : chars){
            edgeLinkedList = current.getEdgeList();
            System.out.println(current.data);
            for(DirectedGraph<String>.Edge<String> edge : edgeLinkedList){
                System.out.println(edge.weight + " " + (i));
                if(edge.weight.equals(Character.toString(i))){
                    current = edge.end;
                    break;
                }
            }

        }
        return current.isValid;
    }



    public static void main(String[] args){
        DFA dfa = new DFA();
        System.out.println(dfa.isVisited("IMF"));


    }

}
