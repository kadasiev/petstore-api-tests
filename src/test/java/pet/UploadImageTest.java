package pet;

import static api.PetApi.addPet;
import static api.PetApi.deletePet;
import static api.PetApi.uploadImage;
import static data.PetFactory.newPet;

import java.io.File;
import models.pet.Pet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadImageTest {

  private static final File TEST_IMAGE = new File("src/test/resources/test_image.png");
  private Pet pet;

  @BeforeEach
  public void setUp() {
    pet = newPet();
    addPet(pet).then()
        .statusCode(200);
  }

  @AfterEach
  public void tearDown() {
    try {
      deletePet(pet.getId());
    } catch (Exception ignored) {
    }
  }

  @Test
  public void shouldUploadImage() {
    uploadImage(pet.getId(), TEST_IMAGE).then()
        .statusCode(200);
  }
}
