#include<iostream>
#include<cstring>
#include<list>
#include<iterator>
#define LOOP(n) for(int i=0;i<n;++i)

template<class Type>
class Graph {
private:
    int vn;
    std::list<int> *adj;
public:
    Graph(int v) {
        this->vn = v;
        this->adj = new std::list<int>[v];
    }

    void add_edge(const int & v, const int & w) {
        this->adj[v].push_back(w);
    }

    void BFS(int source) {
        bool *visited = new bool[this->vn];
        LOOP(vn)
            visited[i] = false;

        visited[source] = true;
        std::list<int> q;
        q.push_back(source);

        std::list<int>::iterator it;

        while(!q.empty()) {
            source = q.front();
            std::cout << source << " ";
            q.pop_front();
            for(it = adj[source].begin(); it != adj[source].end(); ++it) {
                if(!visited[*it]) {
                    visited[*it] = true;
                    q.push_back(*it);
                }
            }
        }
    }
};

int main() {

    Graph<int> g(4);
    g.add_edge(0, 1);
    g.add_edge(0, 2);
    g.add_edge(1, 2);
    g.add_edge(2, 0);
    g.add_edge(2, 3);
    g.add_edge(3, 3);

    std::cout << "Following is Breadth First Traversal (starting from vertex 2) \n";
    g.BFS(2);

	return 0;
}

