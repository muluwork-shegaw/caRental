package cs489.project.carrental.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableCarReqDto {
    private Long vehicleId;
    private Long branchId;


}
