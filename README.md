# Smart Scheduler — Assignment 4 (Java)

## Overview
This project implements the algorithms requested in Assignment 4:
- **Strongly Connected Components (SCC)** using Tarjan's algorithm.
- **Condensation graph** (component DAG).
- **Topological ordering** using Kahn's algorithm on the condensation DAG.
- **Single-source shortest paths** and **longest path (critical path)** on a DAG using DP over topological order.
- Simple instrumentation (timing + counters).

Weight model: **edge-based** by default (edge `w`). Node durations are supported if input JSON uses `weight_model: "node"` and provides `durations`.

## Project structure
- /src/main/java
- /graph
- /generator-DatasetGenerator.java # dataset generator (manual run)
- /scc
- SCCTarjan.java
- /topo
- TopoKahn.java
- /dagsp
- DAGSP.java
- /util
- Metrics.java
- /util
- Graph.java
- App.java # main runner
- /src/test/java
- /graph/scc/SCCTarjanTest.java
- /graph/topo/TopoKahnTest.java
- /graph/dagsp/DAGSPTest.java
- pom.xml
- README.md


## Input format (`tasks.json`)
A JSON object with:
- `n` (optional): number of nodes (0..n-1)
- `edges`: array of objects `{ "u": <int>, "v": <int>, "w": <int> }`
- `weight_model`: `"edge"` or `"node"` (default: `"edge"`)
- `durations` (if `node` model): mapping of node index to duration
- `source` (optional): source node index for single-source SP

Example:
```json
{
  "n": 6,
  "edges":[ {"u":0,"v":1,"w":3}, {"u":1,"v":2,"w":2} ],
  "weight_model":"edge",
  "source":0
}
