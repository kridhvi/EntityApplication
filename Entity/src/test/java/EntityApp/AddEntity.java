package EntityApp;

import java.util.*;
import com.google.common.collect.ImmutableBiMap;
import org.junit.BeforeClass;
import org.junit.Test;


public class AddEntity {

    private static EntityData entityData;

    @BeforeClass
    public static void init() {
    	entityData = new EntityData();
    }
   
    
    //Add Entity to Root
    @Test
    public void addRoot() {
        String entId = "ID4";
        entityData.sendRoot(EntityClass.builder().ID(entId).data(ImmutableBiMap.of("k1","val1","k2","val2")).build());
    }
    
    // Add Entity to another Entity and get Entity List from Parent Entity
    @Test
    public void addSubEntity() {
        String parentId = "ID1";
        String entityId = "ID5";
        entityData.addEntities(parentId, EntityClass.builder().ID(entityId).data(ImmutableBiMap.of("k5","value5")).build());
        //Adding subEntity to parent
        String subValue = (new ArrayList<Entity>(entityData.getUniqueID(parentId).getSubEntities())).get(0).getData().get("k5");
        //return subValue;
    }

}
