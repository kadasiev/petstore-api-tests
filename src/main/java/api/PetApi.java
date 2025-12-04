package api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.io.File;
import models.pet.Pet;

public class PetApi extends BaseApi {

  public static Response addPet(Pet pet) {
    return given()
        .contentType("application/json")
        .body(pet)
    .when()
        .post("/v2/pet");
  }

  public static Response getPet(int petId) {
    return given()
        .pathParams("petID", petId)
    .when()
        .get("/v2/pet/{petID}");
  }

  public static Response updatePet(Pet pet) {
    return given()
        .contentType("application/json")
        .body(pet)
    .when()
        .put("/v2/pet");
  }

  public static Response deletePet(int petId) {
    return given()
        .pathParams("petID", petId)
    .when()
        .delete("/v2/pet/{petID}");
  }

  public static Response uploadImage(int petId, File image) {
    return given()
        .pathParams("petId", petId)
        .multiPart("file", image)
    .when()
        .post("/v2/pet/{petId}/uploadImage");

  }
}
