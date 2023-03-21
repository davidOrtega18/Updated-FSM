
public class NFA {

    public static void  main(String[] args){
        NFA nfa = new NFA();
        System.out.println(nfa.isValidSentence("aabb"));
        System.out.println(nfa.isValidSentence("babb"));
        System.out.println(nfa.isValidSentence("aaabb"));
    }

    DirectedGraph<Object> dg = new DirectedGraph<>();

    public NFA(){


        dg.addEdge("q0", "q1", "a");
        dg.addEdge("q0", "q4", "b");

        dg.addEdge("q1", "q1", "a");
        dg.addEdge("q1", "q2", "b");

        dg.addEdge("q2", "q3", "b");
        dg.addEdge("q2", "q1", "a");

        dg.addEdge("q3", "q1", "a");
        dg.addEdge("q3", "q4", "b");

        dg.addEdge("q4", "q4", "b");
        dg.addEdge("q4", "q1", "a");

        dg.getVertex("q3").isValid = true;

    }


    /**
     * This method will check if the sentence is valid
     * @param sentence  the sentence to be checked
     * @return true if the sentence is valid, false otherwise
     */
    public boolean isValidSentence(String sentence){
        char[] chars = sentence.toCharArray();
        return isValidSentence(chars, dg.getVertex("q0"), 0);
    }

    /**
     * This method will check if the sentence is valid
     * @param chars the sentence to be checked
     * @param current the current vertex
     * @param index the current index
     * @return true if the sentence is valid, false otherwise
     */

    public boolean isValidSentence(char[] chars, DirectedGraph<Object>.Vertex<Object> current, int index){
        if(index == chars.length){
            return current.isValid;
        }
        boolean search = false;
        for(DirectedGraph<Object>.Edge<Object> edge : current.edges){
            if(edge.weight.equals(Character.toString(chars[index]))){
                search = isValidSentence(chars, edge.end, index + 1);
                if(search) return true;
            }
        }
        return false;
    }

}
