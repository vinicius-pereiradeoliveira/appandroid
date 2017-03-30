package appsind.atom.com.br.appandroidsind.model;

/**
 * Created by vinicius.oliveira on 30/03/2017.
 */

public class Campaigns {

    public Long id;

    public String name;

    public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Campanha: " + name + " Descrição: " +
                description;
    }
}
