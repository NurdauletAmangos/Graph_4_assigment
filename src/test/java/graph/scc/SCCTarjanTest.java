package graph.topo.scc;

import graph.scc.SCCTarjan;
import graph.util.Graph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SCCTarjanTest {

    @Test
    void testSimpleCycle() {
        Graph g = new Graph(3);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 0, 1);

        SCCTarjan scc = new SCCTarjan(g);
        SCCTarjan.Result result = scc.run();

        assertEquals(1, result.components.size());
    }
}
