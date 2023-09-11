package ch14_graph

class MatrixSimpleGraph(node: Int) {
    private val graph: Array<Array<Int>> = Array(node) { Array(node) {0} }

    fun addEdge(start: Int, end: Int) {
        graph[start][end] = 1
        graph[end][start] = 1
    }

    fun printEdge() {
        graph.forEach { arr ->
            arr.forEach { print("$it ") }
            println()
        }
    }

}