package ru.geekbrains.lesson7;

public class Homework {

    public static void main(String[] args) {
        Graph<City> graph = createCityGraph();
        Dijkstra<City> dijkstra = new Dijkstra<>();
        Path<City> path = dijkstra.findPath(graph, City.MOSCOW, City.VORONEZH);
        path.display();
    }

    private static Graph<City> createCityGraph() {
        Graph<City> graph = new Graph<>();
        for (City city : City.values()) {
            graph.addVertex(city);
        }
        graph.addEdge(City.MOSCOW, City.TULA, 173);
        graph.addEdge(City.TULA, City.LIPETSK, 219);
        graph.addEdge(City.LIPETSK, City.VORONEZH, 108);
        graph.addEdge(City.MOSCOW, City.RYAZAN, 183);
        graph.addEdge(City.RYAZAN, City.TAMBOV, 240);
        graph.addEdge(City.TAMBOV, City.SARATOV, 339);
        graph.addEdge(City.SARATOV, City.VORONEZH, 472);
        graph.addEdge(City.MOSCOW, City.KALUGA, 162);
        graph.addEdge(City.KALUGA, City.OREL, 172);
        graph.addEdge(City.OREL, City.KURSK, 137);
        graph.addEdge(City.KURSK, City.VORONEZH, 207);
        return graph;
    }

    private enum City {
        MOSCOW,
        TULA,
        LIPETSK,
        VORONEZH,
        RYAZAN,
        TAMBOV,
        SARATOV,
        KALUGA,
        OREL,
        KURSK
    }
}
