package de.wirvsvirus.trackyourbed.resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import de.wirvsvirus.trackyourbed.DepartmentService;
import de.wirvsvirus.trackyourbed.HospitalService;
import de.wirvsvirus.trackyourbed.dto.request.CreateNewDepartment;
import de.wirvsvirus.trackyourbed.dto.request.CreateNewHospital;
import de.wirvsvirus.trackyourbed.dto.response.DepartmentDto;
import de.wirvsvirus.trackyourbed.dto.response.HospitalDto;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

@DisplayName("Tests for HospitalResource")
class HospitalResourceTest {

  @Nested
  @DisplayName("Test calls to createHospital")
  class CreateHospitalTest {

    @Test
    @DisplayName("Should return a response entity containing the created link and hospitalDto" +
        "when called with createNewHospital")
    void ShouldReturnResponseEntityWithCreatedLinkAndHospitalDtoWhenCalledWithCreateNewHospital() {
      //GIVEN
      final HospitalService hospitalService = mock(HospitalService.class);
      final CreateNewHospital createNewHospital = mock(CreateNewHospital.class);
      final UUID id = UUID.randomUUID();
      final String createdLink = String.format("/api/hospitals/%s",id);
      final HospitalDto hospitalDto = new HospitalDto();
      hospitalDto.setId(id);
      when(hospitalService.createHospital(createNewHospital)).thenReturn(hospitalDto);
      final ResponseEntity<HospitalDto> expected = ResponseEntity
          .created(URI.create(createdLink))
          .body(hospitalDto);

      //WHEN
      final ResponseEntity<HospitalDto> actual = new HospitalResource(hospitalService).createHospital(createNewHospital);

      //THEN
      assertEquals(expected,actual);
    }
  }
}