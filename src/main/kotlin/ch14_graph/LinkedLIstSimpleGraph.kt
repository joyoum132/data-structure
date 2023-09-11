package ch14_graph
import java.util.LinkedList

class LinkedLIstSimpleGraph(node: Int) {
    private val adjacencyList: Array<LinkedList<Int>> = Array(node) { LinkedList() }

    fun addEdge(start: Int, end: Int) {
        adjacencyList[start].add(end)
    }

    fun printEdge() {
        adjacencyList.forEachIndexed { index, ints ->
            ints.forEach {
                println("${(index+65).toChar()} to ${(it+65).toChar()}")
            }
        }
    }
}