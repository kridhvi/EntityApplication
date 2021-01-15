package EntityApp;

import java.util.*;
import io.advantageous.qbit.annotation.PathVariable;
import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/* List the Entities
 * Send Entity to Root and SubEntity
 * Get Unique Identifier
 * Get list of SubEntities
 * Get the key-value data of the Entity
 */

@RequestMapping("/entity")
public class EntityData {
// List to get list of Entites	
    private List<Entity> entityEntries = new ArrayList<>();
//Map to store the Entity data
    private HashMap<String, Entity> entityData = new HashMap<>();

 //Send an Entity to Root
   
    @RequestMapping(value = "/sendRoot", method = RequestMethod.POST)
    public void sendRoot(final EntityClass ent) {
    	entityEntries.add(ent);
    	entityData.put(ent.getID(), ent);
    }

 //Add SubEntities and attach entity to the subEntity
 
    @RequestMapping(value = {"/add/{id}"}, method = RequestMethod.POST)
    public void addEntities(@PathVariable("id") String id, final EntityClass ent) {
       //Attach to another entity
        Set<Entity> subEntityEntries = entityData.get(id).getSubEntities();
        //Check if sub Entities exist and add new subEntities
        if (subEntityEntries == null) 
        {
        	subEntityEntries = new HashSet<>();
            ((EntityClass)entityData.get(id)).setSubEntities(subEntityEntries);
        }
        
 //Add sub Entity
        subEntityEntries.add(ent);
        
  //Add to Entity data
        entityData.put(ent.getID(), ent);
    }
 
 //Return the Entity Entries
 
    @RequestMapping("/getEntityList")
    public List<Entity> getEntityList() {
        return entityEntries;
    }
 
 //Return Unique ID of Entity
      @RequestMapping(value = "/get/{id}")
      public Entity getUniqueID(@PathVariable("id") String id) {
          return entityData.get(id);
      }

//Passing Initial values
    public  EntityData() {
    	HashMap<String, String> entityValues = new HashMap<>();
    	
        Entity e1 = EntityClass.builder().ID("ID1").build();
        Entity e2 = EntityClass.builder().ID("ID2").build();
        entityEntries.add(e1);
        entityData.put(e1.getID(), e1);
        entityEntries.add(e2);
        entityData.put(e2.getID(), e2);

        entityValues.put("Entity1", "Value1");
        entityValues.put("Entity2","Value2");
        Entity eVAl = EntityClass.builder().ID("ent2").data(entityValues).build();
        entityEntries.add(eVAl);
        entityData.put(eVAl.getID(), eVAl);
    }
}

