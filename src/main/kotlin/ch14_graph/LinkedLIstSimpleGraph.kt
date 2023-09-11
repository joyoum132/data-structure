package ch14_graph
import java.util.*

class LinkedLIstSimpleGraph(node: Int) {
    private val adjacencyList: Array<LinkedList<Int>> = Array(node) { LinkedList() }

    private val visited = BooleanArray(node) { false } //node 방문 여부
    private var stack = Stack<Int>()
    private var queue: Queue<Int> = LinkedList()

    fun addEdge(start: Int, end: Int) {
        adjacencyList[start].add(end)
    }

    fun dfs(start: Int) {
        stack.push(start)
        while (stack.isNotEmpty()) {
            /*
            * 방문하지 않은 노드라면 방문 처리를 완료하고
            * 해당 노드와 인접한 모든 노드를 스택에 넣는다.
            * 스택은 FILO 이기때문에 탐색의 방향이 leaf로 간다
            * */
            val current = stack.pop()
            if(!visited[current]) {
                visited[current] = true
                println("${(current+65).toChar()} 방문")
                val itr = adjacencyList[current].iterator()
                while(itr.hasNext()) {
                    val n = itr.next()
                    if(!visited[n]) stack.push(n)
                }
            }
        }
    }

    fun recursiveDfs(start: Int) {
        visited[start] = true
        println("${(start+65).toChar()} 방문")

        val iterator = adjacencyList[start].iterator()
        while(iterator.hasNext()) {
            val next = iterator.next()
            if(!visited[next]) {
                recursiveDfs(next)
            }
        }
    }

    fun bfs(start: Int) {
        queue.add(start)

        while(queue.isNotEmpty()) {
            val n = queue.poll()
//                queue.remove() // queue == isEmpty 인 경우 throw

            if(!visited[n]) {
                visited[n] = true
                println("${(n+65).toChar()} 방문")

                val iterator = adjacencyList[n].iterator()
                while(iterator.hasNext()) {
                    val next = iterator.next()
                    /* FIFO 인 큐를 사용하기때문에 형제노드를 먼저 탐색하고
                    * 그 이후에 자녀 노드를 탐색하여 leaf까지 간다.
                    * */
                    if(!visited[next]) {
                        queue.add(next)
                    }
                }
            }
        }
    }
    fun printEdge() {
        adjacencyList.forEachIndexed { index, ints ->
            ints.forEach {
                println("${(index+65).toChar()} to ${(it+65).toChar()}")
            }
        }
    }
}