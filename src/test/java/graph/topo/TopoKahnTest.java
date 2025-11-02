package graph.topo.scc;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TopoKahnTest {

    @Test
    public void testSimpleDAG() {
        // build edges for DAG 0->1, 0->2, 1->3, 2->3
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0,1});
        edges.add(new int[]{0,2});
        edges.add(new int[]{1,3});
        edges.add(new int[]{2,3});
        int[] order = TopoKahn.sort(4, edges);
        // Validate order is topological: position of u < position of v for each edge u->v
        Map<Integer,Integer> pos = new HashMap<>();
        for (int i=0;i<order.length;i++) pos.put(order[i], i);
        for (int[] e: edges) assertTrue(pos.get(e[0]) < pos.get(e[1]));
    }
}
