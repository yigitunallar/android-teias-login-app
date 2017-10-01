package tr.gov.teias.monday;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pronious on 25/09/2017.
 */

public class Helper {
    public static List<String> parseProjects (List<Project> dashboard){
        List<String> titles = new ArrayList<>();

        for(Project project: dashboard){
            titles.add(project.getTitle());
        }

        return titles;
    }

}
