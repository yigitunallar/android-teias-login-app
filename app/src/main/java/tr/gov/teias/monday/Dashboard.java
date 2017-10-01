package tr.gov.teias.monday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pronious on 25/09/2017.
 */

public class Dashboard {

    private Boolean success;
    private List<Project> projects = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
