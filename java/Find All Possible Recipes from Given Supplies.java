// Find All Possible Recipes from Given Supplies - 2115
import java.util.*;

class Solution {
    // Finds all possible recipes that can be made with the given supplies.
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        // Graph to map each ingredient to the recipes that require it
        Map<String, List<String>> g = new HashMap<>();
        
        // Map to track the number of ingredients needed for each recipe
        Map<String, Integer> indeg = new HashMap<>();
        
        // Build the graph and initialize the indegree map
        for (int i = 0; i < recipes.length; ++i) {
            for (String v : ingredients.get(i)) {
                g.computeIfAbsent(v, k -> new ArrayList<>()).add(recipes[i]);
            }
            indeg.put(recipes[i], ingredients.get(i).size());
        }
        
        // Queue to process available supplies
        Deque<String> q = new ArrayDeque<>();
        for (String s : supplies) {
            q.offer(s);
        }
        
        // List to store the recipes that can be made
        List<String> ans = new ArrayList<>();
        
        // Process the queue
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; --n) {
                String i = q.pollFirst();
                
                // Check each recipe that requires the current ingredient
                for (String j : g.getOrDefault(i, Collections.emptyList())) {
                    // Decrease the indegree count for the recipe
                    indeg.put(j, indeg.get(j) - 1);
                    
                    // If all ingredients for a recipe are available, add it to the result
                    if (indeg.get(j) == 0) {
                        ans.add(j);
                        q.offer(j);
                    }
                }
            }
        }
        
        return ans;
    }
}