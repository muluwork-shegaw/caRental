package cs489.project.carrental.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DurationReqDto {
    LocalDateTime startDate;
    LocalDateTime endDate;
}
