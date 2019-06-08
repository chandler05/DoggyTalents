package doggytalents.talent;

import java.util.Collection;

import doggytalents.DoggyTalentsMod;
import doggytalents.ModTalents;
import doggytalents.api.inferface.Talent;
import doggytalents.entity.EntityDog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;

/**
 * @author ProPercivalalb
 */
public class HunterDogTalent extends Talent {

	public static void onLootDrop(EntityLivingBase living, Entity source, Collection<EntityItem> drops) {
		if(source instanceof EntityDog) {
			EntityDog dog = (EntityDog)source;
			int level = dog.TALENTS.getLevel(ModTalents.HUNTER_DOG);

			if(dog.getRNG().nextInt(10) < level + (level == 5 ? 1 : 0)) {
				DoggyTalentsMod.LOGGER.debug("EXTRA DROP");
				for(EntityItem entityItem : drops)
					living.entityDropItem(entityItem.getItem().copy(), 0.0F);
			}
				
		}
	}
}
