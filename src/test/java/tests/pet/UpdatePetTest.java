package tests.pet;

import static api.PetApi.addPet;
import static api.PetApi.deletePet;
import static api.PetApi.getPet;
import static api.PetApi.updatePet;
import static data.PetFactory.newPet;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import models.pet.Pet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdatePetTest {

  private Pet pet;
  private static final String PETS_NEW_NAME = "Changed name";

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
  public void shouldUpdatePetWhenValidPayloadProvided() {
    getPet(pet.getId()).then()
        .body("name", not(PETS_NEW_NAME));

    pet.setName(PETS_NEW_NAME);

    updatePet(pet).then()
        .statusCode(200)
        .body("id", equalTo(pet.getId()))
        .body("name", equalTo(PETS_NEW_NAME));

    getPet(pet.getId()).then()
        .body("name", equalTo(PETS_NEW_NAME));
  }
}
