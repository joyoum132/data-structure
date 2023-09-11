import ch14_graph.LinkedLIstSimpleGraph
import ch14_graph.MatrixSimpleGraph

fun main() {
    callCh14()

}

fun callCh14() {
    println("인접행렬로 구현한 무방향 그래프")
    MatrixSimpleGraph(5).apply {
        addEdge(0, 1)
        addEdge(0, 2)
        addEdge(0, 3)
        addEdge(1, 3)
        addEdge(2, 3)
        addEdge(2, 4)
        printEdge()
    }

    println("""

        연결리스트로 구현한 그래프
    """.trimIndent())
    LinkedLIstSimpleGraph(5).apply {
        addEdge(0, 1)
        addEdge(0, 2)
        addEdge(0, 3)
        addEdge(1, 3)
        addEdge(2, 3)
        addEdge(2, 4)
        printEdge()
    }

    println("""

        연결리스트로 구현한 DFS 그래프
    """.trimIndent())
    val graph = LinkedLIstSimpleGraph(7).apply {
        addEdge(0,1)
        addEdge(0,3)
        addEdge(1,0)
        addEdge(1,2)
        addEdge(2,1)
        addEdge(2,3)
        addEdge(3,0)
        addEdge(3,2)
        addEdge(3,4)
        addEdge(4,3)
        addEdge(4,5)
        addEdge(4,6)
        addEdge(5,4)
        addEdge(6,4)
        printEdge()
    }

    graph.dfs(0)
    graph.recursiveDfs(0)
    graph.bfs(4)
}
