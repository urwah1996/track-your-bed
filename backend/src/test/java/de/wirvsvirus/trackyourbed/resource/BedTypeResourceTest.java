package de.wirvsvirus.trackyourbed.resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import de.wirvsvirus.trackyourbed.BedStateService;
import de.wirvsvirus.trackyourbed.BedTypeService;
import de.wirvsvirus.trackyourbed.dto.response.BedTypeDto;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

@DisplayName("Tests for BedTypeResourceTest")
class BedTypeResourceTest {
  @Nested
  @DisplayName("Test calls to getAllBedTypes")
  class GetAllBedTypes {
    @Test
    @DisplayName("Should return a response entity containing all bed types" +
        "in its body and with status set to ok")
    void shouldReturnResponseEntityWithAllBedTypesInBodyAndStatusSetToOK() {
      //GIVEN
      final BedTypeService bedStateService = mock(BedTypeService.class);
      final String bedTypeOneName = "one";
      final String bedTypeTwoName = "two";
      final BedTypeDto  bedOne = new BedTypeDto();
      final BedTypeDto  bedTwo = new BedTypeDto();
      bedOne.setName(bedTypeOneName);
      bedTwo.setName(bedTypeTwoName);
      final Collection<BedTypeDto> allBedTypes = List.of(
          bedOne,
          bedTwo
      );
      when(bedStateService.getAllBedTypes()).thenReturn(allBedTypes);

      final ResponseEntity<Collection<BedTypeDto>> expected = ResponseEntity.ok(allBedTypes);

      //WHEN
      final ResponseEntity<Collection<BedTypeDto>> actual = new BedTypeResource(bedStateService).getAllBedTypes();

      //THEN
      assertEquals(actual,expected);
    }

  }

  @Nested
  @DisplayName("Test calls to getBedTypeByName")
  class GetBedTypeNameTest {

    @Test
    @DisplayName("Should return a response entity containing the correct name" +
        "in its body and with status set to ok")
    void shouldReturnResponseEntityWithCorrectBedTypeAndStatusSetToOkWhenCalledWithName (){

      //GIVEN
      final BedTypeService bedTypeService = mock(BedTypeService.class);
      final String name = "name";
      final BedTypeDto bedTypeDto = new BedTypeDto();
      bedTypeDto.setName(name);
      final ResponseEntity<BedTypeDto> expected = ResponseEntity.ok(bedTypeDto);
      when(bedTypeService.getBedTypeByName(name)).thenReturn(bedTypeDto);

      //WHEN
      final ResponseEntity<BedTypeDto> actual = new BedTypeResource(bedTypeService).getBedTypeByName(name);

      //THEN
      assertEquals(actual,expected);
    }
  }




  @Test
  void getBedTypeByName() {
  }
}