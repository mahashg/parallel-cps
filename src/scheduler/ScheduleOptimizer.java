// package scheduler;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// import org.jgrapht.graph.DefaultEdge;
// import org.jgrapht.DirectedGraph;
// import org.jgrapht.graph.ListenableDirectedGraph;
// import org.jgrapht.alg.TransitiveClosure;

// import scheduler.Activation;

// public class ScheduleOptimizer {

//     public ListenableDirectedGraph<Activation, DefaultEdge> optimizedSchedule;
    
//     public ListenableDirectedGraph<Activation, DefaultEdge> makeEfficientGraph_using_partial_order_set(final ListenableDirectedGraph<Activation, DefaultEdge> graph){
//         removeTransitiveEdges(graph);
        
// 	ListenableDirectedGraph<Activation, DefaultEdge> newGraph
//                 = new ListenableDirectedGraph<Activation, DefaultEdge>(DefaultEdge.class);
		
//         // all the vertex set.
//         Set<Activation> _vertex_set = graph.vertexSet();
		
//         Set<Activation> _root_vertex_set = new HashSet<Activation>();
//         Map<Activation, Boolean> _found_map = new HashMap<Activation, Boolean>();
		
//         for(Activation _act : _vertex_set){
//             //System.out.println("vertex added");
//             newGraph.addVertex(_act);
//             _found_map.put(_act, false);
//             if(graph.inDegreeOf(_act) == 0){
//                 _root_vertex_set.add(_act);
//             }
//         }
		
//         List<Activation> _list = new ArrayList<Activation>();
//         for(Activation _act : _vertex_set){
//             _list.add(_act);
//         }
		
//         while(!_list.isEmpty()){
//             //System.out.println("node.");
//             Activation _act = _list.remove(0);			
//             Set<DefaultEdge> _def_edge_set = graph.outgoingEdgesOf(_act);
			
//             for(DefaultEdge _def_edge : _def_edge_set){
//                 Activation _dest = graph.getEdgeTarget(_def_edge);
//                 if(_found_map.containsKey(_dest) && _found_map.get(_dest) == false){
//                     _found_map.put(_dest, true);
//                     //			_list.add(_dest);
					
//                     Activation srcEdge = graph.getEdgeSource(_def_edge);
//                     Activation destEdge = graph.getEdgeTarget(_def_edge);
					
//                     if(srcEdge == destEdge || newGraph.containsEdge(destEdge, srcEdge) || newGraph.containsEdge(srcEdge, destEdge)){
//                         // Reflextion
//                         continue;
//                     }
//                     newGraph.addEdge(srcEdge, destEdge);
//                 }
//             }
//         }
		
//         return newGraph;
//     }

//     // /** 
//     //  * Get the transitive closure of the graph and remove all the
//     //  * edges in the original graph which...
//     //  *
//     //  * This whole idea was wrong.
//     //  * 
//     //  * @param Activation 
//     //  * @param graph 
//     //  */
//     // public void removeTransitiveEdges(
//     //     ListenableDirectedGraph<Activation, DefaultEdge> graph){
        
//     //     ListenableDirectedGraph<Activation, DefaultEdge> clonedGraph =
//     //             getClone(graph);
        
//     //     closeDirectedGraph(clonedGraph);
//     //     System.out.println("clonedGraph: " + clonedGraph);
//     // }

//     // /** 
//     //  * Note: graph should not be modified.
//     //  *
//     //  * @return a ListenableDirectedGraph having the same nodes and structure as graph.
//     //  */
//     // public ListenableDirectedGraph<Activation, DefaultEdge> getClone(
//     //     ListenableDirectedGraph<Activation, DefaultEdge> graph){

//     //     ListenableDirectedGraph<Activation, DefaultEdge> clonedGraph =
//     //             new ListenableDirectedGraph<Activation, DefaultEdge>(DefaultEdge.class);
//     //     for (Activation node : graph.vertexSet()){
//     //         clonedGraph.addVertex(node);
//     //     }

//     //     for (DefaultEdge edge : graph.edgeSet()){
//     //         clonedGraph.addEdge(graph.getEdgeSource(edge),
//     //                             graph.getEdgeTarget(edge));
//     //     }
//     //     return clonedGraph;
//     // }

//     // /**
//     //  * Computes the transitive closure of the given graph.
//     //  *
//     //  * NOTE: This modifies `graph`.
//     //  *
//     //  * @param graph - Graph to compute transitive closure for.
//     //  *
//     //  * From TransitiveClosure.
//     //  */
//     // public <V, E> void closeDirectedGraph(DirectedGraph<V, E> graph)
//     // {
//     //     Set<V> vertexSet = graph.vertexSet();

//     //     Set<V> newEdgeTargets = new HashSet<V>();

//     //     // At every iteration of the outer loop, we add a path of length 1
//     //     // between nodes that originally had a path of length 2. In the worst
//     //     // case, we need to make floor(log |V|) + 1 iterations. We stop earlier
//     //     // if there is no change to the output graph.

//     //     int bound = computeBinaryLog(vertexSet.size());
//     //     boolean done = false;
//     //     for (int i = 0; !done && (i < bound); ++i) {
//     //         done = true;
//     //         for (V v1 : vertexSet) {
//     //             newEdgeTargets.clear();

//     //             for (E v1OutEdge : graph.outgoingEdgesOf(v1)) {
//     //                 V v2 = graph.getEdgeTarget(v1OutEdge);
//     //                 for (E v2OutEdge : graph.outgoingEdgesOf(v2)) {
//     //                     V v3 = graph.getEdgeTarget(v2OutEdge);

//     //                     if (v1.equals(v3)) {
//     //                         // Its a simple graph, so no self loops.
//     //                         continue;
//     //                     }

//     //                     if (graph.getEdge(v1, v3) != null) {
//     //                         // There is already an edge from v1 ---> v3, skip;
//     //                         continue;
//     //                     }

//     //                     newEdgeTargets.add(v3);
//     //                     done = false;
//     //                 }
//     //             }

//     //             for (V v3 : newEdgeTargets) {
//     //                 graph.addEdge(v1, v3);
//     //             }
//     //         }
//     //     }
//     // }

//     // /**
//     //  * Computes floor(log_2(n)) + 1
//     //  */
//     // private int computeBinaryLog(int n)
//     // {
//     //     assert n >= 0;

//     //     int result = 0;
//     //     while (n > 0) {
//     //         n >>= 1;
//     //         ++result;
//     //     }

//     //     return result;
//     // }
// }
