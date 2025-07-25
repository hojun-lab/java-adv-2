package reflection;

import reflection.data.Team;
import reflection.data.User;

public class FieldV3 {
    public static void main(String[] args) {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== Before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        if (user.getName() == null) {
            user.setName("");
        }

        if (user.getAge() == null) {
            user.setAge(0);
        }

        if (team.getId() == null) {
            team.setId("");
        }

        if (team.getName() == null) {
            team.setName("");
        }

        if (team.getId() == null) {
            team.setId("");
        }

        System.out.println("===== After =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
    }
}
