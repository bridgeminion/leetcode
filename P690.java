import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    Map<Integer, Integer> map = new HashMap<>();

    public int solve (List<Employee> employees, int id){
        int ans = employees.get(map.get(id)).importance;
        for (int i : employees.get(map.get(id)).subordinates){
            ans += solve(employees, i);
        }
        return ans;
    }

    public int getImportance(List<Employee> employees, int id) {
        for (int i=0; i < employees.size(); i++){
            map.put(employees.get(i).id, i);
        }
        return solve (employees, id);
    }
}
