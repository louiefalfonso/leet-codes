/*
 * Team Dominance by Pass Success - 3384
 */

 
class TeamDominance {
    public static String findDominantTeam(String[] teams) {
        String dominantTeam = "";
        double maxSuccessRate = -1.0;

        for (String team : teams) {
            String[] parts = team.split(" ");
            String teamName = parts[0];
            double successRate = Double.parseDouble(parts[1]);

            // Check if this team has a higher success rate
            if (successRate > maxSuccessRate) {
                maxSuccessRate = successRate;
                dominantTeam = teamName;
            }
        }

        return dominantTeam;
    }
}