//package cs489.project.carrental.unitTest;
//
//import cs489.project.carrental.DTO.VehicleDto;
//import cs489.project.carrental.controller.VehicleController;
//import cs489.project.carrental.service.VehicleService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class VehicleControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private VehicleService vehicleService;
//
//    @InjectMocks
//    private VehicleController vehicleController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testRegisterVehicle() throws Exception {
//        VehicleDto vehicleDto = new VehicleDto();
//        vehicleDto.setMake("Toyota");
//        vehicleDto.setModel("Corolla");
//
//        when(vehicleService.saveVehicle(any(VehicleDto.class))).thenReturn(vehicleDto);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/vehicles/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"make\": \"Toyota\", \"model\": \"Corolla\" }"))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }
//
//    @Test
//    public void testGetVehicleById() throws Exception {
//        Long vehicleId = 1L;
//        VehicleDto vehicleDto = new VehicleDto();
//        vehicleDto.setMake("Toyota");
//        vehicleDto.setModel("Camry");
//
//        when(vehicleService.getVehicleById(vehicleId)).thenReturn(vehicleDto);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/{vehicleId}", vehicleId)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.make").value("Toyota"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Camry"));
//    }
//
//    // Add more integration test methods for other controller endpoints...
//
//}
