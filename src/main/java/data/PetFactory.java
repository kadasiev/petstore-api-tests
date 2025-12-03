package data;

import java.util.List;
import java.util.Random;
import models.pet.Category;
import models.pet.Pet;
import models.pet.Tag;

public class PetFactory {

  private static final Random RANDOM = new Random();

  public static Pet newPet() {
    Category category = new Category();
    category.setId(RANDOM.nextInt(1000) + 1);
    category.setName("Category name-" + RANDOM.nextInt(1000) + 1);

    List<String> photoUrlsList = List.of("Photo name for test");

    Tag tag = new Tag();
    tag.setId(RANDOM.nextInt(1000) + 1);
    tag.setName("Tag name-" + RANDOM.nextInt(1000) + 1);
    List<Tag> tagsList = List.of(tag);

    Pet pet = new Pet();
    pet.setId(RANDOM.nextInt(1000) + 1);
    pet.setCategory(category);
    pet.setName("Pet name-" + RANDOM.nextInt(1000) + 1);
    pet.setPhotoUrls(photoUrlsList);
    pet.setTags(tagsList);
    pet.setStatus("available");

    return pet;
  }
}
