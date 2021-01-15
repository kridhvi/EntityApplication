package EntityApp;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

//Class that implements the Entity Interface

@Data
@Builder
public class EntityClass implements Entity {
    private String ID;
    private Set<Entity> subEntities;
    private Map<String,String> data;
}

