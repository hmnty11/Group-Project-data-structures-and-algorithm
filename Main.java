import java.util.*;

// Kelas untuk merepresentasikan edge (sisi) dalam graph
class Edge {
    String destination;
    int weight;

    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Kelas Graph dengan adjacency list menggunakan HashMap (Hash Table)
class Graph {
    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan edge berarah (directed) dari source ke destination dengan bobot
    // tertentu
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
        // Untuk graph tidak berarah, tambahkan juga sebaliknya:
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge(source, weight));
    }

    // Algoritma Dijkstra untuk mencari jalur terpendek dari start ke end
    public void shortestPath(String start, String end) {
        if (!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end)) {
            System.out.println("Titik awal atau tujuan tidak ditemukan dalam jaringan.");
            return;
        }

        // HashMap untuk menyimpan jarak terpendek dari start ke setiap node
        Map<String, Integer> distances = new HashMap<>();
        // HashMap untuk menyimpan node sebelumnya dalam jalur terpendek
        Map<String, String> previous = new HashMap<>();
        // PriorityQueue untuk memilih node dengan jarak terkecil
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<String> visited = new HashSet<>();

        // Inisialisasi jarak semua node sebagai tak terhingga
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();
            if (visited.contains(current))
                continue;
            visited.add(current);

            // Jika sudah mencapai tujuan, bisa berhenti (opsional)
            if (current.equals(end))
                break;

            for (Edge edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (visited.contains(edge.destination))
                    continue;
                int newDist = distances.get(current) + edge.weight;
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previous.put(edge.destination, current);
                    pq.add(edge.destination);
                }
            }
        }

        // Cetak hasil
        if (distances.get(end) == Integer.MAX_VALUE) {
            System.out.println("Tidak ada jalur dari " + start + " ke " + end);
        } else {
            // Rekonstruksi jalur
            List<String> path = new ArrayList<>();
            String step = end;
            while (step != null) {
                path.add(step);
                step = previous.get(step);
            }
            Collections.reverse(path);
            System.out.print("Jalur terpendek ditemukan: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1)
                    System.out.print(" => ");
            }
            System.out.println("\nJarak total: " + distances.get(end) + " km");
        }
    }
}

// Program utama
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        // Membangun jaringan contoh (bisa disesuaikan)
        // Kota-kota (simpul) dan jalan (edge) dengan bobot dalam km
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "C", 3);
        graph.addEdge("B", "D", 8);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "E", 7);
        graph.addEdge("D", "E", 4);
        graph.addEdge("D", "F", 6);
        graph.addEdge("E", "F", 3);
        // Tambahkan node lain jika diinginkan

        System.out.println("=== Aplikasi Simulasi Jaringan dengan Graph ===");
        System.out.println("Daftar simpul (kota) yang tersedia:");
        System.out.println("A, B, C, D, E, F"); // Sesuaikan dengan data di atas

        System.out.print("Masukkan titik awal: ");
        String start = scanner.nextLine().trim().toUpperCase();
        System.out.print("Masukkan titik tujuan: ");
        String end = scanner.nextLine().trim().toUpperCase();

        graph.shortestPath(start, end);
        scanner.close();
    }
}