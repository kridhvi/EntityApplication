package EntityApp;
import java.util.*;


// Interface Entity with three methods

public interface Entity {
	
    // Returns a unique identifier
    String getID();

    // Returns the sub-entities of this entity
    Set<Entity> getSubEntities();

    // Returns a set of key-value data belonging to this entity
    Map<String,String> getData();
}

